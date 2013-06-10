package com.github.springdatasample.persistence;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityListeners;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.springdatasample.Deal;



/**
 * <p>DealRepository. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
/**
 * <p>DealRepository. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
@Repository
//@EntityListeners(value = AuditingEntityListener.class)
//@EntityListeners(value=LastUpdateListener.class)

public interface DealRepository extends CrudRepository<Deal, Integer>{


    Iterable<Deal> findByLastModifiedDateGreaterThanEqual(final Timestamp dealCodee);
    
    
    Iterable<Deal> findByDealCode(String dealCode);
    
}
