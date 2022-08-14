import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author jian
 * @create 2022-08-07 18:37
 */
public class Producer {
    public static void main(String[] args) throws JMSException {

        //连接
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //消息对象
//        Queue queue = session.createQueue("office-queue");
        Topic topic = session.createTopic("office-topic");

        //消息内容
//        TextMessage textMessage = session.createTextMessage("我渴了，来杯水");
        TextMessage textMessage = session.createTextMessage("为中华之崛起而读书");

        //发送端
        MessageProducer producer = session.createProducer(topic);

        //发送消息
        producer.send(textMessage);

        //关闭连接
        producer.close();
        session.close();
        connection.close();

    }

}
