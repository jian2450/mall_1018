package com.atguigu.service;

import com.atguigu.bean.OBJECT_T_MALL_ORDER;
import com.atguigu.bean.T_MALL_ADDRESS;
import com.atguigu.exception.OverSaleException;

/**
 * @author jian
 * @create 2022-07-28 22:48
 */
public interface OrderService {

    void save_order(T_MALL_ADDRESS get_address, OBJECT_T_MALL_ORDER order);

    void pay_success(OBJECT_T_MALL_ORDER order) throws OverSaleException;
}
