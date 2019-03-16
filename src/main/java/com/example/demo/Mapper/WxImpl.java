package com.example.demo.Mapper;

import com.example.demo.pojo.Wx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WxImpl implements WxMapper{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Wx> queryArea() {
        List <Wx> wxList= jdbcTemplate.query("select   *  from tb_area  order by  priority desc",new BeanPropertyRowMapper<>(Wx.class));
        return wxList;
    }

    @Override
    public Wx queryAreaById(int areaId) {
        return null;
    }

    @Override
    public int insertArea(Wx area) {
        return 0;
    }

    @Override
    public int updateArea(Wx area) {
        return 0;
    }

    @Override
    public int deleteArea(int areaId) {
        return 0;
    }
}
