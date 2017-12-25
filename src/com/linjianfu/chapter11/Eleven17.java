package com.linjianfu.chapter11;

import java.util.*;

public class Eleven17 {
    private static Map<String, List<Gerbil>> map = new HashMap<>();

    static {
        map.put("Fuzzy", Arrays.asList(new Gerbil(), new Gerbil()));
        map.put("Spot", Arrays.asList(new Gerbil(), new Gerbil(), new Gerbil()));
        map.put("Doubi", Arrays.asList(new Gerbil(), new Gerbil(), new Gerbil(), new Gerbil()));
        map.put("Zhutou", Arrays.asList(new Gerbil()));
    }

    public static void main(String[] args) {
        Map<String, List<Gerbil>> copy = new HashMap<>(map);
        System.out.println("Key: " + copy.keySet());
        System.out.println("Value: " + copy.values());
        Iterator<String> iterator = copy.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " has:");
            for (Gerbil gerbil : copy.get(key)) {
//                System.out.print(gerbil + ", ");
                gerbil.hop();
            }
            System.out.println();
        }
    }
}
