package com.example.demo.service;

import com.example.demo.Mapper.WxMapper;
import com.example.demo.pojo.Wx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WxService {
    @Autowired
    WxMapper wxMapper;

    public List<Wx> findAll() {
        return wxMapper.findAll();
    }

    public Wx queryWxById(int wxId) {
        return wxMapper.queryWxById(wxId);
    }

    public void insertWx(String wxName, Integer priority, Date createTime, Date lastEditTime) {
        wxMapper.insertWx(wxName, priority, createTime, lastEditTime);
    }

    public void updateUser(Integer wxId, String wxName, Integer priority, Date lastEditTime) {
        wxMapper.updateUser(wxId, wxName, priority, lastEditTime);
    }

    public void deleteWx(int wxId) {
        wxMapper.deleteWx(wxId);
    }



}
