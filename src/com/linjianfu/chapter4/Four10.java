package com.linjianfu.chapter4;

public class Four10 {
    private static void vampireNumbers(int digit) {
        if ((digit % 2 != 0) || digit < 2) {
            System.out.println("Input error,it mustn't be Vampire Numbers!");
            return;
        }
        int min = (int) Math.pow(10, digit / 2 - 1), max = (int) Math.pow(10, digit / 2) - 1;
        int l1 = (int) Math.pow(10, digit), l2 = (int) Math.pow(10, digit - 1), count = 0, ij = 0, product[] = new int[l1];
        String s[] = new String[l1];
        for (int i = min; i <= max; i++)                //遍历乘积
            for (int j = i; j <= max; j++) {
                ij = i * j;
                s[ij] = String.valueOf(i) + "*" + String.valueOf(j);
                product[ij] = ij;
            }
        for (int i = 0, a = 0; i < l1; i++) {          //筛选吸血鬼
            a = product[i] % 100;
            if ((a != 0) && (product[i] > l2)) {
//                product[count++] = product[i];
                count++;
                System.out.println(product[i] + "=" + s[i]);
            }
        }
//        System.out.println(Arrays.toString(Arrays.copyOfRange(product, 0, count)));  //合影留念
        System.out.println("total=" + count);                                              //获奖人数
    }

    /**
     * 下面为参考答案的方法-->仅限四位吸血鬼
     *
     * @param i
     * @return
     */

    static int a(int i) {
        return i / 1000;
    }

    static int b(int i) {
        return (i % 1000) / 100;
    }

    static int c(int i) {
        return ((i % 1000) % 100) / 10;
    }

    static int d(int i) {
        return ((i % 1000) % 100) % 10;
    }

    static int com(int i, int j) {
        return (i * 10) + j;
    }

    static void productTest(int i, int m, int n) {
        if (m * n == i) System.out.println(i + " = " + m + " * " + n);
    }


    public static void main(String[] args) {
        vampireNumbers(4);
/**
 * 下面为参考答案的main方法部分
 */
        for (int i = 1001; i < 9999; i++) {
            productTest(i, com(a(i), b(i)), com(c(i), d(i)));
            productTest(i, com(a(i), b(i)), com(d(i), c(i)));
            productTest(i, com(a(i), c(i)), com(b(i), d(i)));
            productTest(i, com(a(i), c(i)), com(d(i), b(i)));
            productTest(i, com(a(i), d(i)), com(b(i), c(i)));
            productTest(i, com(a(i), d(i)), com(c(i), b(i)));
            productTest(i, com(b(i), a(i)), com(c(i), d(i)));
            productTest(i, com(b(i), a(i)), com(d(i), c(i)));
            productTest(i, com(b(i), c(i)), com(d(i), a(i)));
            productTest(i, com(b(i), d(i)), com(c(i), a(i)));
            productTest(i, com(c(i), a(i)), com(d(i), b(i)));
            productTest(i, com(c(i), b(i)), com(d(i), a(i)));
        }
    }
}

