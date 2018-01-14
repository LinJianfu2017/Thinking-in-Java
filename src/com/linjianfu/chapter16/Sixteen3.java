package com.linjianfu.chapter16;

import java.util.Arrays;
//Exercise 3,4.
public class Sixteen3 {
    public static double[][] array2Dimension(int size1, int size2, double start, double end) {
        if (!(start < end)) {
            System.out.println("start must be less than end");
            return null;
        }
        if ((size1 < 1) || (size2 < 1)) {
            System.out.println("size must be > 0");
            return null;
        }
        double[][] result = new double[size1][size2];
        for (int i = 0; i < size1; i++)
            for (int j = 0; j < size2; j++) {
                result[i][j] = start + (double) j / (size2 - 1)
                        * ((double) j + (double) i) / (size2 + i - 1) * (end - start);//'NaN'：非数值、非数字。
            }
        return result;
    }

    public static double[][][] array3Dimension(int size1, int size2, int size3, double start, double end) {
        if (!(start < end)) {
            System.out.println("start must be less than end");
            return null;
        }
        if ((size1 < 1) || (size2 < 1) || (size3 < 1)) {
            System.out.println("size must be > 0");
            return null;
        }
        double[][][] result = new double[size1][size2][size3];
        for (int i = 0; i < size1; i++)
            result[i] = array2Dimension(size2, size3, start, end);

        return result;
    }

    static void printArrayDouble(double[][] doubles) {
        System.out.println(Arrays.deepToString(doubles));
    }

    static void printArrayDouble(double[][][] doubles) {
        System.out.println(Arrays.deepToString(doubles));
    }

    public static void main(String[] args) {
        printArrayDouble(array2Dimension(3, 3, 1, 3));
        printArrayDouble(array2Dimension(5, 4, 11, 20));

        printArrayDouble(array3Dimension(1, 1, 1, 0, 1));//results:[[[NaN]]]
        printArrayDouble(array3Dimension(2, 3, 3, 0, 1));
    }
}
