package com.linjianfu.chapter16;

import java.util.Arrays;

//Exercise 6,7.
public class Sixteen6 {
    static BerylliumSphere[][] arrayBerylliumSphere(int size1, int size2) {
        if ((size1 < 1) || (size2 < 1)) {
            System.out.println("size must be > 0");
            return null;
        }
        BerylliumSphere[][] result = new BerylliumSphere[size1][size2];
        for (int i = 0; i < size1; i++)
            for (int j = 0; j < size2; j++) {
                result[i][j] = new BerylliumSphere();
            }
        return result;
    }

    static BerylliumSphere[][][] arrayBerylliumSphere(int size1, int size2, int size3) {
        if ((size1 < 1) || (size2 < 1) || (size3 < 1)) {
            System.out.println("size must be > 0");
            return null;
        }
        BerylliumSphere[][][] result = new BerylliumSphere[size1][size2][size3];
        for (int i = 0; i < size1; i++)
            result[i] = arrayBerylliumSphere(size2, size3);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(arrayBerylliumSphere(2, 2)));
        System.out.println(Arrays.deepToString(arrayBerylliumSphere(2, 2, 2)));
        System.out.println(Arrays.deepToString(arrayBerylliumSphere(1, 1, 1)));


    }
}
