package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "comp.example.demo.mysql.repository",entityManagerFactoryRef = "mysqlEntityManagerFactory",transactionManagerRef = "mysqlTransactionManager")
public class MySqlRepositoryConfig {

}
