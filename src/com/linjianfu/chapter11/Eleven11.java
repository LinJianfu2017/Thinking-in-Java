package com.linjianfu.chapter11;

import java.util.*;

public class Eleven11 {
    public static void display(Iterator<Eleven10.Rodent> iterator) {
        while (iterator.hasNext())
            System.out.print(iterator.next());
        System.out.println();
    }

    public static void main(String[] args) {
        Eleven10 eleven10 = new Eleven10();
        ArrayList<Eleven10.Rodent> arrayList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            arrayList.add(eleven10.nextRodent());
        LinkedList<Eleven10.Rodent> linkedList = new LinkedList<>(arrayList);
        HashSet<Eleven10.Rodent> hashSet = new HashSet<>(arrayList);
        /**
         ***HashSet是借助HashMap来实现的，利用HashMap中Key的唯一性，来保证HashSet中不会出现重复值。
         HashSet中的元素实际上是作为HashMap中的Key存放在后者中的；
         而后者中的Key是根据对象的hashCode()和equals()来判断是否唯一的。
         ***为了保证HashSet中的对象不会出现重复值，
         在被存放元素的类中必须要重写hashCode()和equals()这两个方法。
         ***
         *
         * 那么新的？问题来了   为啥这几个Set光是TreeMap抛出异常呢？？如下：
         * 《先记着》
         * */
        //Error:xxxx cannot be cast to java.lang.Comparable...
//        TreeSet<Eleven10.Rodent> treeSet = new TreeSet<>(arrayList);
        LinkedHashSet<Eleven10.Rodent> linkedHashSet = new LinkedHashSet<>(arrayList);
        display(arrayList.iterator());
        display(linkedList.iterator());
        display(hashSet.iterator());
        System.out.println(hashSet);
//        display(treeSet.iterator());
        display(linkedHashSet.iterator());
        /***
         * 上面两个Set输出结果都存在重复元素的情况，这是怎么了，，，求救,,,,,,,,,
         * */
    }
}
