package com.spring.activemq.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import java.io.Serializable;

/**
 * 消息生产者
 */

@Service("producerService")
public class ProducerService {
    @Resource
    private JmsTemplate jmsTemplate;
    /**
     * 发送文本信息
     * @param destination
     * @param message
     */
    public void sendMessage(Destination destination, final String message) {
        if (destination == null) {
            destination = jmsTemplate.getDefaultDestination();
        }
        System.out.println("Send Message :" + message + "to Destination :" + destination.toString());
        MessageCreator messageCreator = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(message);

            }
        };
        jmsTemplate.send(destination, messageCreator);
    }
    /**
     * 发送map消息
     * @param destination
     * @param message
     */
    public void sendMapMessage(Destination destination, final String message) {
        if (null == destination) {
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                MapMessage mapMessage = session.createMapMessage();
                mapMessage.setString("msgId", message);
                return mapMessage;
            }
        });
        System.out.println("springJMS send map message...");
    }
    /**
     * 发送对象消息
     * @param destination 目标
     * @param object      要发送的对象
     */
    public void sendObjectMessage(Destination destination, final Serializable object) {
        if (null == destination) {
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(object);
            }
        });
        System.out.println("springJMS send object message...");
    }
    /**
     * 发送字节消息
     * @param destination
     * @param bytes
     */
    public void sendBytesMessage(Destination destination, final byte[] bytes) {
        if (null == destination) {
            destination = jmsTemplate.getDefaultDestination();
        }
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                BytesMessage bytesMessage = session.createBytesMessage();
                bytesMessage.writeBytes(bytes);
                return bytesMessage;

            }
        });
        System.out.println("springJMS send bytes message...");
    }
    /**
     * 发送流消息
     * @param destination
     */
    public void sendStreamMessage(Destination destination) {
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                StreamMessage message = session.createStreamMessage();
                message.writeString("stream string");
                message.writeInt(11111);
                return message;
            }
        });
        System.out.println("springJMS send Strem message...");
    }
}
