import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author jian
 * @create 2022-08-07 19:07
 */
public class Consumer3 {
    public static void main(String[] args) throws Exception {

       xl();

    }

    public static void xl() throws Exception{
        //创建连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
       //创建永久消息区域
        connection.setClientID("1");
        connection.start();

        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //消息对象
        Topic topic = session.createTopic("office-topic");

        //接收端
//        MessageConsumer consumer = session.createConsumer(topic);
        TopicSubscriber consumer = session.createDurableSubscriber(topic, "1");

        //接收消息
        consumer.setMessageListener(new MessageListener() { //监听mq服务器的变化
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                String text ="";
                try {
                    text = textMessage.getText();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                System.out.println("夏磊老师：听到了"+text+"，积极地响应了要求。。。");
            }
        });

        //等待接收消息,让虚拟机处于启动状态
        System.in.read();
    }

}
