package com.linjianfu.chapter5;
/**
 * Exercise 8,9.
 *
 * */
public class Five8 {
    static int i = 0;
    static char c = 'a';

    void f1() {
        System.out.println("f1");
        f2();
        this.f2();

    }

    void f2() {
        System.out.println("f2");
//        f1();
    }

    public static void main(String[] args) {
        new Five8().f1();
        new Constructor().f();
    }
}

class Constructor {
//    int i1 = 0;

    Constructor() {
        /***  构造器必须放在字段段首，否则编译器将出错。why?  ***/
        this(8);
        System.out.println("1111");

    }

    Constructor(int i) {
        System.out.println("2222");
//        i1 = i;
    }

    void f() {
        System.out.println("constructor");
    }
}