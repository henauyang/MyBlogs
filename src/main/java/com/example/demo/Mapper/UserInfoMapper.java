package com.example.demo.Mapper;

import com.example.demo.pojo.UserInfo;


import java.util.List;

public interface UserInfoMapper {
    void createUser(String title, String bt,String content, String ower);

    UserInfo getUser(Integer id);

    void updateUser(Integer id,String title, String bt,String content, String ower);

    void deleteUserByUserId(Integer id);
    List<UserInfo> findAll();

    int avgId();

}