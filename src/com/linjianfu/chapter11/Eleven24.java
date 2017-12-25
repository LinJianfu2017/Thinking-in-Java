package com.linjianfu.chapter11;

import java.util.*;

public class Eleven24 {
    public static Gerbil makeGerbil() {
        return new Gerbil();
    }

    public static void main(String[] args) {
        Map<String, Gerbil> gerbilMap = new LinkedHashMap<>();
        gerbilMap.put("four", makeGerbil());
        gerbilMap.put("Five", makeGerbil());
        gerbilMap.put("Three", makeGerbil());
        gerbilMap.put("six", makeGerbil());
        gerbilMap.put("two", makeGerbil());
        gerbilMap.put("Seven", makeGerbil());
        gerbilMap.put("One", makeGerbil());
        gerbilMap.put("eight", makeGerbil());
        gerbilMap.put("zero", makeGerbil());
        gerbilMap.put("Nine", makeGerbil());
        System.out.println("gerbilMap: ");
        System.out.println(gerbilMap);
        Map<String, Gerbil> copy = new LinkedHashMap<>(gerbilMap);
        System.out.println("copy gerbilMap：");
        System.out.println(copy);
//        Set<String> sortedKeys = new TreeSet<>(copy.keySet());//字典序
        Set<String> sortedKeys = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);//字母序
        sortedKeys.addAll(copy.keySet());
        System.out.println("sortedKeys： " + sortedKeys);
        gerbilMap.clear();
        System.out.println("clear gerbilMap: ");
        System.out.println(gerbilMap);
        Iterator<String> iterator = sortedKeys.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            gerbilMap.put(s, copy.get(s));
        }
        System.out.println("sorted gerbilMap: ");
        System.out.println(gerbilMap);
    }
}
