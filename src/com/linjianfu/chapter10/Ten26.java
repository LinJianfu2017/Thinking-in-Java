package com.linjianfu.chapter10;

public class Ten26 {
    class C26 extends A26.B26 {
        C26(A26 a26, int i) {
            a26.super(i);
            System.out.println("C26(" + i + ")");
        }
    }

    public static void main(String[] args) {
        new Ten26().new C26(new A26(), 666);
    }
}

class A26 {
    protected class B26 {
        B26(int i) {
            System.out.println("B26(" + i + ")");
        }
    }
}