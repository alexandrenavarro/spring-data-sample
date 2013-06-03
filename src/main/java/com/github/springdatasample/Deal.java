package com.github.springdatasample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>Deal. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
@Entity
@XmlRootElement
public class Deal {
    
    private Integer dealId;
    private String dealCode;
    private String dealLabel;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getDealId() {
        return this.dealId;
    }
    public void setDealId(Integer aDealId) {
        this.dealId = aDealId;
    }
    public String getDealCode() {
        return this.dealCode;
    }
    public void setDealCode(String aDealCode) {
        this.dealCode = aDealCode;
    }
    public String getDealLabel() {
        return this.dealLabel;
    }
    public void setDealLabel(String aDealLabel) {
        this.dealLabel = aDealLabel;
    }
    @Override
    public String toString() {
        return "Deal [dealId=" + this.dealId + ", dealCode=" + this.dealCode + ", dealLabel=" + this.dealLabel + "]";
    }
    
    
    
    
}
