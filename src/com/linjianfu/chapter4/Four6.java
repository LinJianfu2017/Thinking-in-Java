package com.linjianfu.chapter4;

public class Four6 {
    static int test(int testval, int begin, int end) {
        if (begin > end) {
//            throw new IllegalArgumentException("end cannot be < begin");
            System.out.println("end cannot be < begin");
            return 0;
        } else if (testval > (begin - 1) && testval < (end + 1)) {
            return +1;
        } else if (testval < begin || testval > end) {
            return -1;
        }
        System.out.println("exceptional case！");
        return 13;
    }

    public static void main(String[] args) {
        System.out.println(test(10, 5, 4));
        System.out.println(test(5, 4, 10));
        System.out.println(test(5, 5, 6));
        System.out.println(test(10, 5, 7));
        System.out.println(test(5, 5, 5));
    }

}
