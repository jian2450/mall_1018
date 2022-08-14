package com.atguigu.service;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;
import com.atguigu.bean.T_MALL_USER_ACCOUNT;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-23 16:22
 */
public interface CartService {

    void add_cart(T_MALL_SHOPPINGCAR cart);

    boolean if_cart_exists(T_MALL_SHOPPINGCAR cart);

    void update_cart(T_MALL_SHOPPINGCAR t_mall_shoppingcar);

    List<T_MALL_SHOPPINGCAR> get_list_cart_by_user(T_MALL_USER_ACCOUNT user);
}
