package com.example.demo.Mapper;

import com.example.demo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserInfoImpl implements UserInfoMapper {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void createUser(String title, String bt,String content,String ower) {
        jdbcTemplate.update("INSERT INTO news_data(title,bt,content,ower) VALUES (?,?,?,?)", title, bt, content, ower);
    }
    @Override
    public UserInfo getUser(Integer id) {
        List<UserInfo> userList = jdbcTemplate.query("select * FROM news_data WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(UserInfo.class));
        if (userList != null && userList.size() > 0) {
            UserInfo user = userList.get(0);
            return user;
        } else {
            return null;
        }
    }

    @Override
    public void updateUser(Integer id, String title, String bt,String content,String ower) {
        jdbcTemplate.update("UPDATE news_data SET title = ?,bt=?,content = ?,ower = ?WHERE id =?",  title,bt,content,ower,id);
    }

    @Override
    public void deleteUserByUserId(Integer id) {
        jdbcTemplate.update("DELETE FROM news_data WHERE id = ?", id);
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userList = jdbcTemplate.query("select   *  from  news_data order by  create_time desc", new BeanPropertyRowMapper<>(UserInfo.class));
        return userList;
    }

    @Override
    public int avgId() {
        int count = jdbcTemplate.queryForObject("select avg(id) from news_data", Integer.class);

        return count;

    }


}