package com.linjianfu.chapter15;

interface A {
    A getA();
}

class AI implements A {
    @Override
    public A getA() {
        return null;
    }
}

interface B {
    B getB();
}

class BI implements B {
    @Override
    public B getB() {
        return null;
    }
}

interface C {
    C getC();
}

class CI implements C {
    @Override
    public C getC() {
        return null;
    }
}

interface D {
    D getD();
}

class DI implements D {
    @Override
    public D getD() {
        return null;
    }
}

public class Fifteen37 extends DI implements A, B, C {
    @Override
    public A getA() {
        return null;
    }

    @Override
    public B getB() {
        return null;
    }

    @Override
    public C getC() {
        return null;
    }

    public static void main(String[] args) {
        Fifteen37 fifteen37 = new Fifteen37();
        fifteen37.getA();
        fifteen37.getB();
        fifteen37.getC();
        fifteen37.getD();
    }
}
