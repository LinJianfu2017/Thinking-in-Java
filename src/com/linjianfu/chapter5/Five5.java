package com.linjianfu.chapter5;
//Exercise 5,6,7

class noconstructor{}
public class Five5 {
    void bark(int i,double d){
        System.out.println("barking");
    }
    void bark(double d,int i){
        System.out.println("howling");
    }

    public static void main(String[] args) {
        Five5 dog1=new Five5();
        dog1.bark(1,2.71);
        dog1.bark(3.1415926,9981);
        noconstructor n=new noconstructor();
//        System.out.println(n);
    }
}
