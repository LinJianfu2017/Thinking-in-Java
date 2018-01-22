package com.linjianfu.chapter15;


import util.pets.*;

public class Fifteen28 {
    private class Generic1<T> {
        private T t;

        private void setT(T t) {
            this.t = t;
        }
    }

    private class Generic2<T> {
        private T t;

        private T getT() {
            return t;
        }
    }

    public <T> void m(Generic1<? super T> t, T t0) {
        t.setT(t0);
    }

    public <T> T m(Generic2<? extends T> t) {
        return t.getT();
    }

    public static void main(String[] args) {
        Fifteen28 fifteen28 = new Fifteen28();
        fifteen28.m(fifteen28.new Generic1<Pet>(), new Dog("pig"));
        fifteen28.m(fifteen28.new Generic2<Rodent>());
    }
}
