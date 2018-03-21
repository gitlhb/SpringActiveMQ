package com.spring.activemq;

import com.spring.activemq.utils.WebServiceHelper;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * Created by liuhongbing on 2018/3/21.
 */
public class TestWebService {


    public static void main(String[] args) {
        String inStr = "haha";
        String re = null;
        try {
            re = WebServiceHelper.invokeWebService("http://119.22.156.1:10001/v.asmx", "RegService", inStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(re);
    }
}
