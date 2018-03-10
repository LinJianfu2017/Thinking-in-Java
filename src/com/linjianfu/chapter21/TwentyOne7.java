package com.linjianfu.chapter21;

public class TwentyOne7 {
    public static void main(String[] args) {
        int COUNT_BITS = Integer.SIZE - 3;
        int RUNNING = -1 << COUNT_BITS;
        int ct = RUNNING | 0;
        int CAPACITY = (1 << COUNT_BITS) - 1;
        System.out.println(COUNT_BITS);
        System.out.println(Integer.toBinaryString(COUNT_BITS));
        System.out.println(Integer.toBinaryString(RUNNING));
        System.out.println(Integer.toBinaryString(CAPACITY));
        System.out.println(Integer.toBinaryString(CAPACITY & ct));
        System.out.println(Integer.toBinaryString(~CAPACITY & ct));
    }
}
