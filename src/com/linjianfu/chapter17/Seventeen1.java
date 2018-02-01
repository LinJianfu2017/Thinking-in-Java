package com.linjianfu.chapter17;

import net.mindview.util.Countries;

import java.util.*;

public class Seventeen1 {
    public static void shuffleTest(List<String> list, int size) {
        size = size < 0 ? 0 : size % Countries.DATA.length;
        for (int i = 0; i < size; i++)
            list.add(Countries.DATA[i][0]);
        for (int i = 0; i < 5; i++) {
//            Collections.sort(list);
            Collections.shuffle(list);
            System.out.println(list);
            Collections.sort(list);
//            System.out.println(list);
        }
    }

    //Ex2
    public static void f() {
        Map<String, String> map = new TreeMap<>();
        Set<String> set = map.keySet();
        for (String[] country : Countries.DATA)
            if (country[0].matches("A.*"))
                map.put(country[0], country[1]);
        System.out.println(map);
        System.out.println();
        System.out.println(set);

    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        shuffleTest(arrayList, 5);
        System.out.println();
        shuffleTest(linkedList, 5);
        f();
    }
}
