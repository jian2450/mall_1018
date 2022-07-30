package com.atguigu.test;

import javax.jws.WebService;

/**
 * @author jian
 * @create 2022-07-24 23:14
 */
@WebService
public class TestServiceImpl implements TestService{
    @Override
    public String ping(String hello) {
        System.out.println("接口调用："+hello);
        return "pong";
    }
}
