package com.spring.activemq.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Created by liuhongbing on 2018/10/25.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public  String test(@RequestBody String abc){
        System.out.println(abc);
        return new Date().getTime()+"";
    }

}
