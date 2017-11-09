package com.linjianfu.chapter3;

public class Three14 {
    void f(boolean b) {
        if (b == true) System.out.println("true");
        else System.out.println("false");
    }

    void stringCompare(String s1, String s2) {
        f(s1 == s2);
        f(s1 != s2);
        f(s1.equals(s2));
        f(s2.equals(s1));

    }

    public static void main(String[] args) {
        String a = "beautiful", b = "Hello";
        new Three14().stringCompare(a, b);
    }

}
