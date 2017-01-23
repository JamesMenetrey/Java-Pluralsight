package schultz.dustin.io;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.PostConstruct;
import java.io.File;

/**
 * Entry point and configuration of the Spring Boot app.
 *
 * We manually exclude some auto-configuration (such as Jackson) for the application. They are automatically
 * enabled (from the auto-configuration report) and useless for this project.
 */
@SpringBootApplication(exclude = {JacksonAutoConfiguration.class, JmxAutoConfiguration.class, WebSocketAutoConfiguration.class})
public class JustGifItApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustGifItApplication.class, args);
    }
}
