package com.linjianfu.chapter16;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;
import java.util.Comparator;

//Exercise 22,23.
public class Sixteen22 {
    public static void main(String[] args) {
        RandomGenerator.Character rgc = new RandomGenerator.Character();
        Character[] chars = Generated.array(Character.class, rgc, 20);
        System.out.println(Arrays.toString(chars));
        int count = 0;
        while (true) {
            char c = rgc.next();
            int location = Arrays.binarySearch(chars, c);
            count++;
            if (location >= 0) {
                System.out.println("Location of " + c + " is " + location + ",chars[" + location + "] = " + chars[location]);
                System.out.println("Search " + count + " times in total.");
                break;
            }
        }
        System.out.println("---------------------------------------------------------------");
        RandomGenerator.Integer rgi = new RandomGenerator.Integer();
        Integer[] integers = Generated.array(Integer.class, rgi, 20);
        System.out.println("before sort:\n" + Arrays.toString(integers));
        Arrays.sort(integers);
        System.out.println("sorted:\n" + Arrays.toString(integers));
        Arrays.sort(integers, Comparator.reverseOrder());
        System.out.println("reverse sorted:\n" + Arrays.toString(integers));
    }
}
