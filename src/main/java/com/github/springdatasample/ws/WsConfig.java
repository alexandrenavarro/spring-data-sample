package com.github.springdatasample.ws;

import javax.inject.Inject;
import javax.ws.rs.Produces;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.github.springdatasample.ws.jaxrs.WsJaxRsConfig;

/**
 * <p>WsConfiguration. </p>
 * 
 * @author anavarro - Jun 3, 2013
 * 
 */
@Configuration
@Import({ WsJaxRsConfig.class })
public class WsConfig {

    
    @Inject
    private DealResource dealResource;

    /**
     * restContainer.
     * 
     * @return
     */
    @Bean
    //@Produces
    public JAXRSServerFactoryBean restContainer() {
        final JAXRSServerFactoryBean jaxRSServerFactoryBean = new JAXRSServerFactoryBean();
        jaxRSServerFactoryBean.setServiceBeanObjects(this.dealResource);
        jaxRSServerFactoryBean.setAddress("/rest/");
        jaxRSServerFactoryBean.setProvider(new JacksonJsonProvider());
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
