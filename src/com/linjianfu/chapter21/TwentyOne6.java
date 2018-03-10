package com.linjianfu.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwentyOne6 implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random();

    @Override
    public void run() {
        int i = rand.nextInt(10);
        try {
            TimeUnit.MILLISECONDS.sleep(1000*i);
            System.out.println(id + ": sleep(" + i + ")");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new TwentyOne6());
        }
        exec.shutdown();
    }
}
