package com.spring.activemq.component;

import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.stereotype.Component;

import javax.jms.*;

/**
 * Created by liuhongbing on 2018/3/21.
 */
@Component("queueMessageListener")
public class QueueMessageListener implements MessageListener {

    /**
     * 接返回
     * @param message
     */
    public void onMessage(Message message) {
        try {
            ActiveMQDestination queues = (ActiveMQDestination) message.getJMSDestination();
            if (queues.getPhysicalName().equalsIgnoreCase("queue1")) {
                System.out.println("监听队列:" + queues.getPhysicalName() + "消费了消息:");
                if (message instanceof TextMessage) {
                    TextMessage tm = (TextMessage) message;
                    System.out.println("getJMSMessageID:" + tm.getJMSMessageID());
                    try {
                        System.out.println("from get textMessage：\t" + tm.getText());
                        System.out.println(tm.getJMSCorrelationID());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
                // 如果是Map消息
                if (message instanceof MapMessage) {
                    MapMessage mm = (MapMessage) message;
                    try {
                        System.out.println("from get MapMessage：\t" + mm.getString("msgId"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("监听队列:" + queues.getPhysicalName() + "消费了消息Queue2:");
                if (message instanceof TextMessage) {
                    TextMessage tm = (TextMessage) message;
                    try {
                        System.out.println("\t" + tm.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
                // 如果是Map消息
                if (message instanceof MapMessage) {
                    MapMessage mm = (MapMessage) message;
                    try {
                        System.out.println("from  MapMessage：\t" + mm.getString("msgId"));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
        // 如果是bytes消息
        if (message instanceof BytesMessage) {
            System.out.println("from get BytesMessage：\t");
            byte[] b = new byte[1024];
            int len = -1;
            BytesMessage bm = (BytesMessage) message;
            try {
                while ((len = bm.readBytes(b)) != -1) {
                    System.out.println(new String(b, 0, len));
                }
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // 如果是Stream消息
        if (message instanceof StreamMessage) {
            System.out.println("from get BytesMessage：\t");
            StreamMessage sm = (StreamMessage) message;
            try {
                System.out.println(sm.readString());
                System.out.println(sm.readInt());
            } catch (JMSException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
