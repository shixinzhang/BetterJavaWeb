package com.fruitsalesplatform.controller;

import com.alibaba.fastjson.JSONObject;
import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 零售商控制器，处理：列表请求、
 * Created by zhangshixin on 19/8/13.
 */
@Controller
public class RetailerController extends BaseController{
    @Autowired
    private RetailerService retailerService;

    @RequestMapping("/retailer/editRetailer.action")
    @ResponseBody
    public Retailer editRetailer(@RequestBody String json) {
        String id = JSONObject.parseObject(json).getString("id");
        //ResponseBody 将返回 json
        return retailerService.get(id);
    }

    @RequestMapping("/retailer/edit.action")
    public String edit(Model model, Retailer retailer) {
        org.apache.log4j.Logger.getLogger("zsx").info("retailer info: " + retailer);

        retailerService.update(retailer);


        Retailer queryRetailer = new Retailer();
        queryRetailer.setStartPage(retailer.getStartPage());
        queryRetailer.setCurrentPage(retailer.getCurrentPage());
        queryRetailer.setPageSize(retailer.getPageSize());
        queryRetailer.setStatus(-1);

        //回到  list 页面
        return list(model, queryRetailer);
    }

    @RequestMapping("/retailer/list.action")
    public String list(Model model, Retailer retailer) {
        Map<String, Object> map = retailerToMap(retailer);
        List<Retailer> retailers = retailerService.find(map);

        model.addAttribute("list", retailers);
        //当前页数
        model.addAttribute("currentPage", retailer.getCurrentPage());
        //当前请求位置
        model.addAttribute("startPage", retailer.getStartPage());

        int countNumber = retailerService.count(map);
        //数据总和
        model.addAttribute("countNumber", countNumber);

        int pageSize = retailer.getPageSize();
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("listStatus", -1);

        //总页数
        int sumPageNumber = countNumber % pageSize == 0
                ? countNumber / pageSize
                : countNumber / pageSize + 1;
        model.addAttribute("sumPageNumber", sumPageNumber);

        return "/retailer/retailerHome.jsp";
    }

    private Map<String, Object> retailerToMap(Retailer retailer) {
        Map<String, Object> map = new HashMap<>();
        if (retailer.getName() != null) {
            map.put("name", checkString(retailer.getName()));
        }

        if (retailer.getAddress() != null) {
            map.put("address", checkString(retailer.getAddress()));
        }
        if (retailer.getTelephone() != null) {
            map.put("telephone", checkString(retailer.getTelephone()));
        }
        map.put("startPage", retailer.getStartPage());
        map.put("pageSize", retailer.getPageSize());
        map.put("status", retailer.getStatus());

        return map;
    }

    private String checkString(String param) {
        return param == null ? null :
                param.equals("") ? null : ("%" + param + "%");
    }


}
