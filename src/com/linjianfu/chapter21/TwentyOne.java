package com.linjianfu.chapter21;


public class TwentyOne implements Runnable {
    private static long counter = 0;
    private final long id = counter++;

    private TwentyOne() {
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
        for (int i = 0; i < 5; i++) {
            new Thread(new TwentyOne()).start();
        }
    }

}
