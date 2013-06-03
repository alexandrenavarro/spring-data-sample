package com.github.springdatasample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import com.github.springdatasample.persistence.PersitenceConfig;

/**
 * <p>AppConfiguration. </p>
 * 
 * @author anavarro - Jun 3, 2013
 * 
 */
@Configuration
@Import({ PersitenceConfig.class/*, WebConfig.class */})
public class AppConfig {

    /**
     * propertySourcesPlaceholderConfigurer.
     * 
     * @return
     */
    static @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
        ClassPathResource[] resourceLocations = new ClassPathResource[] { new ClassPathResource("spring-data-sample.properties"), };
        p.setLocations(resourceLocations);
        return p;
    }
}
