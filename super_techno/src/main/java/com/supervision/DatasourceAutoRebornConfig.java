/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supervision;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author kasun
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "receiveEntityManagerFactory",
        transactionManagerRef = "receiveTransactionManager", basePackages = {"com.supervision.auto_reborn.repository"})
public class DatasourceAutoRebornConfig {

    @Bean(name = "receiveDataSource")
    @ConfigurationProperties(prefix = "spring.autoreborn")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "receiveEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean receiveEntityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("receiveDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("com.supervision.auto_reborn.domain")
                .persistenceUnit("bar")
                .build();
    }

    @Bean(name = "receiveTransactionManager")
    public PlatformTransactionManager receiveTransactionManager(
            @Qualifier("receiveEntityManagerFactory") EntityManagerFactory receiveEntityManagerFactory) {
        return new JpaTransactionManager(receiveEntityManagerFactory);
    }

}
