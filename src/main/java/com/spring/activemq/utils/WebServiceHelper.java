package com.spring.activemq.utils;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * WebService帮助类
 * Created by liuhongbing on 2018/3/21.
 */
public class WebServiceHelper {
    private WebServiceHelper() {
    }

    private static JaxWsDynamicClientFactory factory = null;

    static {
        factory = JaxWsDynamicClientFactory.newInstance();
    }

    /**
     * 调用WebService
     *
     * @param url        WebService地址
     * @param methodName 方法名
     * @param inParams   参数
     * @return WebService返回String
     */
    public static String invokeWebService(String url, String methodName, Object[] inParams) throws Exception {
        if (!url.endsWith("wsdl")) {
            url += "?wsdl";
        }
        try {
            Client client = factory.createClient(url);
            Object[] objs = client.invoke(methodName, inParams);
            return objs[0].toString();
        } catch (Exception e) {
            throw new Exception("调用地址:" + url + "  异常:" + e.getMessage());
        }
    }

    /**
     * 调用WebService
     *
     * @param url        WebService地址
     * @param methodName 方法名
     * @param inParam    参数
     * @return WebService返回String
     */
    public static String invokeWebService(String url, String methodName, String inParam) throws Exception {
        if (!url.endsWith("wsdl")) {
            url += "?wsdl";
        }
        try {
            Client client = factory.createClient(url);
            Object[] objs = client.invoke(methodName, new Object[]{inParam});
            return objs[0].toString();
        } catch (Exception e) {
            throw new Exception("调用地址:" + url + "  异常:" + e.getMessage());
        }
    }
}
