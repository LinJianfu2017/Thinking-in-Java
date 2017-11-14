package com.linjianfu.chapter4;

import java.util.Arrays;
/**
 ************************* 下面f1~f4中，双斜杠注释部分可删除***********
 */
public class Four9 {
    /**
     * 版本一：数组元素迭代
     *
     * @param n
     */
    static void fibonacci(int n) {
        if (n < 3) {
            System.out.println("Please input an integer greater than 2 !");
            return;
        }
//        int s = 0;
        int[] a = new int[n];
        a[0] = a[1] = 1;
        for (int i = 2; i < n; i++) a[i] = a[i - 1] + a[i - 2];
//        for (int j = 0; j < n; j++) s = s + a[j];
        System.out.println("a=" + Arrays.toString(a));
//        System.out.println("sum=" + s);

    }

    /**
     * 版本二：位操作交换变量值
     *
     * @param n
     * @return
     */
    static int f1(int n) {
//        if (n <= 0) {
//            throw new IllegalArgumentException("n should be greater than zero");
//        } else if (n <= 2) {
//            return 1;
//        }
        int a = 1;
        int b = 1;
        while (n-- > 2) {
            a = a + b;
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return b;
    }

    /**
     * 版本三：加减法交换变量值
     *
     * @param n
     * @return
     */
    static int f2(int n) {
//        if (n <= 0) {
//            throw new IllegalArgumentException("n should be greater than zero");
//        } else if (n <= 2) {
//            return 1;
//        }
        int a = 1;
        int b = 1;
        while (n-- > 2) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    /**
     * 版本四：递归
     *
     * @param n
     * @return
     */
    static int f3(int n) {
//        if (n <= 0) {
//            throw new IllegalArgumentException("n should be greater than zero");
//        } else
            if (n <= 2) {
            return 1;
        }
        return f3(n - 1) + f3(n - 2);
    }

    /**
     * 版本五：
     *
     * @param n
     * @return
     */
    static int f4(int n) {
//        if (n <= 0) {
//            throw new IllegalArgumentException("n should be greater than zero");
//        } else if (n <= 2) {
//            return 1;
//        }
        int a = 1;
        int b = 1;
        while (n > 2) {
            a = a + b;
            b = b + a;
            n -= 2;
        }
        if (n % 2 == 0) return b;
        else return a;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            fibonacci(i);
            System.out.println(f1(i) + "  " + f2(i) + "  " + f3(i) + "  " + f4(i));
        }
    }
}
