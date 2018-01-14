package com.linjianfu.chapter16;

import java.util.Arrays;
import java.util.Comparator;

public class Sixteen21 {
    static class CompBerylliumSphere implements Comparable<CompBerylliumSphere> {
        private static long counter = 0;
        private final long id = counter++;

        @Override
        public String toString() {
            return getClass().getSimpleName() + " " + id;
        }

        @Override
        public int compareTo(CompBerylliumSphere o) {
            return this.id > o.id ? 1 : (this.id == o.id ? 0 : -1);
        }
    }

    static class CompBerylliumSphereComparator implements Comparator<CompBerylliumSphere> {
        @Override
        public int compare(CompBerylliumSphere o1, CompBerylliumSphere o2) {
            return o1.id > o2.id ? -1 : (o1.id == o2.id ? 0 : 1);
        }
    }

    public static void main(String[] args) {
        BerylliumSphere[] bsa = new BerylliumSphere[3];
        for (int i = 0; i < bsa.length; i++)
            bsa[i] = new BerylliumSphere();
        /**
         * ClassCastException: com.linjianfu.chapter16.BerylliumSphere cannot be
         * cast to java.lang.Comparable:
         * */
//        Arrays.sort(bsa);
        CompBerylliumSphere[] cbsa = new CompBerylliumSphere[3];
        for (int i = 0; i < cbsa.length; i++)
            cbsa[i] = new CompBerylliumSphere();
        System.out.println("before sort:\n" + Arrays.toString(cbsa));
        Arrays.sort(cbsa);
        System.out.println("sorted:\n" + Arrays.toString(cbsa));
        Arrays.sort(cbsa, new CompBerylliumSphereComparator());
        System.out.println("reverse sorted:\n" + Arrays.toString(cbsa));
    }
}
