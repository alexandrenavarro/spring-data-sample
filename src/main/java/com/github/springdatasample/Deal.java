package com.github.springdatasample;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.google.gson.Gson;

/**
 * <p>Deal. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
@Entity
@XmlRootElement
public class Deal {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Deal.class);
    
    @Column
    private Integer dealId;
    
    @Column(length = 1)
    private String dealCode;
    @Column
    private String dealLabel;
    
    //@CreatedDate
    //@Temporal(TemporalType.DATE)


    @Column
    //@Temporal(TemporalType.TIMESTAMP)
    @Type(type="date")
    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
    //@Temporal(TemporalType.DATE)
    private Date lastModifiedDateOld = new Date(System.currentTimeMillis());
    
    @Column
    @Type(type="timestamp")
    private Timestamp lastModifiedDate = new Timestamp(System.currentTimeMillis());
    
//    @Column
//    //@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
//    @Type(type="org.jadira.usertype.dateandtime.jsr310.PersistentLocalDateTime")
//    private LocalDateTime lastModifiedDateTime = new LocalDateTime();
    
    
    
//    @Column
//    @Type(type="timestamp")
//    private Timestamp dateTime = new Timestamp(System.currentTimeMillis());
    
    
    
    public Deal() {
        super();
    }
    
    public Deal(String deal) {
        super();
        
        LOGGER.info("deal=" + deal);
        
        Gson gson = new Gson();
        Deal deal1 = gson.fromJson(deal, Deal.class);
        this.setDealCode(deal1.getDealCode());
    }
    
    
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
    
    

    


    public Timestamp getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp aLastModifiedDate) {
        this.lastModifiedDate = aLastModifiedDate;
    }
    
    

    public Date getLastModifiedDateOld() {
        return this.lastModifiedDateOld;
    }

    public void setLastModifiedDateOld(Date aLastModifiedDateOld) {
        this.lastModifiedDateOld = aLastModifiedDateOld;
    }

//    public LocalDateTime getLastModifiedDateTime() {
//        return this.lastModifiedDateTime;
//    }
//
//    public void setLastModifiedDateTime(LocalDateTime aLastModifiedDateTime) {
//        this.lastModifiedDateTime = aLastModifiedDateTime;
//    }

    @Override
    public String toString() {
        return "Deal [dealId=" + this.dealId + ", dealCode=" + this.dealCode + ", dealLabel=" + this.dealLabel + ", lastModifiedDateOld="
                + this.lastModifiedDateOld + ", lastModifiedDate=" + this.lastModifiedDate 
                + "]";
    }
    
    


    
    
    
    
}
