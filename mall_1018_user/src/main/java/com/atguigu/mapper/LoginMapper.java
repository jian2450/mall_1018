package com.atguigu.mapper;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;

/**
 * @author jian
 * @create 2022-07-16 23:22
 */
public interface LoginMapper {

    T_MALL_USER_ACCOUNT select_user(T_MALL_USER_ACCOUNT user);

    void update_test();
}
