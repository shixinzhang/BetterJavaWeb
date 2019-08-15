package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 零售商控制器
 * Created by zhangshixin on 19/8/13.
 */
@Controller
public class RetailerController extends BaseController{
    @Autowired
    private RetailerService retailerService;

    @GetMapping("/retailer/list.action")
    public String list() {
        return "/home.jsp";
    }


}
