package com.linjianfu.chapter17;

import net.mindview.util.RandomGenerator;

import java.util.Set;
import java.util.TreeSet;

public class Seventeen9 {
    public static void main(String[] args) {
        int size = 20;
        Set<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        RandomGenerator.String rgs = new RandomGenerator.String(3);
        for (int i = 0; i < size; i++) {
            set.add(rgs.next());
        }
        System.out.println(set);
    }
}
