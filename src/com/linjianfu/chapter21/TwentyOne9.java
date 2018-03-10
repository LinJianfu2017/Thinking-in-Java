package com.linjianfu.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class NumAction {
    private Integer num4 = 0;

    private void num4Increment() {
        synchronized (num4) {
            num4++;
        }
    }

    int getNum4() {
        return num4;
    }

    void add100() {
        for (int i = 0; i < 10000; i++) {
            num4Increment();
        }
    }

    void initializer() {
        this.num4 = 0;
    }

}

public class TwentyOne9 implements Runnable {
    private static NumAction numAction = new NumAction();

    @Override
    public void run() {
        numAction.add100();
    }

    public static void testRun() {
        for (int i = 0; i < 3; i++) {
            new Thread(new TwentyOne9()).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(numAction.getNum4());
        }
    }

    public static void main(String[] args) throws Exception {
//        for (int i = 0; i < 3; i++) {
//            testRun();
//            numAction.initializer();
//        }
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new TwentyOne9());
        TimeUnit.SECONDS.sleep(10);//真阻塞了十秒，主线程
        System.out.println("exec.shutdownNow()");
        exec.shutdownNow();
    }
}
