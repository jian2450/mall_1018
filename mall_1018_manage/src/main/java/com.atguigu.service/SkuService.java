package com.atguigu.service;

import com.atguigu.bean.T_MALL_PRODUCT;
import com.atguigu.bean.T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-15 12:31
 */
public interface SkuService {

    void save_sku(T_MALL_SKU sku, List<T_MALL_SKU_ATTR_VALUE> list_attr, T_MALL_PRODUCT spu);
}
