package com.example.demo.Mapper;

import com.example.demo.pojo.Wx;

import java.util.List;

public interface WxMapper {
    /**
     * 列出区域列表
     *
     * @return areaList
     */
    List<Wx> queryArea();

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    Wx queryAreaById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area
     * @return
     */
    int insertArea(Wx area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Wx area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);
}
