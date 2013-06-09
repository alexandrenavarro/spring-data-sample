package com.github.springdatasample;

import java.sql.Date;
import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.github.springdatasample.persistence.DealRepository;
import com.github.springdatasample.persistence.PersitenceConfig;

/**
 * <p>Main. </p>
 * 
 * @author anavarro - Jun 2, 2013
 * 
 */
public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * main.
     * 
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.info("start");
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        
        final DealRepository dealRepository = applicationContext.getBean(DealRepository.class);
        
        LOGGER.info("dealRepository.findAll()=" + dealRepository.findAll());

        final Deal deal = new Deal();
        deal.setDealCode("DealCode");
        deal.setDealLabel("DealLabel");
        //deal.setLastModifiedDateTime(new Date(0));
        dealRepository.save(deal);
        
        LOGGER.info("dealRepository.findOne(1)=" + dealRepository.findOne(1));
        
        final Deal deal2 = new Deal();
        deal2.setDealCode("DealCode2");
        deal2.setDealLabel("DealLabel2");
        dealRepository.save(deal2);
        
        LOGGER.info("dealRepository.findAll()=" + dealRepository.findAll());

        LOGGER.info("dealRepository.findByDealCode(\"DealCode\")=" + dealRepository.findByDealCode("DealCode"));
        
        LOGGER.info("dealRepository.findByLastModifiedDateTimeGreaterThan(\"DealCode\")=" + dealRepository.findByLastModifiedDateTimeGreaterThanEqual(new Date(System.currentTimeMillis())));
        LOGGER.info("dealRepository.findByLastModifiedDateTimeGreaterThan(\"DealCode\")=" + dealRepository.findByLastModifiedDateTimeGreaterThanEqual(new Date(System.currentTimeMillis() - 86400000)));
        
        
        LOGGER.info("stop");
    }

}
