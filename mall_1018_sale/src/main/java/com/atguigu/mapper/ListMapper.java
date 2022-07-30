package com.atguigu.mapper;

import com.atguigu.bean.OBJECT_T_MALL_SKU;

import java.util.HashMap;
import java.util.List;

/**
 * @author jian
 * @create 2022-07-19 17:46
 */
public interface ListMapper {
    List<OBJECT_T_MALL_SKU> select_list_by_flbh2(int flbh2);

    List<OBJECT_T_MALL_SKU> select_list_by_attr(HashMap<Object, Object> hashMap);
}
