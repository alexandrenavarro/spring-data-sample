package com.github.springdatasample.ws.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.github.springdatasample.Deal;
import com.github.springdatasample.Deals;
import com.github.springdatasample.persistence.DealRepository;
import com.github.springdatasample.ws.DealResource;

/**
 * <p>DealResource. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
@Named(value="dealResource")
@Path("/deal/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JaxRsDealResource implements DealResource {
    
    @Inject
    private DealRepository dealRepository;
    
    
    
    /**
     * getDeals.
     *
     * @return
     */
//    @GET
//    public Deal[] getDeals() {
//        final List<Deal> dealList = new ArrayList<Deal>();
//        final Iterable<Deal> deals = this.dealRepository.findAll();
//        for (final Deal deal : deals) {
//            dealList.add(deal);
//        }
//        final Deal deal = new Deal();
//        deal.setDealCode("DealCode");
//        dealList.add(deal);
//        return dealList.toArray(new Deal[0]);
//    }
    
    /**
     * findBy.
     *
     * @param dealList1
     * @return
     */
    @GET
    //@Path("/deal/findBy")
    public Deal[] findBy(@QueryParam("deals") Deal[] dealList1) {
        System.out.println("dealList=" + dealList1);
        final List<Deal> dealList = new ArrayList<Deal>();
//        final Iterable<Deal> deals = this.dealRepository.findAll();
//        for (final Deal deal : deals) {
//            dealList.add(deal);
//        }
        final Deal deal = new Deal();
        deal.setDealCode("DealCode");
        dealList.add(deal);
        return dealList.toArray(new Deal[0]);
    }
    
    
    
    
    
}
