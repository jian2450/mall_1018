package com.atguigu.mapper;

import com.atguigu.bean.T_MALL_SKU;

import java.util.Map;

/**
 * @author jian
 * @create 2022-07-15 12:32
 */
public interface SkuMapper {

    void insert_sku(T_MALL_SKU sku);

    void insert_sku_av(Map<Object, Object> map);
}
