package com.spring.activemq.controller;

import com.spring.activemq.service.ConsumerService;
import com.spring.activemq.service.ProducerService;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.Map;

/**
 * Created by liuhongbing on 2018/3/20.
 */
@Controller
public class ProducerController {
    @Resource
    private ProducerService producerService;

    @Resource
    private ConsumerService consumerService;

    @Resource
    private Destination demoQueueDestination;

    @RequestMapping(value = "/send1", method = RequestMethod.POST)
    public String send(@RequestParam("message") String message) {
        System.out.println("接收到表单的数据:" + message);
        ActiveMQDestination activeMQDestination = (ActiveMQDestination) demoQueueDestination;
        System.out.println("往队列:" + activeMQDestination.getCompositeDestinations()[0].getPhysicalName() + "\t发送文本消息:" + message);
        producerService.sendMessage(activeMQDestination.getCompositeDestinations()[0], message);
        return "success";
    }

    @RequestMapping(value = "/send2", method = RequestMethod.POST)
    public String rec(Map<String, String> map, @RequestParam("message") String message) {
        System.out.println("接收到表单的数据:" + message);
        ActiveMQDestination activeMQDestination = (ActiveMQDestination) demoQueueDestination;
        System.out.println("往队列:" + activeMQDestination.getCompositeDestinations()[1].getPhysicalName() + "\t发送文本消息:" + message);
        producerService.sendMessage(activeMQDestination.getCompositeDestinations()[1], message);
        return "success";
    }

    /**
     * 发送一个top主题类型的消息
     *
     * @param message 发送的内容
     * @return
     */
    @RequestMapping(value = "/sen", method = RequestMethod.POST)
    public String send2(@RequestParam("message") String message) {
        System.out.println("接收到表单的数据:" + message);
        ActiveMQDestination activeMQDestination = new ActiveMQQueue("topicAbc");
        System.out.println("往队列:" + activeMQDestination.getCompositeDestinations()[0].getPhysicalName() + "\t发送文本消息:" + message);
        producerService.sendMessage(activeMQDestination.getCompositeDestinations()[0], message);
        return "success";
    }

    @RequestMapping(value = "/rec", method = RequestMethod.POST)
    public @ResponseBody
    String rec() {
        ActiveMQDestination activeMQDestination = new ActiveMQQueue("topicAbc");
        String res = consumerService.receive(activeMQDestination.getCompositeDestinations()[0]);
        return res;
    }
}
