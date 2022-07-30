package com.atguigu.controller;

import com.atguigu.bean.MODEL_T_MALL_ATTR;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-13 18:20
 */
@Controller
public class AttrController {

    @Autowired
    private AttrService attrService;

    @RequestMapping("get_attr_list_json")
    @ResponseBody
    public List<OBJECT_T_MALL_ATTR> get_attr_list_json(int flbh2){

        List<OBJECT_T_MALL_ATTR> list_attr = new ArrayList<OBJECT_T_MALL_ATTR>();
        //根据flbh2获取属性列表
        list_attr = attrService.get_attr_list(flbh2);

//        map.put("flbh2",flbh2);
//        map.put("list_attr",list_attr);
        return list_attr;
    }

    @RequestMapping("get_attr_list")
    public String get_attr_list(int flbh2,ModelMap map){

        List<OBJECT_T_MALL_ATTR> list_attr = new ArrayList<OBJECT_T_MALL_ATTR>();
        //根据flbh2获取属性列表
        list_attr = attrService.get_attr_list(flbh2);

        map.put("flbh2",flbh2);
        map.put("list_attr",list_attr);
        return "attrListInner";
    }

    @RequestMapping("goto_attr_add")
    public String goto_attr_add(int flbh2, ModelMap map){

        map.put("flbh2",flbh2);
        return "attrAdd";
    }

    @RequestMapping("/attr_add")
    public ModelAndView attr_add(int flbh2, MODEL_T_MALL_ATTR list_attr) {

        //保存属性
        attrService.save_attr(flbh2,list_attr.getList_attr());

        ModelAndView mv = new ModelAndView("redirect:/index.do");//goto_attr_add.do
//        mv.addObject("flbh2",flbh2);
        mv.addObject("url","goto_attr_add.do?flbh2=" + flbh2 );
        mv.addObject("title","添加属性");

        return mv;
    }
}
