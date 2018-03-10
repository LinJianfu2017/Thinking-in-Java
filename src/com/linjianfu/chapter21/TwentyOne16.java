package com.linjianfu.chapter21;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static net.mindview.util.Print.print;

class SyncTest1 {
    private Lock lock = new ReentrantLock();

    public void f1() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            print("f1()");
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        lock.unlock();
    }

    public void g1() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            print("g1()");
            Thread.yield();
        }
        lock.unlock();
    }

    public void h1() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            print("h1()");
            Thread.yield();
        }
        lock.lock();

    }
}

class SyncTest2 { // methods synchronized on different objects
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();
    private Lock lock3 = new ReentrantLock();

    public void f2() {
        lock1.lock();
        for (int i = 0; i < 5; i++) {
            print("f2()");
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        lock1.unlock();
    }

    public void g2() {
        lock2.lock();
        for (int i = 0; i < 5; i++) {
            print("g2()");
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        lock2.unlock();
    }

    public void h2() {
        lock3.lock();
        for (int i = 0; i < 5; i++) {
            print("h2()");
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        lock3.unlock();
    }
}

public class TwentyOne16 {
    public static void main(String[] args) {
        final SyncTest1 st1 = new SyncTest1();
        final SyncTest2 st2 = new SyncTest2();
        new Thread() {
            public void run() {
                st1.f1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.g1();
            }
        }.start();
        new Thread() {
            public void run() {
                st1.h1();
            }
        }.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
        new Thread() {
            public void run() {
                st2.f2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.g2();
            }
        }.start();
        new Thread() {
            public void run() {
                st2.h2();
            }
        }.start();
    }
}