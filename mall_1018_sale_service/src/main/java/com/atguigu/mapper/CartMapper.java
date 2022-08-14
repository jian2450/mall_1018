package com.atguigu.mapper;

import com.atguigu.bean.T_MALL_SHOPPINGCAR;

import java.util.List;

/**
 * @author jian
 * @create 2022-07-23 16:25
 */
public interface CartMapper {

    void insert_cart(T_MALL_SHOPPINGCAR cart);

    void update_cart(T_MALL_SHOPPINGCAR cart);

    int select_cart_exists(T_MALL_SHOPPINGCAR cart);

    List<T_MALL_SHOPPINGCAR> select_list_cart_by_user(int user_id);
}
