package com.github.springdatasample.web.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.github.springdatasample.Deal;
import com.github.springdatasample.persistence.DealRepository;
import com.github.springdatasample.web.DealResource;

/**
 * <p>DealResource. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
@Named(value="dealResource")
@Path("/deal/")
public class JaxRsDealResource implements DealResource {
    
    @Inject
    private DealRepository dealRepository;
    
    
    /**
     * getDeals.
     *
     * @return
     */

    @GET
    public List<Deal> getDeals() {
        final List<Deal> dealList = new ArrayList<Deal>();
        final Deal deal = new Deal();
        deal.setDealCode("DealCode");
        dealList.add(deal);
        return dealList;
    }
    
    
}
