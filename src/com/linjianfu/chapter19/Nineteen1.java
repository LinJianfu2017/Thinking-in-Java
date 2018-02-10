package com.linjianfu.chapter19;

public class Nineteen1 {
    public static void main(String[] args) {
        long l = -1,l1=1;
        System.out.println(l + " = " + Long.toBinaryString(l));
        System.out.println((l >>> -12) + " = " + Long.toBinaryString(l >>> -76));
        System.out.println((l >>> -12) + " = " + Long.toBinaryString(l >>> -12));
        System.out.println((l >>> 52) + " = " + Long.toBinaryString(l >>> 52));
        System.out.println((l1 >>> 31));
        System.out.println(((long)-2 & (long) 2));
    }
}
/**
 * -1 = 1111111111111111111111111111111111111111111111111111111111111111
 * 4095 = 111111111111
 * 4095 = 111111111111
 * 4095 = 111111111111
 * 0
 * <p>
 * Process finished with exit code 0
 */
