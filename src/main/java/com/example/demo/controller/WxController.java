package com.example.demo.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.pojo.Wx;
import com.example.demo.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/superadmin")
public class WxController {
    @Autowired
    private WxService wxService = new WxService();

    /**
     * 获取所有的区域信息
     *
     * @return
     */
    @RequestMapping(value = "/listarea", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Wx> list = new ArrayList<Wx>();
        // 获取区域列表
        list =wxService.findAll();
        modelMap.put("areaList", list);
        return modelMap;
    }

    /**
     * 通过区域Id获取区域信息
     *
     * @return
     */
    @RequestMapping(value = "/getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer wxId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 获取区域信息
        Wx wx = wxService.queryWxById(wxId);
        System.out.println(wx.getWxId());
        modelMap.put("area", wx);
        return modelMap;
    }

    /**
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Wx wx)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", wxService.insertWx(wx));
        return modelMap;
    }

    /**

     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Wx wx)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", wxService.updateWx(wx));
        return modelMap;
    }

    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer wxId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", wxService.deleteWx(wxId));
        return modelMap;
    }

}
