package com.linjianfu.chapter4;

import java.util.Arrays;

public class Four10 {
    private static void vampireNumbers(int digit) {
        if ((digit % 2 != 0) || digit < 2) {
            System.out.println("Input error,it mustn't be Vampire Numbers!");
            return;
        }
        int k1 = digit / 2, k2 = k1 - 1, min = (int) Math.pow(10, k2), max = (int) Math.pow(10, k1) ;
        int l1 = (int) Math.pow(10, digit), l2 = (int) Math.pow(10, digit - 1), count = 0, ij = 0, product[] = new int[l1];
        for (int i = min; i < max; i++)
            for (int j = i; j < max; j++) {
                ij = i * j;
                product[ij] = ij;
                System.out.println(ij);
            }
        for (int i = 0, a = 0; i < l1; i++) {
            a = product[i] % 100;
            if ((a != 0) && (product[i] > l2))
                product[count++] = product[i];
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(product, 0, count)));
        System.out.println("total=" + count);
    }

    public static void main(String[] args) {
        vampireNumbers(2);
    }
}
