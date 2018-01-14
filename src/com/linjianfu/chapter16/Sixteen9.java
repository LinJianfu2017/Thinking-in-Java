package com.linjianfu.chapter16;

import java.util.ArrayList;
import java.util.List;

class Banana {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Banana " + id;
    }
}

class Peel<T> {
    private static long counter;
    private final long id = counter++;
    private T t;

    public Peel(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Peel " + id + " " + t;
    }
}

public class Sixteen9 {
    public static void main(String[] args) {
//        Peel<Banana>[] peelArray = new Peel<Banana>[10];//Generic array creation.
        List<Peel<Banana>> peelList = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            peelList.add(new Peel<>(new Banana()));
        System.out.println(peelList);
        System.out.println(peelList.get(0).getClass());
    }

}
