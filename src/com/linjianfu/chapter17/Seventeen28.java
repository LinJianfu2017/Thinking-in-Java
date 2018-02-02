package com.linjianfu.chapter17;

import com.linjianfu.chapter15.SixTuple;
import com.linjianfu.chapter15.Tuple;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Seventeen28 {
    public static void main(String[] args) {
        SixTuple st = Tuple.tuple(1, 1, 1, 1, 1, 1),
                st2 = Tuple.tuple(1, 1, 1, 1, 1, 0),
                st3 = Tuple.tuple(1, 1, 1, 1, 0, 1),
                st4 = Tuple.tuple(1, 1, 1, 1, 0, 0);
        System.out.println(st.compareTo(st2));
        System.out.println(st.compareTo(st3));
        System.out.println(st.compareTo(st4));
        Set<SixTuple> set = new TreeSet<>(Arrays.asList(st, st2, st3, st4));
        System.out.println(set);

    }
}
