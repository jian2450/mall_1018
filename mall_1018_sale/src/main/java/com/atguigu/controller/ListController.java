package com.atguigu.controller;

import com.atguigu.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.bean.OBJECT_T_MALL_SKU;
import com.atguigu.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-19 21:38
 */
@Controller
public class ListController {

    @Autowired
    private ListService listService;

    @RequestMapping("get_list_by_attr")
    public String get_list_by_attr(MODEL_T_MALL_SKU_ATTR_VALUE list_attr, int flbh2,ModelMap map){

        //根据属性查询商品列表
        List<OBJECT_T_MALL_SKU> list_sku =listService.get_list_by_attr(list_attr.getList_attr(),flbh2);

        map.put("list_sku",list_sku);

        return "skuList";
    }

    /*  //不推荐
    @RequestMapping("get_list_by_attr")
    public String get_list_by_attr(@RequestParam("param_array[]") String[] param_array , ModelMap map){
        //如果是字符串数组，需要切割字符串，并且转化类型

        return "skuList";
    }
    */
}
