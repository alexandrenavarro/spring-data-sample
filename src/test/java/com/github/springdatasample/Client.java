package com.github.springdatasample;

import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

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
        
        javax.ws.rs.client.Client client = ClientFactory.newClient();
        WebTarget target = client.target("http://example.com/shop");
        
        
        Form form = new Form().param("customer", "Bill").
        param("product", "IPhone 5").
        param("CC", "4444 4444 4444 4444"); 
        //Response response = target.request().post(Entity<T>.form(form)); 
        //assert response.getStatus() == 200;
        //Order order = response.readEntity(Order.class);
        LOGGER.info("Client stopped");
    }
}
