package com.atguigu.service;

import com.atguigu.bean.OBJECT_T_MALL_ATTR;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-13 23:31
 */
public interface AttrService {
    void save_attr(int flbh2, List<OBJECT_T_MALL_ATTR> list_attr);

    List<OBJECT_T_MALL_ATTR> get_attr_list(int flbh2);
}
