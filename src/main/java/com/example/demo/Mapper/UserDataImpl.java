package com.example.demo.Mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository//实现类，实现接口
public class UserDataImpl implements UserDataMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void installUser(String name, String password, String realName, String birth, String email, String phone, String address, int postcode) {
        jdbcTemplate.update("INSERT INTO user (name,password,realName,birth,email,phone,address,postcode) VALUES (?,?,?,?,?,?,?,?)",name,password,realName,birth,email,phone,address,postcode);
    }
}
