package com.atguigu.server;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;

import javax.jws.WebService;

/**
 * @author jian
 * @create 2022-07-25 22:32
 */
@WebService
public interface LoginServer {
    public String login(T_MALL_USER_ACCOUNT user);

    public String login2(T_MALL_USER_ACCOUNT user);
}
