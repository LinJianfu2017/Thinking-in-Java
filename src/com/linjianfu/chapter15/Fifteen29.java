package com.linjianfu.chapter15;

import java.util.List;

public class Fifteen29 {
    public static class Holder<T> {
        private T value;

        public Holder() {
        }

        public Holder(T val) {
            value = val;
        }

        public void set(T val) {
            value = val;
        }

        public T get() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            return value.equals(obj);
        }
    }

    static void f(Holder<List<?>> hL) {
        //unfinished
    }

    static void f(List<Holder<?>> lH) {
        //unfinished
    }

    public static void main(String[] args) {

    }
}
