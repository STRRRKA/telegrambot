package com.telegrambot.dao;

import com.telegrambot.models.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate){this.jdbcTemplate=jdbcTemplate;}

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM sqlperson", new BeanPropertyRowMapper<>(Person.class));

    }

}
