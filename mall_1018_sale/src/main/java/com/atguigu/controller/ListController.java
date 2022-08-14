package com.atguigu.controller;

import com.atguigu.bean.*;
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

    /**
     * 分类编号检索商品列表
     *
     * @param flbh2
     * @return list
     */
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
            MyCacheUtil.setKey(key,list_sku);

        }

        map.put("list_attr", list_attr);
        map.put("list_sku", list_sku);
        map.put("flbh2", flbh2);
        return "list";
    }

    /**
     * 根据属性列表检索商品列表
     *
     * @param list_attr
     * @param flbh2
     * @return skulist
     */
    @RequestMapping("get_list_by_attr")
    public String get_list_by_attr(MODEL_T_MALL_SKU_ATTR_VALUE list_attr, int flbh2, ModelMap map) {

        List<OBJECT_T_MALL_SKU> list_sku = new ArrayList<>();

        //缓存检索
        List<T_MALL_SKU_ATTR_VALUE> list_attr1 = list_attr.getList_attr();
        String[] keys = new String[list_attr1.size()];
        for (int i = 0; i < list_attr1.size(); i++) {
            keys[i] = "attr_" + flbh2 + "_" + list_attr1.get(i).getShxm_id() + "_" + list_attr1.get(i).getShxzh_id();
        }

        //交叉检索，返回生成的key
        String interKeys = MyCacheUtil.interKeys(keys);
        list_sku = MyCacheUtil.getList(interKeys, OBJECT_T_MALL_SKU.class);

        if (list_sku ==null || list_sku.size() < 1 ){
            //mysql检索
            list_sku = listService.get_list_by_attr(list_attr.getList_attr(),flbh2);

            //同步redis
            for (int i = 0; i < keys.length; i++) {
                String key = keys[i]; //attr_28_1_2

                //判断redis中是否存在
                boolean if_key = MyCacheUtil.if_key(key);

                if (!if_key){
                    //根据属性id,查询出属性值集合
                    //循环属性值，拼接出attr的key
                    //key对应的sku集合
                    List<T_MALL_SKU_ATTR_VALUE> list_attr_for_redis = new ArrayList<>();
                    List<OBJECT_T_MALL_SKU> list_sku_for_redis = new ArrayList<>();
                    T_MALL_SKU_ATTR_VALUE attr_value = new T_MALL_SKU_ATTR_VALUE();
                    attr_value.setShxm_id(list_attr1.get(i).getShxm_id());
                    attr_value.setShxzh_id(list_attr1.get(i).getShxzh_id());
                    list_attr_for_redis.add(attr_value);
                    list_sku_for_redis = listService.get_list_by_attr(list_attr_for_redis,flbh2);

                    //再根据属性和属性值可以查询出对应的sku集合
                    //attr的可以和sku的集合循环插入到redis
                    MyCacheUtil.setKey(key,list_sku_for_redis);
                }

            }
        }

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
