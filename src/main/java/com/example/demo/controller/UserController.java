package com.example.demo.controller;

import com.example.demo.pojo.Page;
import com.example.demo.pojo.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

//    /**
//     * 添加新闻
//     *
//     * @param title 新闻头
//     * @param bt 标题
//     * @param content 内容
//     * @param ower 发表者
//     */

//    @RequestMapping("/avg")//跳转增加页面
//    public String  avg(Model model){
//        int coun =userService.avgId();
//
//        model.addAttribute("avg",coun);
//        System.out.println(coun);
//        return "index";
//    }
    @RequestMapping("/creat")//跳转增加页面
    public String creat(){
        return "backstagemanagement/creat";
    }

    @PostMapping("/createUser")//添加成功后跳转页面
    public String createUser(@RequestParam("title") String title, @RequestParam("bt") String bt, @RequestParam("content") String content,@RequestParam("ower")String ower, Model model) {
        userService.createUser(title, bt,content,ower);

        model.addAttribute("msg","添加成功");

        List<UserInfo> u=userService.findAll();
        model.addAttribute("userinfo",u);
        return "backstagemanagement/listall";
    }

    @PostMapping("/success")//登录成功进入后台
    public String success(Model model){
        model.addAttribute("success","登陆成功！！");

        List<UserInfo> u=userService.findAll();
        model.addAttribute("userinfo",u);
        return "backstagemanagement/listall";
    }
//
//
    @RequestMapping("/index")//后台首页跳转
    public String  index() {
        return "news";
    }

    @RequestMapping("/findAll")//前端主页面跳转
    public String findAll(ModelMap model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        model.addAttribute("msg","欢迎光临！！");
        List<UserInfo> u=userService.findAll();
        if (pageNum==0){
            pageNum=1;
        }
        Page<UserInfo> page=new Page<>(pageNum,u);
        model.addAttribute("pageInfo",page);

        int coun =userService.avgId();
        model.addAttribute("avg",coun);

        return "index";
    }

//    /**
//     * 更新用户信息
//     *
//     *
//     */

    @RequestMapping("/update")//跳转修改界面
    public String update(@RequestParam("id") Integer id,Model model){
        model.addAttribute("msg","修改id");
        model.addAttribute("userinfo",userService.getUser(id));

        return "backstagemanagement/update";
    }

    @PostMapping("/updateUser")//修改成功跳转页面
    public String update(@RequestParam("id") Integer id,@RequestParam("title") String title, @RequestParam("bt") String bt, @RequestParam("content") String content,@RequestParam("ower")String ower,Model model){
        userService.updateUser(id,title, bt,content,ower);

        model.addAttribute("msg","修改成功");

        List<UserInfo> u=userService.findAll();
        model.addAttribute("userinfo",u);
        return "backstagemanagement/listall";
    }

//

    @RequestMapping("/look_one")//前端查看单条数据界面
    public String look_Front(@RequestParam("id") Integer id,Model model){

//        userService.getUser(id);
        model.addAttribute("msg","查看id");
//        userService.getUser(id);
        model.addAttribute("userinfo",userService.getUser(id));

        return "look_one";
    }
//
//    @PostMapping("/lookover_one")//从单条返回前端首页面
//    public String lookover_Front(ModelMap model){
////        model.addAttribute("msg","查看结束！！！");
//
//        List<UserInfo> w = userService.findAll();
//        model.addAttribute("userinfo",w);
//        return "index";
//    }
//

    @RequestMapping("/look")//查看单条数据界面
    public String look(@RequestParam("id") Integer id,Model model){

//        userService.getUser(id);
        model.addAttribute("msg","查看id");
//        userService.getUser(id);
        model.addAttribute("userinfo",userService.getUser(id));

        return "backstagemanagement/look";
    }

    @PostMapping("/lookover")//从单条返回首页面
    public String lookover(Model model){
        model.addAttribute("msg","查看结束！！！");

        List<UserInfo> w = userService.findAll();
        model.addAttribute("userinfo",w);
        return "backstagemanagement/listall";
    }
//
//
//
//    /**
//     * 获取新闻信息
//     * param ower 发表者
//     * @return
//     */
////    @GetMapping("/getUser")
////    public String listall(Model model){
////        model.addAttribute("msg","数据库数据!!!!!");
////        List<UserInfo> u=userService.findAll();
////        model.addAttribute("userinfo",u);
////        return "listall";
////    }
//
////    @GetMapping("/getUser/{id}")
////    public UserInfo getUser(@PathVariable("id") Integer id) {
////        return userService.getUser(id);
////    }
//
    @RequestMapping("/delete")//打开删除制定内容页面
    public String delete(@RequestParam("id") Integer id,Model model){
        model.addAttribute("msg","删除id");
        model.addAttribute("userinfo",userService.getUser(id));
        return "backstagemanagement/delete";
    }
    @PostMapping("/deleteUserByUserId")//删除成功返回页面
    public String deleteUserByUserId(@RequestParam("id") Integer id,Model model) {
        userService.deleteUserByUserId(id);

        model.addAttribute("msg","删除成功");

        List<UserInfo> u=userService.findAll();
        model.addAttribute("userinfo",u);
        return "backstagemanagement/listall";
    }
//    /**
//    *主页面跳转；
//    **/
//    @RequestMapping("/login")//
//    public String login(Model model){
//        List<UserInfo> u=userService.findAll();
//        model.addAttribute("userinfo",u);
//        return "listall";
//    }
//    @GetMapping("/findAll")
//    public String findAll(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
//        PageHelper.startPage(pageNum,5);
//        List<UserInfo> list = userService.findAll();
//        PageInfo<UserInfo> u = new PageInfo<UserInfo>(list);
//        model.addAttribute("usernfo",u);
//        return "listall";
//    }
}