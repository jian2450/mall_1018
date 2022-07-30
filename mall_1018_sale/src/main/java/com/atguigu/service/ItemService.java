package com.atguigu.service;

import com.atguigu.bean.DETAIL_T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-20 18:16
 */
public interface ItemService {
    DETAIL_T_MALL_SKU get_sku_detail(int sku_id);

    List<T_MALL_SKU> get_sku_list_by_spu(int spu_id);
}
