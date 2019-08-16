package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by zhangshixin on 19/8/7.
 */
@Controller
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @GetMapping("/user/toLogin.action")
    public String toLogin() {
        //转向登录页面
        return "/login.jsp";
    }

    @PostMapping("/user/login.action")
    public String login(User user, Model model, HttpServletRequest request) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        UserService userService1 = (UserService) context.getBean("userService");

        Map<String,String> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        List<User> users = userService.find(map);

        if (users != null && users.size() > 0) {
            //找到了这个人，登录成功，到首页
            request.getSession().setAttribute("user", users.get(0));
            request.getSession().setAttribute("tel", users.get(0).getTelephone());
            return "/home.jsp";
        }

        //带着错误信息回到登录页
        model.addAttribute("errorMsg", "登录失败！账号或密码错误！");
        model.addAttribute("noticeMsg", "输入错误次数太多将导致封号！");
        return "/login.jsp";
    }

    @GetMapping("/user/registerPage.action")
    public String toRegister() {
        //转向注册页面
        return "/register.jsp";
    }

    @PostMapping("/user/register.action")
    public String register(User user, Model model, HttpServletRequest request,
                           HttpServletResponse response) {
        //1.先去查一下用户名是否被使用
        Map<String, String> params = new HashMap<>();
        params.put("username", user.getUsername());

        List<User> users = userService.find(params);
        if (users != null && users.size() > 0) {
            //已被注册侧，转发回注册页面
            model.addAttribute("errorMsg", "注册失败，用户名已被占用");
            return "/register.jsp";
        }

        //2.未注册，设置 uid 保存到数据库
        user.setUserid(UUID.randomUUID().toString());
        userService.insert(user);
        model.addAttribute("noticeMsg", "注册成功，请输入账号密码登录");
        return "/login.jsp";
    }

    
}
