package com.jian;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * @author jian
 * @create 2022-07-23 0:47
 */
public class SendMsg_webchinese {
    public static void main(String[] args) throws Exception {

        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.api.smschinese.cn");
        post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");// 在头文件中设置转码
        NameValuePair[] data = {
                new NameValuePair("Uid", "shiliu"),
                new NameValuePair("Key", "593e95da4d0ea553be10"),
                new NameValuePair("smsMob", "18622642186"),
                new NameValuePair("smsText", "验证码：8888,猜呀猜")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:" + statusCode);
        for (Header h : headers) {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result); // 打印返回消息状态

        post.releaseConnection();

    }

}
