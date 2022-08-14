import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author jian
 * @create 2022-08-07 19:35
 */
public class Consumer2 {

    public static void main(String[] args) throws Exception {

        //创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //消息对象
        Queue queue = session.createQueue("office-queue");

        //接收端
        MessageConsumer consumer = session.createConsumer(queue);

        //接收消息
        consumer.setMessageListener(new MessageListener() { //监听mq服务器的变化
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                String text = "";
                try {
                    text = textMessage.getText();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                System.out.println("海波老师听到了：" + text + "，积极地响应了要求。。。");
            }
        });

        //等待接收消息,让虚拟机处于启动状态
        System.in.read();
    }

}
