package com.linjianfu.chapter15;

import java.util.ArrayList;
import java.util.List;

interface Processor<T, E1 extends Exception,
        E2 extends Exception> {
    void a(List<T> tList) throws E1;

    void b(List<T> tList) throws E2;

    void c(List<T> tList) throws E1, E2;

}

class Ea extends Exception {
}

class Eb extends Exception {
}

public class Fifteen36 implements Processor
        <String, Ea, Eb> {
    @Override
    public void a(List<String> strings) throws Ea {

    }

    @Override
    public void b(List<String> strings) throws Eb {

    }

    @Override
    public void c(List<String> strings) throws Ea, Eb {

    }

    public static void main(String[] args) {
        Fifteen36 fifteen36 = new Fifteen36();
        List<String> list = new ArrayList<>();
        try {
            fifteen36.a(list);
            fifteen36.b(list);
            fifteen36.c(list);
        } catch (Exception e) {

        }
    }
}
