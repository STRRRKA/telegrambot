package com.telegrambot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class config {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:sqlitesample.db");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        return dataSource;
    }
   @Bean
   public JdbcTemplate jdbcTemplate(){
       return new JdbcTemplate(dataSource());
    }
}
