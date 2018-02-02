package com.linjianfu.chapter17;

import java.util.HashMap;
import java.util.Map;

public class Seventeen26 {
    public static void main(String[] args) {
        Map<CountedString26, Integer> map =
                new HashMap<>();
        CountedString26[] cs = new CountedString26[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString26("hi",'j');
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString26 c : cs) {
            System.out.println("Looking up " + c);
            System.out.println(map.get(c));
        }
    }
}
