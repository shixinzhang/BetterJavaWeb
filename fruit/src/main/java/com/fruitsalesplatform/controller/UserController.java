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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            return "/home.jsp";
        }

        //带着错误信息回到登录页
        model.addAttribute("errorMsg", "登录失败！账号或密码错误！");
        return "/login.jsp";
    }
}
