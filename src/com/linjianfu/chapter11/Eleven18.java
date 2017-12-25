package com.linjianfu.chapter11;

import java.util.*;

//Exercise 18,19.
public class Eleven18 {
    public static void main(String[] args) {
        Map<String, Gerbil> gerbilMap = new HashMap<>();
        gerbilMap.put("Fuzzy", new Gerbil());
        gerbilMap.put("Spot", new Gerbil());
        gerbilMap.put("Happy", new Gerbil());
        gerbilMap.put("Funny", new Gerbil());
        gerbilMap.put("Goofy", new Gerbil());
        gerbilMap.put("Silly", new Gerbil());
        System.out.println(gerbilMap);
        Set<String> sortedKeys = new TreeSet<>(gerbilMap.keySet());
        System.out.println(sortedKeys);
        Map<String, Gerbil> sortedGerbil = new LinkedHashMap<>();
        for (String s : sortedKeys) {
            System.out.print("Adding " + s + ",  ");
            sortedGerbil.put(s, gerbilMap.get(s));
        }
        System.out.println();
        System.out.println(sortedGerbil);
        //or,just:
        Map<String, Gerbil> sortedGerbil2 = new TreeMap<>(gerbilMap);
        System.out.println(sortedGerbil2);
        System.out.println("****************Exercise19:**********************");
        Set<String> hashedKeys = new HashSet<>(gerbilMap.keySet());
        System.out.println(hashedKeys);
        Map<String, Gerbil> hashedGerbil = new LinkedHashMap<>();
        for (String s : hashedKeys) {
            hashedGerbil.put(s, gerbilMap.get(s));
        }
        System.out.println(hashedGerbil);
        Set<String> linkedHashSet = new LinkedHashSet<>(gerbilMap.keySet());
        System.out.println(linkedHashSet);
        Map<String, Gerbil> linkedHashedGerbil = new LinkedHashMap<>();
        for (String s : linkedHashSet) {
            linkedHashedGerbil.put(s, gerbilMap.get(s));
        }
        System.out.println(linkedHashedGerbil);

    }
}
