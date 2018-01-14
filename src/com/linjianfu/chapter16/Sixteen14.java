package com.linjianfu.chapter16;

import net.mindview.util.CountingGenerator;

import java.util.Arrays;

public class Sixteen14 {
    private static int size = 10;

    public static void showBoolean() {
        CountingGenerator.Boolean b = new CountingGenerator.Boolean();
        Boolean[] bb = new Boolean[size];
        for (int i = 0; i < size; i++)
            bb[i] = b.next();
        System.out.println(Arrays.toString(bb));
    }

    public static void showByte() {
        CountingGenerator.Byte by = new CountingGenerator.Byte();
        Byte[] bytes = new Byte[size];
        for (int i = 0; i < size; i++)
            bytes[i] = by.next();
        System.out.println(Arrays.toString(bytes));
    }

    public static void showShort() {
        CountingGenerator.Short s = new CountingGenerator.Short();
        Short[] ss = new Short[size];
        for (int i = 0; i < size; i++)
            ss[i] = s.next();
        System.out.println(Arrays.toString(ss));
    }

    public static void showCharacter() {
        CountingGenerator.Character character = new CountingGenerator.Character();
        char[] chars = new char[size];
        for (int i = 0; i < size; i ++)
            chars[i] = character.next();
        System.out.println(Arrays.toString(chars));
    }

    public static void showInteger() {
        CountingGenerator.Integer integer = new CountingGenerator.Integer();
        int[] ints = new int[size];
        for (int i = 0; i < size; i++)
            ints[i] = integer.next();
        System.out.println(Arrays.toString(ints));
    }

    public static void showLong() {
        CountingGenerator.Long l = new CountingGenerator.Long();
        long[] longs = new long[size];
        for (int i = 0; i < size; i++)
            longs[i] = l.next();
        System.out.println(Arrays.toString(longs));
    }

    public static void showFloat() {
        CountingGenerator.Float f = new CountingGenerator.Float();
        float[] floats = new float[size];
        for (int i = 0; i < size; i++)
            floats[i] = f.next();
        System.out.println(Arrays.toString(floats));
    }

    public static void showDouble() {
        CountingGenerator.Double d = new CountingGenerator.Double();
        double[] doubles = new double[size];
        for (int i = 0; i < size; i++)
            doubles[i] = d.next();
        System.out.println(Arrays.toString(doubles));
    }

    public static void main(String[] args) {
        showBoolean();
        showByte();
        showCharacter();
        showDouble();
        showFloat();
        showInteger();
        showLong();
        showShort();
    }
}
