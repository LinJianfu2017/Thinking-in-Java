package com.linjianfu.chapter17;

import java.util.ArrayList;

import static net.mindview.util.Print.print;

class StringsHolder {
    private int size = 1000;
    private int index = 0;
    private String[] sArray = new String[size];

    public void add(String s) {
        if (index < size) sArray[index++] = s;
        else {
            size *= 2;
            String[] newArray = new String[size];
            System.arraycopy(sArray, 0, newArray,
                    0, sArray.length);
            sArray = newArray;
            sArray[index++] = s;
        }
    }

    public String get(int i) {
        if (-1 < i && i < size) return sArray[i];
        else throw new ArrayIndexOutOfBoundsException(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sArray.length; i++)
            sb.append((sArray[i] + " "));
        return sb.toString();
    }
}

public class Seventeen31 {
    static long addTimeTest(StringsHolder sh, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) sh.add("hi");
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long addTimeTest(ArrayList<String> list, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) list.add("hi");
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(StringsHolder sh, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) sh.get(i);
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(ArrayList<String> list, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) list.get(i);
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        StringsHolder sh = new StringsHolder();
        print("Add times (nanoseconds):");
        print("Mean of 1000:");
        print("ArrayList add(): " + addTimeTest(list, 1000));
        print("StringsHolder add(): " + addTimeTest(sh, 1000));
        print("Mean of 10000:");
        print("ArrayList add(): " + addTimeTest(list, 10000));
        print("StringsHolder add(): " + addTimeTest(sh, 10000));
        print();
        print("Get times (nanoseconds):");
        print("Mean of 10000:");
        print("ArrayList get(): " + getTimeTest(list, 10000));
        print("StringsHolder get(): " + getTimeTest(sh, 10000));
    }
}