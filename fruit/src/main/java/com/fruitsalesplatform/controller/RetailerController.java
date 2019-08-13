package com.fruitsalesplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by zhangshixin on 19/8/13.
 */
@Controller
public class RetailerController extends BaseController{

    @GetMapping("/retailer/list.action")
    public String list() {
        return "/home.jsp";
    }
}
