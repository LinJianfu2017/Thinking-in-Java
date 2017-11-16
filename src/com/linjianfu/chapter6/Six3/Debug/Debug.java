package com.linjianfu.chapter6.Six3.Debug;

public class Debug {
    public static void debug(String s) {
        System.out.println(s);
    }
    protected void six4test1(){
        System.out.println("six4test1:这是在public类内部的protected方法");
    }
}class SixFour{
    protected void six4test2(){
        System.out.println("six4test2：这是在default权限类内部的protected方法");
    }
}