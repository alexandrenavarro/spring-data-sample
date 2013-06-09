package com.github.springdatasample;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;


@XmlRootElement
@XmlSeeAlso(Deal.class)
public class Deals extends ArrayList<Deal> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Deals.class);
    
    public Deals() {
        super();
      }
    
    public Deals(String deal) {
        super();
        Gson gson = new Gson();
        List<Deal> deals = gson.fromJson(deal, List.class);
        this.setDeals(deals);
        
      }

      public Deals(Collection<? extends Deal> c) {
        super(c);
        LOGGER.info("c" + c);
      }

      // ======================================
      // =          Getters & Setters         =
      // ======================================

      @javax.xml.bind.annotation.XmlElement(name = "deal")
      public List<Deal> getDeals() {
        return this;
      }

      public void setDeals(List<Deal> deals) {
        this.addAll(deals);
      }
}
