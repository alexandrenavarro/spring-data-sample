package com.github.springdatasample;
import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>App. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
public class App {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    
    /**
     * main.
     *
     * @param args
     */
    public static void main(String[] args)
    {
        LOGGER.info("Application is starting");
        final long startTime = System.currentTimeMillis();
        
        // Hack to start Tomcat >= 7.0.20 quicker
        System.setProperty("java.security.egd", "file:/dev/./urandom");

        try
        {
            final Tomcat tomcat = new Tomcat();
            final String appBase = (new File("./src/main/webapp")).getAbsolutePath();
            tomcat.setPort(8080);
            tomcat.setBaseDir("target");
            tomcat.getHost().setAppBase(appBase);
            tomcat.addWebapp("/spring-data-sample", appBase);
            tomcat.start();
            LOGGER.info("Application started in " + (System.currentTimeMillis() - startTime) + " ms");
            tomcat.getServer().await();
        }
        catch (LifecycleException exception)
        {
            LOGGER.error("exception=" + exception);
        }
        catch (ServletException exception)
        {
            LOGGER.error("exception=" + exception);
        }
        
    }

}
