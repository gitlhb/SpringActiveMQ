package com.spring.activemq.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * 消息消费者
 */
@Service("consumerService")
public class ConsumerService implements MessageListener {
    @Resource
    private JmsTemplate jmsTemplate;

    /**
     * 点对点的消息接收
     *
     * @param destination
     * @return
     */
    public String receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        String result = null;
        if (tm != null) {
            try {
                System.out.println("Get Message: " + tm.getText() + " from Destination " + destination.toString());
                result = tm.getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 订阅发布模式的消息接收
     *
     * @param message
     */
    public void onMessage(Message message) {
        try {
            System.out.println("-----------");
            TextMessage textMessage = (TextMessage) message;
            System.out.println(textMessage.getText() + "msgId:" + textMessage.getJMSMessageID());
        } catch (Exception ex) {

        }

    }
}
