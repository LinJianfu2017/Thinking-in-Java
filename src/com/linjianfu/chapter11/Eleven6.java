package com.linjianfu.chapter11;

import java.util.*;

public class Eleven6 {
    public static void main(String[] args) {
        Random random = new Random(47);
        List<String> Strings = new ArrayList<>();//ArrayList底层实现的数组长度默认为16.
        System.out.println("0:" + Strings);
        Collections.addAll(Strings, "one", "two", "three", "four", "five");
        System.out.println("1: " + Strings);
        String s = new String("QQ");
        Strings.add(s);
        System.out.println("2: " + Strings);
        System.out.println("3: " + Strings.contains(s));
        Strings.remove(s);
        System.out.println("3.5:" + Strings);
        String s1 = Strings.size() > 2 ? Strings.get(2) : null;
        System.out.println("4: " + s1 + " " + Strings.indexOf(s1));
        String s2 = new String("WX");
        System.out.println("5: " + Strings.indexOf(s2));
        System.out.println("6: " + Strings.remove(s2));
        System.out.println("7: " + Strings.remove(s1));
        System.out.println("8: " + Strings);
        if (Strings.size() > 3) {
            Strings.add(3, "MIT");
        }
        System.out.println("9: " + Strings);
        if (Strings.size() < 4) {
            List<String> s3 = Arrays.asList("Go", "to", "hell");
            Strings.addAll(0, s3);
        }
        List<String> sub = Strings.subList(1, 4);//sub:替补，副；sublist：子表，分表，子节点列表
        System.out.println("10: " + Strings.containsAll(sub));
        Collections.sort(sub);
        System.out.println("sorted sublist: " + sub);
        System.out.println("11: " + Strings.containsAll(sub));
        System.out.println("Strings: " + Strings);
        Collections.shuffle(sub, random);
        System.out.println("Strings" + Strings);
        System.out.println("shuffled sublist: " + sub);
        System.out.println("12: " + Strings.containsAll(sub));
        List<String> copy = new ArrayList<>(Strings);
        System.out.println("Strings" + Strings);
        if (Strings.size() < 10) {
            Strings.add("add");
            Strings.add("more");
        }
        sub = Arrays.asList(Strings.get(1), Strings.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        copy = new ArrayList<>(Strings);
        copy.remove(2);
        System.out.println("14: " + copy);
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        if (copy.size() > 1) {
            copy.set(1, "wtf");
        }
        System.out.println("16: " + copy);
        if (copy.size() > 2) {
            copy.addAll(2, sub);
        }
        System.out.println("17: " + copy);
        System.out.println("18： " + Strings.isEmpty());
        Strings.clear();
        System.out.println("19: " + Strings);
        System.out.println("20: " + Strings.isEmpty());
        Strings.addAll(0, sub);
        Strings.addAll(copy);
        System.out.println("21: " + Strings);
        Object[] o = Strings.toArray();
        System.out.println("22: " + o[3]);
        //Run-time error:
        //java.lang.ClassCastException:
        //[Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
//        String[] s4 = (String[]) Strings.toArray();
        //OK:
        String[] s4 = Strings.toArray(new String[0]);

        System.out.println("23: " + s4[3]);
    }

}


