package com.spring.activemq.mode;

import com.alibaba.fastjson.JSON;

/**
 * Created by liuhongbing on 2018/10/19.
 */
public class Test {

    public static   void  main(String[] args){
        JsonResult jr=JsonResult.success("returnCode","1");
        String json= JSON.toJSONString(jr);
        System.out.println(json);
    }
}
