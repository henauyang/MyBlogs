package com.example.demo.controller;

import com.example.demo.pojo.UserInfo;
import com.example.demo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {



    @Autowired
    private UserService userService;

    @Test
    public void createUser() throws Exception{
        userService.createUser("农大要闻","10月30日我校荣获农业机器人大赛特等奖","本网讯（通讯员 刘新萍）10月26-27日，2018中国农业机器人大赛在湖北武汉国际博览中心举行。本届赛事主题为“果园果实收获机器人”。我校机电工程学院副教授王秀山和王振锋指导的“智慧采摘”代表队荣获大赛特等奖，“创新机器人”代表队荣获大赛一等奖。","超级管理员");

    }

    @Test
    public void updateUser() {

    }

    @Test
    public void getUser() {

    }

    @Test
    public void deleteUserByUserId() {
    }

    @Test
    public void findAll(){
        Page page = PageHelper.startPage(2,3);
        List<UserInfo> list= userService.findAll();
        for (UserInfo userInfo:list){
            System.out.println(userInfo.getId()+" "+userInfo.getBt());
        }
        System.out.println("页大小"+page.getPageSize());
        System.out.println("页数"+page.getTotal());

    }
}