package com.linjianfu.chapter5;

//Exercise 15
class Test15 {
    String s;

    {
        s = "Initializing string of instance in Test15 ";
        System.out.println(s);
    }

    Test15() {
        System.out.println("Test15()");
    }
}

public class Five15 {
    public static void main(String[] args) {
        new Test15();
    }
}
