package com.linjianfu.chapter21;

//农历2018.1.5
public class TwentyOne8 {
    // 1,2,3,5,8
    private static int fab(int n) {
        if (n < 2) {
            return 1;
        }
        return fab(n - 1) + fab(n - 2);
    }

    private static void fibonacci(int n) {
//        if (n < 2) {
//            System.out.println(1);
//        }
        int a = 1;
        int b = 1;
        while (--n > 2) {
            a = a + b;
            b = b + a;
        }
        if (n % 2 == 0) {
            System.out.println(b);
        } else {
            System.out.println(a);
        }

    }

    // 1 1 2 3 5 8
    private static void fib3(int n) {
        int a = 1;
        int b = 1;
        while (n-- > 2) {
            b = a + b;
            a = b - a;
        }
        System.out.println(b);
    }

    public static void main(String[] args) {
        fibonacci(2);
        System.out.println(fab(3));
        fib3(3);
    }
}
