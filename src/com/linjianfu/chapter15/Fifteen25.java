package com.linjianfu.chapter15;

interface InterfaceA {
    void a();
}

interface InterfaceB {
    void b();
}

class Ex25 implements InterfaceA, InterfaceB {
    @Override
    public void a() {

    }

    @Override
    public void b() {

    }
}

public class Fifteen25 {
    private static <T extends InterfaceA> void f(T t) {
        t.a();
    }

    private static <T extends InterfaceB> void g(T t) {
        t.b();
    }

    public static void main(String[] args) {
        Ex25 ex25 = new Ex25();
        f(ex25);
        g(ex25);
    }
}
