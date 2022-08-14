package com.atguigu.controller;

import com.atguigu.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private LogService logService;

    @RequestMapping("index")
    public String index(String string, ModelMap map){

        logService.log(string);
        map.put("string",string);
        return "index";
    }

}
