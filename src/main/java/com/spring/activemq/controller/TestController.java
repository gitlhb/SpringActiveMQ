package com.spring.activemq.controller;

import com.spring.activemq.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


/**
 * Created by liuhongbing on 2018/10/25.
 */
@RestController
public class TestController {

    @Autowired
    ProducerService producerService;

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public  String test(@RequestBody String abc){
        producerService.sendMessage(null,"");
        System.out.println(abc);
        return new Date().getTime()+"";
    }

}
