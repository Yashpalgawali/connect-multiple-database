package com.example.demo.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

@Configuration
public class JPAConfig {

	@Primary
    @Bean(name = "mysqlEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactory(

            @Qualifier("mysqlDataSource") DataSource dataSource) {

	  	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

	  	Map<String, Object> properties = new HashMap<>();
	  	
	  	properties.put("spring.jpa.show-sql", true);
	  	properties.put("hibernate.format_sql", true);
	  	properties.put("hibernate.hbm2ddl.auto", "update");
	  	properties.put("spring.jpa.hibernate.ddl-auto", "update");
	  	
	  	LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);  // Set the data source
        
        factoryBean.setPackagesToScan("com.example.demo.mysql.entity"); // Your JPA entities' package
        factoryBean.setJpaVendorAdapter(vendorAdapter); // Set the JPA vendor
        factoryBean.setPersistenceUnitName("mysql");  // Set the persistence unit name
        
        factoryBean.setJpaPropertyMap(properties);
        
        // Explicitly setting the Hibernate dialect
        factoryBean.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");

        return factoryBean;
    }

	@Bean(name = "postgresEntityManagerFactory")
    LocalContainerEntityManagerFactoryBean postgresEntityManagerFactory(

            @Qualifier("postgresDataSource") DataSource dataSource) {

	  	JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	  
 	Map<String, Object> properties = new HashMap<>();
	  	
	  	properties.put("spring.jpa.show-sql", true);
	  	properties.put("hibernate.format_sql", true);
	  	properties.put("hibernate.hbm2ddl.auto", "update");
	  	properties.put("spring.jpa.hibernate.ddl-auto", "update");
	  	
	  	LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);  // Set the data source
        factoryBean.setPackagesToScan("com.example.demo.postgres.entity"); // Your JPA entities package
        factoryBean.setJpaPropertyMap(properties);
        
        factoryBean.setJpaVendorAdapter(vendorAdapter); // Set the JPA vendor
        factoryBean.setPersistenceUnitName("postgres");  // Set the persistence unit name
        factoryBean.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        
        return factoryBean;
    }
	
	@Bean(name="mysqlTransactionManager")
	PlatformTransactionManager mysqlTransactionManager(@Qualifier("mysqlEntityManagerFactory") EntityManagerFactory factory) {
		
		return new JpaTransactionManager(factory);
	}
	
	@Bean(name="postgresTransactionManager")
	PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresEntityManagerFactory") EntityManagerFactory factory) {
		
		return new JpaTransactionManager(factory);
	}


}
