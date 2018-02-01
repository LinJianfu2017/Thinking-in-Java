package com.linjianfu.chapter17;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Seventeen12<K, V> {
    private Object[][] pairs;
    private int index;

    public Seventeen12(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString())
                    .append(" : ");
            result.append(pairs[i][1].toString())
                    .append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Seventeen12<String, String> map = new Seventeen12<>(6);
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Out of capacity!");
        }
        System.out.println(map.get("sun"));
        System.out.println(map);
        HashMap<String, String> hashMap =
                new HashMap<>(6);
        hashMap.put("sky", "blue");
        hashMap.put("grass", "green");
        hashMap.put("ocean", "dancing");
        hashMap.put("tree", "tall");
        hashMap.put("earth", "brown");
        hashMap.put("sun", "warm");
        try {
            hashMap.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects");
        }
        System.out.println(hashMap.get("sun"));
        System.out.println(hashMap);
        TreeMap<String, String> treeMap =
                new TreeMap<>();
        treeMap.put("sky", "blue");
        treeMap.put("grass", "green");
        treeMap.put("ocean", "dancing");
        treeMap.put("tree", "tall");
        treeMap.put("earth", "brown");
        treeMap.put("sun", "warm");
        try {
            treeMap.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of capacity!");
        }
        System.out.println(treeMap.get("sun"));
        System.out.println(treeMap);
        LinkedHashMap<String, String> linkedHashMap =
                new LinkedHashMap<>(6);
        linkedHashMap.put("sky", "blue");
        linkedHashMap.put("grass", "green");
        linkedHashMap.put("ocean", "dancing");
        linkedHashMap.put("tree", "tall");
        linkedHashMap.put("earth", "brown");
        linkedHashMap.put("sun", "warm");
        try {
            linkedHashMap.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of capacity!");
        }
        System.out.println(linkedHashMap.get("sun"));
        System.out.println(linkedHashMap);
    }
}
