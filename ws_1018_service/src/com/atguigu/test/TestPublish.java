package com.atguigu.test;

import javax.xml.ws.Endpoint;

/**
 * @author jian
 * @create 2022-07-24 23:15
 */
public class TestPublish {
    public static void main(String[] args) {
        TestService ws = new TestServiceImpl();
        //http://192.168.1.102:1234/ws?wsdl
        Endpoint.publish("http://192.168.1.102:1234/ws",ws);
    }
}
