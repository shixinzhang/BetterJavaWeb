package com.fruitsalesplatform.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangshixin on 19/8/7.
 */
public abstract class BaseController {
    /**
     * 此方法用于日期的转换，若页面日期格式转换错误，将报 400
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setLenient(true);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
    }
}
