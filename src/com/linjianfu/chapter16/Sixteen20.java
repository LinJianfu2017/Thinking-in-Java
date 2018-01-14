package com.linjianfu.chapter16;

import java.util.Arrays;

public class Sixteen20 {
    public static void main(String[] args) {
        Ex19[][][] a = new Ex19[2][3][4];
        Ex19[][][] b = new Ex19[2][3][4];
        System.out.println(Arrays.deepToString(a));
        System.out.println(Arrays.deepEquals(a, b));//true
        int[][][] i = new int[2][3][4];
        int[][][] j = new int[2][3][4];
        System.out.println(Arrays.deepToString(i));
        System.out.println(Arrays.deepEquals(i, j));//true
        System.out.println(Arrays.deepEquals(a, j));//false
        Integer[][][] k = new Integer[2][3][4];
        System.out.println(Arrays.deepToString(k));
        System.out.println(Arrays.deepEquals(a, k));//true
    }
}
