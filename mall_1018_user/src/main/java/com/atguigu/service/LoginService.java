package com.atguigu.service;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;

/**
 * @author jian
 * @create 2022-07-25 22:41
 */
public interface LoginService {

    public T_MALL_USER_ACCOUNT login(T_MALL_USER_ACCOUNT user);

    public T_MALL_USER_ACCOUNT login2(T_MALL_USER_ACCOUNT user);

}
