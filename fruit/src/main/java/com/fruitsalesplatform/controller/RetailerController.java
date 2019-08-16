package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.Retailer;
import com.fruitsalesplatform.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 零售商控制器，处理：列表请求、
 * Created by zhangshixin on 19/8/13.
 */
@Controller
public class RetailerController extends BaseController{
    @Autowired
    private RetailerService retailerService;

    @GetMapping("/retailer/list.action")
    public String list(Model model, Retailer retailer) {
        Map<String, Object> map = retailerToMap(retailer);
        List<Retailer> retailers = retailerService.find(map);

        model.addAttribute("list", retailers);

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

        return map;
    }

    private String checkString(String param) {
        return param == null ? null :
                param.equals("") ? null : ("%" + param + "%");
    }


}
