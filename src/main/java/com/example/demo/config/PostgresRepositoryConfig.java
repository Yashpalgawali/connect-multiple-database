package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories( basePackages = "comp.example.demo.postgres.repository",
						entityManagerFactoryRef = "postgresEntityManagerFactory",
						transactionManagerRef = "postgreTransactionManager")
public class PostgresRepositoryConfig {

}
