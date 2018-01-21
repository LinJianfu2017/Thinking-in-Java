package com.linjianfu.chapter15;

interface Ex20 {
    void f20();

    void g20();
}

class C20 implements Ex20 {
    @Override
    public void g20() {

    }

    @Override
    public void f20() {

    }

    public void h20() {
    }
}

public class Fifteen20 {
    private static <T extends Ex20> void test(Ex20 ex20) {

        ex20.f20();
        ex20.g20();
    }

    public static void main(String[] args) {
        test(new C20());
    }
}
