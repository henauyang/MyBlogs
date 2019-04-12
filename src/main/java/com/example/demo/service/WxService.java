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

    public boolean insertWx(Wx wx) {
        wxMapper.insertWx(wx);
        return false;
    }

    public boolean updateWx(Wx wx) {
        wxMapper.updateWx(wx);
        return false;
    }

    public boolean deleteWx(int wxId) {
        wxMapper.deleteWx(wxId);
        return false;

    }



}
