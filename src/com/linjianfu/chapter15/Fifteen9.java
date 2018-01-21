package com.linjianfu.chapter15;

import util.coffee.Coffee;
import util.pets.Pet;

//Exercise 9,10.
public class Fifteen9 {
    private static class A {
    }

    public static <X, Y, A> void f(X x, Y y, A a) {
        System.out.println(x.getClass().getSimpleName() +
                " " + y.getClass().getSimpleName() +
                " " + a.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        f(new Pet(), new Coffee(), new A());
        f("", 'y', new A());
    }
}
