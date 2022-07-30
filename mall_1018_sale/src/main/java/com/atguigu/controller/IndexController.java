package com.atguigu.controller;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.OBJECT_T_MALL_SKU;
import com.atguigu.service.AttrService;
import com.atguigu.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("goto_list")
    public String goto_list(int flbh2, ModelMap map){

        List<OBJECT_T_MALL_ATTR> list_attr =new ArrayList<>();
        List<OBJECT_T_MALL_SKU> list_sku = new ArrayList<>();

        //flbh2属性 集合
        list_attr = attrService.get_attr_list(flbh2);

        //flbh2商品列表
        list_sku = listService.get_list_by_flbh2(flbh2);

        map.put("list_attr",list_attr);
        map.put("list_sku",list_sku );
        map.put("flbh2",flbh2);
        return "list";

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
