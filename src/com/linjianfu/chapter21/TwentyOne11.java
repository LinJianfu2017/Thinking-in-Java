package com.linjianfu.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class NumRangeGenerator {
    private volatile boolean canceled = false;

    public abstract int[] next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}

class NumRangeGenerator11 extends NumRangeGenerator {
    private int min = 0;
    private int max = 0;
    private int[] range = {min, max};
    private Random rand = new Random();

    @Override
    public int[] next() {
        min = rand.nextInt(100);
        max = rand.nextInt(100);
        Thread.yield();
        if (min > max) {
            max = min;
        }
        int[] ia = {min, max};
        return ia;
    }
}

class SynchronizedNumRangeGenerator11 extends NumRangeGenerator11 {
    @Override
    public synchronized int[] next() {
        return super.next();
    }
}

public class TwentyOne11 {
    static class NumRangeChecker implements Runnable {
        private NumRangeGenerator generator;
        private final int id;

        public NumRangeChecker(NumRangeGenerator ng, int ident) {
            generator = ng;
            id = ident;
        }

        @Override
        public void run() {
            System.out.println("Testing...");
            while (!generator.isCanceled()) {
                int[] range = generator.next();
                if (range[0] > range[1]) {
                    System.out.println("Error in test #" + id + ": min " +
                            range[0] + ">" + "max " + range[1]);
                    generator.cancel();
                }
            }
        }

        public static void test(NumRangeGenerator gen, int count) {
            System.out.println("Press Ctrl-C to exit");
            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < count; i++) {
                exec.execute(new NumRangeChecker(gen, i));
            }
            exec.shutdown();
        }

        public static void test(NumRangeGenerator gen) {
            test(gen, 10);
        }
    }

    public static void main(String[] args) {
        NumRangeChecker.test(new NumRangeGenerator11());
//        NumRangeChecker.test(new SynchronizedNumRangeGenerator11());
    }
}
