package com.linjianfu.chapter17;

import net.mindview.util.Countries;

import java.util.*;

public class Seventeen7 {
    public static void main(String[] args) {
        int size = 10;
        ArrayList<String> arrayList = new ArrayList<>(Countries.names(size));
        LinkedList<String> linkedList = new LinkedList<>(Countries.names(size));
        Iterator ita = arrayList.iterator(),
                itl = linkedList.iterator();
        while (ita.hasNext()) {
            System.out.print(ita.next() + (ita.hasNext() ? "," : ""));
        }
        System.out.println();
        while (itl.hasNext()) {
            System.out.print(itl.next() + (itl.hasNext() ? "," : ""));
        }
        System.out.println();
        ListIterator lita = arrayList.listIterator();
        ListIterator litl = linkedList.listIterator();
        while (litl.hasNext()) {
            lita.add(litl.next());
            lita.next();
        }
        System.out.println(arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>(Countries.names(size));
        ListIterator lita2 = arrayList2.listIterator(arrayList2.size());
        litl = linkedList.listIterator(0);
        while (litl.hasNext()) {
            lita2.add(litl.next());
            lita2.previous();
            lita2.previous();
        }
        System.out.println(arrayList2);
    }
}
