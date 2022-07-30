package com.atguigu.utils;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * @author jian
 * @create 2022-07-27 11:24
 */
public class MyCallback implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        // 配置username/password的代码
        WSPasswordCallback wsc = (WSPasswordCallback) callbacks[0];

        String user = wsc.getIdentifier();
        String password = "";// 查询数据库或者配置文件

        // 配置私人的加密协议
        if (user.equals("cxf")) {
            password = "123";
        }

        wsc.setPassword(password);
    }
}
