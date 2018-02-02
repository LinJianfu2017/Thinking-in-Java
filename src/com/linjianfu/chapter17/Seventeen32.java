package com.linjianfu.chapter17;

import java.util.ArrayList;

import static net.mindview.util.Print.print;

class IntegerHolder {
    private int size = 1000;
    private int index = 0;
    private int[] iArray = new int[size];

    public int size() {
        return size;
    }

    public void add(int x) {
        if (index < size) iArray[index++] = x;
        else {
            size *= 2;
            int[] newiArray = new int[size];
            System.arraycopy(iArray, 0,
                    newiArray, 0, iArray.length);
            iArray = newiArray;
            iArray[index++] = x;
        }
    }

    public int get(int i) {
        if (-1 < i && i < size) return iArray[i];
        else throw new ArrayIndexOutOfBoundsException(i);
    }

    public void incrementAll() {
        for (int i = 0; i < size; i++) iArray[i]++;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArray.length; i++) sb.append((iArray[i] + " "));
        return sb.toString();
    }
}

public class Seventeen32 {
    static long addTimeTest(IntegerHolder ih, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) ih.add(1);
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long addTimeTest(ArrayList<Integer> list, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) list.add(1);
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(IntegerHolder ih, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) ih.get(i);
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long getTimeTest(ArrayList<Integer> list, int reps) {
        long start = System.nanoTime();
        for (int i = 0; i < reps; i++) list.get(i);
        long stop = System.nanoTime();
        return (stop - start) / reps;
    }

    static long incrementTimeTest(IntegerHolder ih) {
        long start = System.nanoTime();
        ih.incrementAll();
        long stop = System.nanoTime();
        return (stop - start) / ih.size();
    }

    static long incrementTimeTest(ArrayList<Integer> list) {
        long start = System.nanoTime();
        for (Integer i : list) i++;
        long stop = System.nanoTime();
        return (stop - start) / list.size();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        IntegerHolder ih = new IntegerHolder();
        print("Add times (nanoseconds):");
        print("Mean of 1000:");
        print("ArrayList add(): " + addTimeTest(list, 1000));
        print("IntsHolder add(): " + addTimeTest(ih, 1000));
        print("Mean of 10000:");
        print("ArrayList add(): " + addTimeTest(list, 10000));
        print("IntsHolder add(): " + addTimeTest(ih, 10000));
        print();
        print("Get times (nanoseconds):");
        print("Mean of 10000:");
        print("ArrayList get(): " + getTimeTest(list, 10000));
        print("IntsHolder get(): " + getTimeTest(ih, 10000));
        print();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 0; i < 1000; i++) list3.add(1);
        IntegerHolder ih3 = new IntegerHolder();
        for (int i = 0; i < 1000; i++) ih3.add(1);
        print("Increment times (1000 elements):");
        print("ArrayList: " + incrementTimeTest(list3));
        print("IntsHolder: " + incrementTimeTest(ih3));
    }
}
