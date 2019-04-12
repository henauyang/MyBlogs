package com.example.demo.Mapper;

import com.example.demo.pojo.Wx;

import java.util.Date;
import java.util.List;

public interface WxMapper {

    List<Wx> findAll();


    Wx queryWxById(int wxId);


    boolean insertWx(Wx wx);


    boolean updateWx(Wx wx);


    boolean deleteWx(int wxId);
}
