package com.linjianfu.chapter11;

import java.util.Collection;
import java.util.TreeSet;

public class Eleven2 {
    public static void main(String[] args) {
        Collection<Integer> c = new TreeSet<>();
        for (int i = 0; i < 10; i++)
            c.add(i);
        for (Integer i : c)
            System.out.print(i + " ");
    }
}
