package com.github.springdatasample.ws;

import java.util.List;

import com.github.springdatasample.Deal;

/**
 * <p>DealResource. </p>
 *
 * @author anavarro - Jun 4, 2013
 *
 */
public interface DealResource {
    
    /**
     * getDeals.
     *
     * @return
     */
    public Deal[] findAll();
    
}
