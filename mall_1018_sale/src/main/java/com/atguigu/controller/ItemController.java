package com.atguigu.controller;

import com.atguigu.bean.DETAIL_T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-20 18:08
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("goto_sku_detail")
    public String goto_sku_detail(int sku_id, int spu_id, ModelMap map) {

        //查询商品详细信息对象
        DETAIL_T_MALL_SKU obj_sku = itemService.get_sku_detail(sku_id);

        //查询同spu下的其他sku信息
        List<T_MALL_SKU> list_sku = itemService.get_sku_list_by_spu(spu_id);

        /**
         * 查询 商品销售属性列表
         * 颜色列表
         * 版本列表
         */

        map.put("obj_sku", obj_sku);
        map.put("list_sku", list_sku);

        return "skuDetail";
    }

}
