package com.linjianfu.chapter15;

import net.mindview.util.TwoTuple;

public class Fifteen15 {
    private static TwoTuple<String, Integer> f() {
        return Tuple.tuple("hi", 47);
    }

    private static TwoTuple f2() {
        return Tuple.tuple("hi", 47);
    }

    //16:
    private static SixTuple<Boolean, Byte, Character, Integer, Float, Double> f6() {
        return Tuple.tuple(1 < 2, (byte) 0, (char) 1, 0, 1.0f, 0.1);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        TwoTuple<String, Integer> generic2Tuple = f();
        System.out.println(generic2Tuple);
        TwoTuple<String, Integer> twoTuple = f2();//unchecked assignment
        System.out.println(twoTuple);
        System.out.println(f6());

    }
}
