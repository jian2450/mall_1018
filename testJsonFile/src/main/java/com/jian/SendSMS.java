package com.jian;

import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

import java.util.Map;

/**
 * @author jian
 * @create 2022-07-23 1:05
 */
public class SendSMS {
    public static void testSendSms(String apikey, String mobile, String text) {
        //初始化client,apikey作为所有请求的默认值(可以为空)
        YunpianClient clnt = new YunpianClient(apikey).init();

        Map<String, String> param = clnt.newParam(2);
        param.put(YunpianClient.MOBILE, mobile);
        param.put(YunpianClient.TEXT, text);
        Result<SmsSingleSend> r = clnt.sms().single_send(param);
        //获取返回结果，返回码:r.getCode(),返回码描述:r.getMsg(),API结果:r.getData(),其他说明:r.getDetail(),调用异常:r.getThrowable()
        r.getData();
        //账户:clnt.user().* 签名:clnt.sign().* 模版:clnt.tpl().* 短信:clnt.sms().* 语音:clnt.voice().* 流量:clnt.flow().* 隐私通话:clnt.call().*

        //最后释放client
        clnt.close();
    }

    public static void main(String[] args) {

        new SendSMS().testSendSms("***APIKEY***","手机号","模版内容");
    }
}
