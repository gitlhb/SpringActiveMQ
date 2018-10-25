package com.spring.activemq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * Created by liuhongbing on 2018/10/25.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public  String test(@RequestBody String abc){
        System.out.println(abc);
        return new Date().getTime()+"";
    }

}
