package com.justgifit;

import com.justgifit.services.ConverterService;
import com.justgifit.services.GifEncoderService;
import com.justgifit.services.VideoDecoderService;
import com.madgag.gif.fmsware.AnimatedGifEncoder;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.inject.Inject;

/**
 * Custom auto configuration for the application Just Gif it.
 *
 * A dedicated spring.factories has been written so the autowiring mechanism can resolve the beans from here.
 *
 * More information about custom auto configuration: http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-auto-configuration.html.
 */
@Configuration
// Check if the class below exists and only execute this configuration if this is the case.
@ConditionalOnClass({FFmpegFrameGrabber.class, AnimatedGifEncoder.class})
// Indicate the class that must be used to resolve the injected configuration properties.
// We can use @Component on the class to use as well, if the component scan is configured accordingly.
@EnableConfigurationProperties(JustGifItProperties.class)
public class JustGifItAutoConfiguration {

    /**
     * Injected using the annotation @EnableConfigurationProperties.
     */
    @Inject
    private JustGifItProperties properties;

    /**
     * Creates the gifs directory. The annotation determines if the create-result-dir is specified in the application's properties.
     * The configuration property relies on its definition in the class JustGifItProperties.
     */
    @Bean
    @ConditionalOnProperty(prefix = "com.justgifit", name = "create-result-dir")
    public Boolean createResultDir() {
        // We are able to directly inject a File instance, thanks to YAML configuration
        if (!properties.getGifLocation().exists()) {
            properties.getGifLocation().mkdir();
        }

        return true;
    }

    @Bean
    // With this bean is not defined yet, this configuration will be used.
    @ConditionalOnMissingBean(VideoDecoderService.class)
    public VideoDecoderService videoDecoderService() {
        return new VideoDecoderService();
    }

    @Bean
    @ConditionalOnMissingBean(GifEncoderService.class)
    public GifEncoderService gifEncoderService() {
        return new GifEncoderService();
    }

    @Bean
    @ConditionalOnMissingBean(ConverterService.class)
    public ConverterService converterService() {
        return new ConverterService();
    }

    @Configuration
    @ConditionalOnWebApplication
    public static class WebConfiguration {

        @Value("${multipart.location}/gif/")
        private String gifLocation;

        @Bean
        @ConditionalOnProperty(prefix = "com.justgifit", name = "optimize")
        public FilterRegistrationBean deRegisterHiddenHttpMethodFilter(HiddenHttpMethodFilter filter) {
            FilterRegistrationBean bean = new FilterRegistrationBean(filter);
            bean.setEnabled(false);
            return bean;
        }

        @Bean
        @ConditionalOnProperty(prefix = "com.justgifit", name = "optimize")
        public FilterRegistrationBean deRegisterHttpPutFormContentFilter(HttpPutFormContentFilter filter) {
            FilterRegistrationBean bean = new FilterRegistrationBean(filter);
            bean.setEnabled(false);
            return bean;
        }

        @Bean
        @ConditionalOnProperty(prefix = "com.justgifit", name = "optimize")
        public FilterRegistrationBean deRegisterRequestContextFilter(RequestContextFilter filter) {
            FilterRegistrationBean bean = new FilterRegistrationBean(filter);
            bean.setEnabled(false);
            return bean;
        }

        @Bean
        public WebMvcConfigurer webMvcConfigurer() {
            return new WebMvcConfigurerAdapter() {
                @Override
                public void addResourceHandlers(ResourceHandlerRegistry registry) {
                    registry.addResourceHandler("/gif/**")
                            .addResourceLocations("file:" + gifLocation);
                    super.addResourceHandlers(registry);
                }
            };
        }
    }
}
