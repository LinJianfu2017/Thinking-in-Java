package com.linjianfu.chapter11;

import java.util.*;

public class Eleven5 {
    public static List<Integer> listOfRandInteger(int length, int n) {
        Random random = new Random(47);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < length; i++)
            integers.add(random.nextInt(n));
        return integers;
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        List<Integer> integers = listOfRandInteger(7, 10);//ArrayList底层实现的数组长度默认为16.
        System.out.println("1: " + integers);
        int i = 7;
        integers.add(i);
        System.out.println("2: " + integers);
        System.out.println("3: " + integers.contains(i));
        integers.remove(i);
        Integer j = integers.get(2);
        System.out.println("4: " + j + " " + integers.indexOf(j));
        Integer k = new Integer(random.nextInt(10));
        System.out.println("5: " + integers.indexOf(k));
        System.out.println("6: " + integers.remove(k));
        System.out.println("7: " + integers.remove(j));
        integers.add(3, new Integer(random.nextInt(10)));
        System.out.println("9: " + integers);
        List<Integer> sub = integers.subList(1, 4);//sub:替补，副；sublist：子表，分表，子节点列表
        System.out.println("10: " + integers.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted sublist: " + sub);
        System.out.println("11: " + integers.containsAll(sub));
        Collections.shuffle(sub, random);
        System.out.println("shuffled sublist: " + sub);
        System.out.println("12: " + integers.containsAll(sub));
        List<Integer> copy = new ArrayList<>(integers);
        sub = Arrays.asList(integers.get(1), integers.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(integers);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        if (copy.size() > 1) {
            copy.set(1, random.nextInt(10));
        }
        System.out.println("16: " + copy);
        if (copy.size() > 2) {
            copy.addAll(2, sub);
        }
        System.out.println("17: " + copy);
        System.out.println("18： " + integers.isEmpty());
        integers.clear();
        System.out.println("19: " + integers);
        System.out.println("20: " + integers.isEmpty());
        integers.addAll(listOfRandInteger(4, 20));
        System.out.println("21: " + integers);
        Object[] o = integers.toArray();
        System.out.println("22: " + o[3]);
        Integer[] in = integers.toArray(new Integer[0]);
        System.out.println("23: " + in[3]);
//        System.out.println(new Integer[0]);

    }

}
