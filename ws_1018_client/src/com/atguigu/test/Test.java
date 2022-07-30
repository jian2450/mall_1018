package com.atguigu.test;

/**
 * @author jian
 * @create 2022-07-24 23:42
 */
public class Test {
    public static void main(String[] args) {
        TestServiceImplService service = new TestServiceImplService();

        TestServiceImpl testServiceImplPort = service.getTestServiceImplPort();

        String ping = testServiceImplPort.ping("你好");

        System.out.println(ping);
    }
}
