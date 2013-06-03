package com.github.springdatasample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Client. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
public class Client {

    private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
    
    /**
     * main.
     *
     * @param args
     */
    public static void main(final String[] args) {
        LOGGER.info("Client started");
        
        LOGGER.info("Client stopped");
    }
}
