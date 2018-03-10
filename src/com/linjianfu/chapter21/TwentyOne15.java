package com.linjianfu.chapter21;

import java.util.concurrent.TimeUnit;

public class TwentyOne15 {
    private static int times = 10;
    private final Object objectLock1 = new Object();
    private final Object objectLock2 = new Object();
    private final Object objectLock3 = new Object();

    private void f() {
        synchronized (this) {
            for (int i = 0; i < times; i++) {
                System.out.println("f()");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    //do nothing
                }
            }
        }
    }

    private void g() {
        synchronized (this) {
            for (int i = 0; i < times; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }

    private void h() {
        synchronized (this) {
            for (int i = 0; i < times; i++) {
                System.out.println("h()");
                Thread.yield();
            }
        }
    }


    private void f2() {
        synchronized (objectLock1) {
            for (int i = 0; i < times; i++) {
                System.out.println("f2()");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    //do nothing
                }
            }
        }
    }

    private void g2() {
        synchronized (objectLock2) {
            for (int i = 0; i < times; i++) {
                System.out.println("g2()");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    //do nothing
                }
            }
        }
    }

    private void h2() {
        synchronized (objectLock3) {
            for (int i = 0; i < times; i++) {
                System.out.println("h2()");
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    //do nothing
                }
            }
        }
    }

    public static void main(String[] args) {
        TwentyOne15 twentyOne15 = new TwentyOne15();
        TwentyOne15 twentyOne152 = new TwentyOne15();
        new Thread() {
            @Override
            public void run() {
                twentyOne15.f();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                twentyOne15.g();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                twentyOne15.h();
            }
        }.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        new Thread() {
            @Override
            public void run() {
                twentyOne152.f2();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                twentyOne152.g2();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                twentyOne152.h2();
            }
        }.start();
    }

}
