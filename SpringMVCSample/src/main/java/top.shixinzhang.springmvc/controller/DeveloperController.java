package top.shixinzhang.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.shixinzhang.springmvc.dao.DeveloperDao;
import top.shixinzhang.springmvc.model.CommonModel;
import top.shixinzhang.springmvc.model.DeveloperModel;

import java.util.List;

/**
 * Created by zhangshixin on 19/4/7.
 */
@Controller
@RequestMapping("/developer")
public class DeveloperController {

    private DeveloperDao developerDao;

    @Autowired
    public DeveloperController(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }

    @RequestMapping(value = "/api/hello", method = RequestMethod.GET)
    public String hello() {
        //返回的是  jsp 的路径
        return "hello";
    }

    @RequestMapping(value = "/api/all", method = RequestMethod.GET)
    @ResponseBody
    public CommonModel getAllDevelopers() {
        List<DeveloperModel> allDevelopers = developerDao.getAllDevelopers();
        CommonModel commonModel = new CommonModel();
        if (allDevelopers != null && allDevelopers.size() > 0) {
            commonModel.setSuccess();
            commonModel.setData(allDevelopers);
        } else {
            commonModel.setFail();
        }

        return commonModel;
    }

}
