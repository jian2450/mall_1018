package com.atguigu.service;

import com.atguigu.bean.OBJECT_T_MALL_SKU;
import com.atguigu.bean.T_MALL_SKU_ATTR_VALUE;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-19 17:03
 */
public interface ListService {

    List<OBJECT_T_MALL_SKU> get_list_by_flbh2(int flbh2);

    List<OBJECT_T_MALL_SKU> get_list_by_attr(List<T_MALL_SKU_ATTR_VALUE> list_attr, int flbh2);
}
