package com.linjianfu.chapter14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**
         * Exception in thread "main" java.lang.StackOverflowError
         at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:449)
         at java.lang.StringBuilder.append(StringBuilder.java:136)
         at com.linjianfu.chapter14.DynamicProxyHandler.invoke(DynamicProxyHandler.java:15)
         at com.linjianfu.chapter14.$Proxy0.toString(Unknown Source)
         at java.lang.String.valueOf(String.java:2994)
         at java.lang.StringBuilder.append(StringBuilder.java:131):
         */
//        System.out.println("What's the ???"+proxy);//StackOverflowError
        return method.invoke(proxied, args);//Method.invoke()将请求转发给被代理对象
    }
}

