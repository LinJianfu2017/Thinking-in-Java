package com.linjianfu.chapter5;
//Exercise 5,6,7

class NoConstructor {
}

public class Five5 {
    private void bark(int i, double d) {
        System.out.println("barking");
    }

    private void bark(double d, int i) {
        System.out.println("howling");
    }

    public static void main(String[] args) {
        Five5 dog1 = new Five5();
        dog1.bark(1, 2.71);
        dog1.bark(3.1415926, 9981);
        NoConstructor n = new NoConstructor();
//        System.out.println(n);
    }
}
