package com.linjianfu.chapter4;

import java.util.Arrays;

public class Four9 {
    static void fibonacci(int n) {
        if (n < 3) {
            System.out.println("Please input an integer greater than 2 !");
            return;
        }
        int s = 0;
        int[] a = new int[n];
        a[0] = a[1] = 1;
        for (int i = 2; i < n; i++) a[i] = a[i - 1] + a[i - 2];
        for (int j = 0; j < n; j++) s = s + a[j];
        System.out.println("a=" + Arrays.toString(a));
        System.out.println("sum=" + s);

    }

    public static void main(String[] args) {
        fibonacci(9);
    }
}
