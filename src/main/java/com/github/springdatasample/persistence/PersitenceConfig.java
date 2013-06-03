package com.github.springdatasample.persistence;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.support.PersistenceExceptionTranslator;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.springdatasample.Deal;
import com.jolbox.bonecp.BoneCPDataSource;

/**
 * <p>Configuration. </p>
 *
 * @author anavarro - Jun 3, 2013
 *
 */
@Configuration
@EnableJpaRepositories("com.github.springdatasample.persistence")
@EnableTransactionManagement
public class PersitenceConfig {
    
    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PersitenceConfig.class);
    
    @Value("${driverClassName}")
    private String driverClassName;
 
    @Value("${jdbcUrl}")
    private String jdbc;
 
    @Value("${username}")
    private String username;
 
    @Value("${password}")
    private String password;
 
    
    /**
     * dataSource.
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        BoneCPDataSource dataSource = new BoneCPDataSource();
        dataSource.setJdbcUrl(this.jdbc);
        dataSource.setDriverClass(this.driverClassName);
        dataSource.setUsername(this.username);
        dataSource.setPassword(this.password);
        return dataSource;
    }
    
    /**
     * entityManagerFactory.
     *
     * @return
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
      HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
      vendorAdapter.setGenerateDdl(true);
      final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
      factory.setJpaVendorAdapter(vendorAdapter);
      factory.setPackagesToScan("com.github.springdatasample");
      factory.setDataSource(dataSource());
      factory.afterPropertiesSet();
      return factory.getObject();
    }
    
    @Bean 
    public PersistenceExceptionTranslator persistenceExceptionTranslator() { 
      return new HibernateExceptionTranslator(); 
    }

    /**
     * transactionManager.
     *
     * @return
     */
    @Bean
    public PlatformTransactionManager transactionManager() {
      JpaTransactionManager txManager = new JpaTransactionManager();
      txManager.setEntityManagerFactory(entityManagerFactory());
      return txManager;
    }

}
