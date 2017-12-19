package com.linjianfu.chapter11;

import java.util.*;

public class Eleven12 {
    public static void main(String[] args) {
        Integer[] ints = {0, 1, 2, 3, 4, 5};
        List<Integer> ls1 = new ArrayList<>(Arrays.asList(ints));
        List<Integer> ls2 = new ArrayList<>(Arrays.asList(ints));
        System.out.println("ls1:" + ls1);
        System.out.println("ls2:" + ls2);
        ListIterator<Integer> lsIt1 = ls1.listIterator(6);
        ListIterator<Integer> lsIt2 = ls2.listIterator();
        while (lsIt2.hasNext()) {
            lsIt2.next();
            lsIt2.set(lsIt1.previous());
        }
        System.out.println("ls2:" + ls2);
        System.out.println("ls1:" + ls1);
        Random rand = new Random(47);
        Collections.shuffle(ls1, rand);
        System.out.println("ls1:" + ls1);
        while (lsIt1.hasNext() && lsIt2.hasPrevious()) {
            lsIt2.previous();
            lsIt2.set(lsIt1.next());
        }
        System.out.println("ls2:" + ls2);
        System.out.println("ls1:" + ls1);
    }
}
