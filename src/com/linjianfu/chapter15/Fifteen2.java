package com.linjianfu.chapter15;

import util.pets.*;

public class Fifteen2<T> {
    private T a, b, c;

    public Fifteen2(T x, T y, T z) {
        a = x;
        b = y;
        c = z;
    }

    public T getA() {
        return a;
    }

    public T getB() {
        return b;
    }

    public T getC() {
        return c;
    }

    public void setA(T a1) {
        a = a1;
    }

    public void setB(T b1) {
        b = b1;
    }

    public void setC(T c1) {
        c = c1;
    }

    @Override
    public String toString() {
        return a + " " + b + " " + c;
    }

    public static void main(String[] args) {
        Rodent rodent = new Rodent();
        Gerbil gerbil = new Gerbil();
        Mouse mouse = new Mouse();
        Fifteen2<Rodent> rodentFifteen2 = new Fifteen2<>(rodent, mouse, gerbil);
        System.out.println(rodentFifteen2);
        rodentFifteen2.setA(new Rat());
        rodentFifteen2.setB(new Hamster());
        rodentFifteen2.setC(new Rodent());
        System.out.println(rodentFifteen2);
    }
}
