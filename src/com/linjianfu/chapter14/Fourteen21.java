package com.linjianfu.chapter14;

import java.util.Date;

interface Interface {
    void doSomething();

    void somethingElse(String arg);
}

class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

interface A {
}

class B {
}

class SimpleProxy extends B implements Interface, A {
    private Interface proxied;
    private static int doCount = 0;
    private static int sECount = 0;

//    public SimpleProxy() {
//
//    }

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        long timeIn = new Date().getTime();
//        System.out.print("Time called donSomething() " + doCount + ": " + timeIn + "ms ");
//        System.out.println("on " + new Date());
//        doCount++;
        proxied.doSomething();
//        System.out.print("Call-return time = " + (new Date().getTime() - timeIn) + "ms ");
    }

    @Override
    public void somethingElse(String arg) {
        long timeIn = new Date().getTime();
//        System.out.print("Time called SomethingElse() " + sECount + ": " + timeIn + "ms ");
//        System.out.println("on " + new Date());
//        sECount++;
        proxied.somethingElse(arg);
//        System.out.print("Call-return time = " + (new Date().getTime() - timeIn) + "ms ");
    }
}

public class Fourteen21 {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("xiduoduo");
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consumer(realObject);
        //除了第一个，剩下的咋时间开销时间都一样0ms，ms度量不来？
        SimpleProxy simpleProxy = new SimpleProxy(realObject);
        consumer(simpleProxy);
        consumer(new SimpleProxy(realObject));
        consumer(new SimpleProxy(new RealObject()));
    }
}
