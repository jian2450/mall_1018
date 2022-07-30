package com.atguigu.server;

/**
 * @author jian
 * @create 2022-07-25 12:18
 */
public class TestServerImpl implements TestServer {
    @Override
    public String ping(String hello) {
        System.out.println("cxf接口调用：" + hello);
        return "pong";
    }
}
