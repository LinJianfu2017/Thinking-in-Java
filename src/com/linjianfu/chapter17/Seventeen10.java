package com.linjianfu.chapter17;

import net.mindview.util.RandomGenerator;
import util.coffee.Coffee;

import java.util.Iterator;
import java.util.LinkedList;

public class Seventeen10 {
    public static void main(String[] args) {
        SortedSet10<Coffee> coffees =
                new SortedSet10<>();

        for (int i = 0; i < 5; i++) {
            coffees.add(new Coffee());
        }
        System.out.println(coffees.get(4).hashCode());
        System.out.println(coffees.get(3).hashCode());
        System.out.println(coffees.get(0).hashCode());
        System.out.println(coffees);
        SortedSet10<String> strings = new SortedSet10<>();
        RandomGenerator.String rs = new RandomGenerator.String(3);
        for (int i = 0; i < 10; i++) {
            strings.add(rs.next());
        }
        System.out.println(strings);
        SortedSet10<Integer> integers = new SortedSet10<>();
        integers.add(5);
        integers.add(8);
        integers.add(1);
        integers.add(6);
        integers.add(3);
        System.out.println(integers);
        integers.add(9);
        integers.add(4);
        System.out.println(integers);
    }
}

class SortedSet10<T> extends LinkedList<T> {
    int compare(T t1, T t2) {
        int i = t1.hashCode() - t2.hashCode();
        return Integer.compare(0, i);
    }

    public boolean add(T t) {
        if (!this.contains(t)) {
            Iterator<T> it = this.iterator();
            int index = 0;
            while (it.hasNext()) {
                if (compare(it.next(), t) < 1)
                    index++;
            }
            add(index, t);
            return true;
        }
        return false;
    }

}