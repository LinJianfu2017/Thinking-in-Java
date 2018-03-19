package com.linjianfu.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwentyOne32 {
    public static void main(String[] args) throws Exception {
        int size = 5;
        CountDownLatch stopSignal = new CountDownLatch(1),
                doneSignal = new CountDownLatch(size);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            exec.execute(new Entrance32(i, stopSignal, doneSignal));
        }
        TimeUnit.SECONDS.sleep(5);
        stopSignal.countDown();
        doneSignal.await();
        exec.shutdown();
        System.out.println("Total: " + Entrance32.getTotalCount());
        System.out.println("Sum of entrances: " + Entrance32.sumEntrances());
    }
}

class Entrance32 implements Runnable {
    private static Count count = new Count();
    private static List<Entrance32> entrances = new ArrayList<>();
    private int number = 0;
    private int id;
    private final CountDownLatch stopSignal;
    private static CountDownLatch doneSignal;

    Entrance32(int idn, CountDownLatch stopSignal, CountDownLatch doneSignal) {
        id = idn;
        this.stopSignal = stopSignal;
        this.doneSignal = doneSignal;
        entrances.add(this);
    }

    @Override
    public void run() {
        while (!(stopSignal.getCount() == 0)) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Closing " + this);
        doneSignal.countDown();
    }

    public synchronized int getValue() {
        return number;
    }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance32 entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}
