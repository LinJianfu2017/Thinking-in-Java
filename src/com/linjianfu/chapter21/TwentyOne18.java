package com.linjianfu.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TwentyOne18 {
    public static void main(String[] args) {
        //Three ways to do it:
        //use 'Thread'
        Thread t = new Thread(new Worker());
        t.start();
        t.interrupt();
        //use 'Executor execute'
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(new Worker());
        exec.shutdownNow();
        //use 'Executor submit'
        ExecutorService exec2 = Executors.newSingleThreadExecutor();
        Future<?> f = exec2.submit(new Worker());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted in main()");
        }
        f.cancel(true);
        exec2.shutdown();
    }
}

class NonTask {
    public static void test() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        } finally {
            System.out.println("Byebye");
        }
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        NonTask.test();
    }
}