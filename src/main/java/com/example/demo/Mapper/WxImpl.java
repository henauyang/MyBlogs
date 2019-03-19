package com.example.demo.Mapper;

import com.example.demo.pojo.Wx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class WxImpl implements WxMapper{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Wx> findAll() {
        List <Wx> wxList= jdbcTemplate.query("select   *  from tb_area  order by  priority desc",new BeanPropertyRowMapper<>(Wx.class));
        return wxList;
    }
    @Override
    public Wx queryWxById(int wxId) {
        List<Wx> wxList = jdbcTemplate.query("select   *  from tb_area where wxId = ?",new Object[]{wxId}, new BeanPropertyRowMapper<>(Wx.class));
        if (wxList!=null&&wxList.size()>0){
            Wx wx = wxList.get(0);
            return wx;
        }else {
            return null;
        }
    }

    @Override
    public void insertWx(String wxName, Integer priority, Date createTime, Date lastEditTime) {
        jdbcTemplate.update("INSERT INTO tb_area(wxName,priority,createTime,lastEditTime) VALUES (?,?,?,?)", wxName, priority, createTime, lastEditTime);
    }

    @Override
    public void updateUser(Integer wxId,String wxName, Integer priority, Date lastEditTime) {
        jdbcTemplate.update("UPDATE tb_area SET wxName = ?,priority=?,lastEditTime = ?WHERE wxId =?",  wxName,priority,lastEditTime,wxId);
    }

    @Override
    public void deleteWx(int wxId) {
        jdbcTemplate.update("delete from tb_area where wxId=?",wxId);
    }

}
