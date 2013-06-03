package com.github.springdatasample.web;

import javax.inject.Inject;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.springdatasample.persistence.PersitenceConfig;
import com.github.springdatasample.web.jaxrs.WebJaxRsConfig;

/**
 * <p>WsConfiguration. </p>
 * 
 * @author anavarro - Jun 3, 2013
 * 
 */
@Configuration
@Import({ WebJaxRsConfig.class })
public class WebConfig {

    @Inject
    private DealResource dealResource;

    /**
     * restContainer.
     * 
     * @return
     */
    @Bean
    public JAXRSServerFactoryBean restContainer() {
        final JAXRSServerFactoryBean jaxRSServerFactoryBean = new JAXRSServerFactoryBean();
        jaxRSServerFactoryBean.setServiceBeanObjects(this.dealResource);
        jaxRSServerFactoryBean.setAddress("/ws/");
        jaxRSServerFactoryBean.create();
        return jaxRSServerFactoryBean;
    }

    /**
     * cxf.
     * 
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        final SpringBus springBus = new SpringBus();
        return springBus;
    }
}
