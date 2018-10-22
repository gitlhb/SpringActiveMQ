package com.spring.activemq.component;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by liuhongbing on 2018/10/19.
 */
public class Test {
    public  static  void  main(String[] args) throws  Exception{
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        InputStream in=new FileInputStream(new File("D:\\配置文件","SignKey.xml"));
        byte[] buffer=new byte[10234];
        int len=0;
        while ((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        in.close();
        byte[] ret=out.toByteArray();
        out.close();
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(new String(ret,"utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(new String(ret,"utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(new String(ret,"utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(out.toString("utf-8"));
        System.out.println(new String(ret,"utf-8"));
    }
}
