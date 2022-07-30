package com.atguigu.server;

import javax.jws.WebService;

/**
 * @author jian
 * @create 2022-07-25 12:17
 */
@WebService
public interface TestServer {
    public String ping(String hello);
}
