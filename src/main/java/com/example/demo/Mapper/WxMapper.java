package com.example.demo.Mapper;

import com.example.demo.pojo.Wx;

import java.util.Date;
import java.util.List;

public interface WxMapper {

    List<Wx> findAll();


    Wx queryWxById(int wxId);


    void insertWx(String wxName,Integer priority,Date createTime,Date lastEditTime);


    void updateUser(Integer wxId,String wxName,Integer priority,Date lastEditTime);


    void deleteWx(int wxId);
}
