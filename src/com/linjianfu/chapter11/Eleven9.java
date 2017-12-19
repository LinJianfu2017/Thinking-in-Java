package com.linjianfu.chapter11;

import java.util.ArrayList;
import java.util.Iterator;

public class Eleven9 {
    private static class Sequence {
        ArrayList<Object> items = new ArrayList<>();

        private void add(Object x) {
            items.add(x);
        }

        private Iterator iterator() {
            return items.iterator();
        }
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; i++)
            sequence.add(i);
        Iterator iterator = sequence.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}
