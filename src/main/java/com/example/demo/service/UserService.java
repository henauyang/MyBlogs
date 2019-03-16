package com.example.demo.service;

import com.example.demo.Mapper.UserInfoMapper;
import com.example.demo.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public void createUser(String title, String bt, String content,String ower) {
        userInfoMapper.createUser(title, bt,content,ower);
    }

    public UserInfo getUser(Integer id) {
        return userInfoMapper.getUser(id);
    }

    public void updateUser(Integer id,String title, String bt, String content,String ower) {
        userInfoMapper.updateUser(id,title, bt,content,ower);
    }

    public void deleteUserByUserId(Integer id) {
        userInfoMapper.deleteUserByUserId(id);
    }
    public List<UserInfo> findAll()
    {
        return userInfoMapper.findAll();
    }

        public int avgId()
        {
            return  userInfoMapper.avgId();
        }

}