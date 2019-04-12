package com.example.demo.Mapper;

import com.example.demo.pojo.Wx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
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
    public boolean insertWx(Wx wx) {
        jdbcTemplate.update("INSERT INTO tb_area(wxName,priority,createTime,lastEditTime) VALUES (?,?,?,?)", wx.getWxName(), wx.getPriority(), wx.getCreateTime(), wx.getLastEditTime());
        return false;
    }

    @Override
    public boolean updateWx(Wx wx) {
        jdbcTemplate.update("UPDATE tb_area SET wxName = ?,priority=?,lastEditTime = ?WHERE wxId =?", wx.getWxName(), wx.getPriority(), wx.getLastEditTime(),wx.getWxId());
        return false;
    }

    @Override
    public boolean deleteWx(int wxId) {
        jdbcTemplate.update("delete from tb_area where wxId=?",wxId);
        return false;
    }

}
