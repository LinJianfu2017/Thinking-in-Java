package com.linjianfu.chapter7;
//Exercise 20,,21.
class S20 {
    S20() {
        System.out.println("S20 constructor");
    }

    private final void f1() {
        System.out.println("S20..f1()");
    }

    final void f2() {
        System.out.println("S20.f2()");
    }
}

public class Seven20 extends S20 {
    /**
     * Method does not override method from its superclass.
     */
//    @Override
    final void f1() {
        System.out.println("Seven20.f1()");
    }

    /**
     * 'f2()' cannot override 'f2()' in 'com.linjianfu.chapter7.S20';overridden method is final.
     */
//    @Override
//    final void f2() {
//        System.out.println("Seven20.f2()");
//    }
    public static void main(String[] args) {
        Seven20 s20 = new Seven20();
        s20.f1();
        s20.f2();
        S20 s21 = s20;
        s21.f2();
        /**
         * 'f1()' has private access in 'com.linjianfu.chapter.S20'.
         * */
//        s21.f1();

    }
}
