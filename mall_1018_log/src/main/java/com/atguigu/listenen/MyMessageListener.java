package com.atguigu.listenen;

import com.atguigu.mapper.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author jian
 * @create 2022-08-10 16:24
 */
public class MyMessageListener implements MessageListener {

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public void onMessage(Message message) {
        //判断是什么消息
        TextMessage textMessage  = (TextMessage)message;
        try {
            String text = textMessage.getText();
            //根据消息内容执行对应的任务
            indexMapper.log(text);

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
