package com.linjianfu.chapter15;

abstract class SelfBounded<T extends SelfBounded<T>> {
    private T t;

    abstract T setAndGet(T t);

    T get(T t) {
        System.out.println("SelfBounded.get()");
        return setAndGet(t);
    }
}

public class Fifteen34 extends SelfBounded<Fifteen34> {
    @Override
    Fifteen34 setAndGet(Fifteen34 fifteen34) {
        System.out.println("Fifteen34.setAndGet()");
        return new Fifteen34();
    }

    @Override
    Fifteen34 get(Fifteen34 fifteen34) {
        System.out.println("Fifteen34.get()");
        return super.get(fifteen34);
    }

    public static void main(String[] args) {
        Fifteen34 fif34 = new Fifteen34();
        fif34.setAndGet(fif34);
        fif34.get(fif34);
    }
}
