package com.example.demo.service;

import com.example.demo.Mapper.UserDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserDataService {
    @Autowired
    UserDataMapper userDataMapper;

    public void installUser(String name, String password, String realName, String birth, String email, String phone, String address, int postcode){
        userDataMapper.installUser(name,password,realName,birth,email,phone,address,postcode);
    }
}
