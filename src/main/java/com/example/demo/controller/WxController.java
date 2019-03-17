package com.example.demo.controller;


import com.example.demo.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WxController {
    @Autowired
    private WxService wxService;


}
