package com.linjianfu.chapter16;

import net.mindview.util.Generator;

import java.util.Arrays;

public class Sixteen12 {
    private static class Double implements Generator<java.lang.Double> {
        private double value = 0;

        @Override
        public java.lang.Double next() {
            double result = value;
            value += 4.0;
            return result;
        }
    }

    public static void main(String[] args) {
        double[] doubles = new double[10];
        Sixteen12.Double dg=new Double();
        for (int i = 0; i < doubles.length; i++)
            doubles[i] =dg.next();
        System.out.println(Arrays.toString(doubles));
    }
}
