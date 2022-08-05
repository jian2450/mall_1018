package com.atguigu.controller;

import com.atguigu.bean.KEYWORDS_T_MALL_SKU;
import com.atguigu.bean.MODEL_T_MALL_SKU_ATTR_VALUE;
import com.atguigu.bean.OBJECT_T_MALL_ATTR;
import com.atguigu.bean.OBJECT_T_MALL_SKU;
import com.atguigu.service.AttrService;
import com.atguigu.service.ListService;
import com.atguigu.utils.MyCacheUtil;
import com.atguigu.utils.MyHttpGetUtil;
import com.atguigu.utils.MyJsonUtil;
import com.atguigu.utils.MyPropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-19 21:38
 */
@Controller
public class ListController {

    @Autowired
    private ListService listService;

    @Autowired
    private AttrService attrService;

    @RequestMapping("keywords")
    public String keywords(String keywords, ModelMap map) {

        //调用keywords的关键字查询接口
        String doGet = "";
        String keywords_url = MyPropertiesUtil.getMyProperty("ws.properties", "keywords_url") + "?keywords=" + keywords;
        try {
            doGet = MyHttpGetUtil.doGet(keywords_url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<KEYWORDS_T_MALL_SKU> list_sku = MyJsonUtil.json_to_list(doGet, KEYWORDS_T_MALL_SKU.class);

        map.put("list_sku", list_sku);
        map.put("keywords", keywords);
        return "search";
    }

    @RequestMapping("goto_list")
    public String goto_list(int flbh2, ModelMap map) {
        //flbh2属性的集合
        List<OBJECT_T_MALL_ATTR> list_attr = new ArrayList<>();
        //flbh2商品列表
        List<OBJECT_T_MALL_SKU> list_sku = new ArrayList<>();

        list_attr = attrService.get_attr_list(flbh2);

        //缓存检索
        String key = "class_2_" + flbh2;
        list_sku = MyCacheUtil.getList(key, OBJECT_T_MALL_SKU.class);

        if (list_sku == null || list_sku.size() < 1) {
            //mysql检索
            list_sku = listService.get_list_by_flbh2(flbh2);

            //将检索结果同步到redis

        }

        map.put("list_attr", list_attr);
        map.put("list_sku", list_sku);
        map.put("flbh2", flbh2);
        return "list";

    }


    @RequestMapping("get_list_by_attr")
    public String get_list_by_attr(MODEL_T_MALL_SKU_ATTR_VALUE list_attr, int flbh2, ModelMap map) {

        //根据属性查询商品列表
        List<OBJECT_T_MALL_SKU> list_sku = listService.get_list_by_attr(list_attr.getList_attr(), flbh2);

        //缓存检索
        String key = "";

        //mysql检索


        map.put("list_sku", list_sku);
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
