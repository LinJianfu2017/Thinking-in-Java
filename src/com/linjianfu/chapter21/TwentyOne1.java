package com.linjianfu.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwentyOne1 implements Runnable {
    private static long counter = 0;
    private final long id = counter++;

    private TwentyOne1() {
        System.out.println("Starting");
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(id + ": run()");
        }
        System.out.println("Complete");
        Thread.yield();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor(),
                exec2 = Executors.newCachedThreadPool(),
                exec3 = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 3; i++) {
//            new Thread(new Twenty1()).start();
            exec.execute(new TwentyOne1());
            exec2.execute(new TwentyOne1());
            exec3.execute(new TwentyOne1());

        }
        exec.shutdown();
        exec2.shutdown();
        exec3.shutdown();
    }

}

