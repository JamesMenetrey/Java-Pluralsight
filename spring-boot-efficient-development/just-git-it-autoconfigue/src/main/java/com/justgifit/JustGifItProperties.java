package com.justgifit;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.File;

/**
 * Defines the configuration properties that can be used in the application's properties in the main application.
 * More information about Configuration meta-data: http://docs.spring.io/spring-boot/docs/current/reference/html/configuration-metadata.html.
 */
@ConfigurationProperties(prefix = "com.justgifit")
public class JustGifItProperties {

    /**
     * The location of the animated gifs.
     */
    private File gifLocation;
    /**
     * Whether or not to optimize web filters.
     */
    private Boolean optimize;
    /**
     * Whether or not the directory where the generated gifs are stored must be created at the startup of the application.
     *
     * Spring Boot is able to use relax naming convention to enable the corresponding bean (look at the method in the AutoConfiguration,
     * the name attached is "create-result-dir").
     */
    private Boolean createResultDir;

    public Boolean getCreateResultDir() {
        return createResultDir;
    }

    public void setCreateResultDir(Boolean createResultDir) {
        this.createResultDir = createResultDir;
    }

    public Boolean getOptimize() {
        return optimize;
    }

    public void setOptimize(Boolean optimize) {
        this.optimize = optimize;
    }

    public File getGifLocation() {
        return gifLocation;
    }

    public void setGifLocation(File gifLocation) {
        this.gifLocation = gifLocation;
    }
}
