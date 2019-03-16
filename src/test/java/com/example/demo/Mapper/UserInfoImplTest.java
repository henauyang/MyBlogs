package com.example.demo.Mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserInfoImplTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void avgId() {
        int count = jdbcTemplate.queryForObject("select avg(id) from news_data", Integer.class);
        System.out.println(count);
    }
}