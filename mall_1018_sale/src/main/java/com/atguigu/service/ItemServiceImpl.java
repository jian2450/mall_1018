package com.atguigu.service;

import com.atguigu.bean.DETAIL_T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-20 18:19
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemMapper itemMapper;

    @Override
    public DETAIL_T_MALL_SKU get_sku_detail(int sku_id) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("sku_id",sku_id);

        DETAIL_T_MALL_SKU obj_sku = itemMapper.select_detail_sku(map);
        return obj_sku;
    }

    @Override
    public List<T_MALL_SKU> get_sku_list_by_spu(int spu_id) {

        return itemMapper.select_skuList_by_spu(spu_id);
    }
}
