package com.linjianfu.chapter5;
//exercise 1,2,3.4.

class Test {
    String s1;
    String s2 = "HelloBaby";
    String s3;

    Test() {
        System.out.println("1+1");
        s3 = "xiabibi";
        System.out.println("等于2");
    }

    Test(String s) {
        System.out.println("Look! s=" + s);
    }
}

public class Five1 {
    private String s1;
    private String s2 = "This is a string.";
    private static String s3;

    Five1() {
        System.out.println("Vampire--------");
        this.s3 = "Who are you?";
        System.out.println("Fibonacci*********");
    }

    Five1(String s) {
        System.out.println("瞧！那条蛇是" + s);
    }

    public static void main(String[] args) {
        /**
         * 初始化顺序是按照main方法里边执行语句调用的先后顺序进行，没用到的则不进行初始化吧？
         */
        System.out.println("oxoxooxoxoxxoxoxoxoxo");
        Five1 c = new Five1();
        System.out.println(c.s1);
        System.out.println(c.s2);
        System.out.println(s3);
        System.out.println(c.s3);
        c.s3 = "I'm Lin Jianfu";
        System.out.println(c.s3);
        System.out.println(s3);

        Test t = new Test();
        System.out.println(t.s1);
        System.out.println(t.s2);
        System.out.println(t.s3);

        Test tt = new Test("主类构造器重载");
        Five1 cc = new Five1("非主类构造器重载");


    }
}
