package com.example.demo.controller;

import com.example.demo.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/UserInstall")
@Controller
public class UserDataController {
    @Autowired
    UserDataService userDataService;


    @PostMapping("/install")//注册成功进入登录界面
    public String installUser(@RequestParam("name")String name, @RequestParam("password") String password, @RequestParam("realName")String realName, @RequestParam("birth")String birth, @RequestParam("email")String email, @RequestParam("phone") String phone, @RequestParam("address")String address, @RequestParam("postcode")int postcode, Model model){
        userDataService.installUser(name,password,realName,birth,email,phone,address,postcode);
        model.addAttribute("inst","添加成功！！");
        return "Login/login";
    }
    @RequestMapping("/Install")//直接进入注册界面
    public String Install(){
        return "Login/register";
    }

    @RequestMapping("/signin")//直接进入登录界面
    public String signin(){
        return "Login/login";
    }



}
