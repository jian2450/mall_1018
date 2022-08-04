package com.atguigu.controller;

import com.atguigu.service.AttrService;
import com.atguigu.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author jian
 * @create 2022-07-16 17:28
 */
@Controller
public class IndexController {

    @Autowired
    private AttrService attrService;

    @Autowired
    private ListService listService;

    @RequestMapping("orderErr")
    public String orderErr(){
        return "orderErr";
    }

    @RequestMapping("goto_logout")
    public String goto_logout(HttpSession session){
        session.invalidate();
        return "redirect:/goto_login.do";
    }


    @RequestMapping("goto_login")
    public String goto_login(){

        return "login";
    }

    @RequestMapping("goto_login_checkOrder")
    public String goto_login_checkOrder(){

        return "loginOrder";
    }

    @RequestMapping("index")
    public String index(HttpServletRequest request, ModelMap map){

        /*String yh_mch="";
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0){
            for (int i = 0; i < cookies.length; i++) {
                String name = cookies[i].getName();
                if (name.equals("yh_mch")){
                    yh_mch = cookies[i].getValue();
                }
            }
        }
        map.put("yh_mch",yh_mch);*/

        return "index";
    }
}
