package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

	@Primary
	@Bean(name="mysqlDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.mysql")
	DataSource mysqlDataSource() {
			
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name="postgresDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.postgres")
	DataSource postgreSqlDataSource() {
		
		return DataSourceBuilder.create().build();
	}
}
