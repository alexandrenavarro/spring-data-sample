package com.github.springdatasample.persistence;

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
public interface DealRepository extends CrudRepository<Deal, Integer>{

}
