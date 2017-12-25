package com.linjianfu.chapter11;

import java.util.LinkedList;
import java.util.ListIterator;

public class Eleven14 {
    public static void addMiddle(LinkedList<Integer> linkedList, Integer[] integers) {

        for (Integer i : integers) {
            ListIterator<Integer> listIterator = linkedList.listIterator(linkedList.size() / 2);
            listIterator.add(i);
            System.out.println(linkedList);
        }


    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Integer[] integers = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        addMiddle(linkedList, integers);
    }
}
