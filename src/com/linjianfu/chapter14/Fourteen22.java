package com.linjianfu.chapter14;

import com.linjianfu.chapter1.TestFile;

import java.lang.reflect.Proxy;

//Exercise 22,23.
public class Fourteen22 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("xiduoduo");
        //打印代理对象，实际上在调用处理器的invoke()将调用信息转发给被代理对象之后，
        //代理（指invoke()的形参"proxy",not class's member "proxied"）就指向了被代理对象；
        //而在转发之前，打印则是"Unknown Source",将发生Stack Overflow
        System.out.println(iface);
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
//        SimpleProxy simpleProxy = new SimpleProxy(realObject);
//        consumer(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(
                /**
                 * 以下注释那行抛的：
                 * Exception in thread "main" java.lang.IllegalArgumentException: interface com.linjianfu.chapter14.Interface is not visible from class loader
                 at java.lang.reflect.Proxy$ProxyClassFactory.apply(Proxy.java:581)
                 at java.lang.reflect.Proxy$ProxyClassFactory.apply(Proxy.java:557)
                 at java.lang.reflect.WeakCache$Factory.get(WeakCache.java:230)
                 at java.lang.reflect.WeakCache.get(WeakCache.java:127)
                 at java.lang.reflect.Proxy.getProxyClass0(Proxy.java:419)
                 at java.lang.reflect.Proxy.newProxyInstance(Proxy.java:719):
                 */
                //Class.class.getClassLoader(),
                TestFile.class.getClassLoader(),//说明只要非“不可见的（not visible from）”的类均可作为加载器？！
                new Class[]{Interface.class},//需要实现的接口列表
                new DynamicProxyHandler(realObject)//给调用处理器传递了被代理对象的引用
        );
        consumer(proxy);
//        consumer(simpleProxy);
    }
}
