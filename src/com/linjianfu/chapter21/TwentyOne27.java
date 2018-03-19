package com.linjianfu.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TwentyOne27 {
    public static void main(String[] args) {
        new Restaurant27();
    }
}

class Meal27 {
    private final int orderNum;

    Meal27(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson27 implements Runnable {
    private Restaurant27 restaurant27;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();
    protected Meal27 m;
    protected boolean clean = true;

    WaitPerson27(Restaurant27 restaurant27) {
        this.restaurant27 = restaurant27;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant27.meal27 == null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                m = restaurant27.meal27;
                System.out.println("WaitPerson got " + m);
                restaurant27.chef27.lock.lock();
                try {
                    restaurant27.meal27 = null;
                    restaurant27.chef27.condition.signalAll();
                } finally {
                    restaurant27.chef27.lock.unlock();
                }
                System.out.println("WaitPerson delivered " + m);
                restaurant27.busBoy27.lock.lock();
                try {
                    clean = false;
                    restaurant27.busBoy27.condition.signalAll();
                } finally {
                    restaurant27.busBoy27.lock.unlock();
                }

            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Chef27 implements Runnable {
    private Restaurant27 restaurant27;
    private int count = 0;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    Chef27(Restaurant27 restaurant27) {
        this.restaurant27 = restaurant27;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant27.meal27 != null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    System.out.println("Out of food,closing");
                    restaurant27.exec.shutdownNow();
                    return;
                }
                System.out.println("Order up!");
                restaurant27.waitPerson27.lock.lock();
                try {
                    restaurant27.meal27 = new Meal27(count);
                    restaurant27.waitPerson27.condition.signalAll();
                } finally {
                    restaurant27.waitPerson27.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}

class BusBoy27 implements Runnable {
    private Restaurant27 restaurant27;
    protected Lock lock = new ReentrantLock();
    protected Condition condition = lock.newCondition();

    BusBoy27(Restaurant27 restaurant27) {
        this.restaurant27 = restaurant27;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                while (restaurant27.waitPerson27.clean) {
                    condition.await();
                }
                System.out.println("BusBoy cleaing up " + restaurant27.waitPerson27.m);
                restaurant27.waitPerson27.clean = true;
            }
        } catch (InterruptedException e) {
            System.out.println("BusBoy interrupted");
        }
    }
}

class Restaurant27 {
    Meal27 meal27;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson27 waitPerson27 = new WaitPerson27(this);
    BusBoy27 busBoy27 = new BusBoy27(this);
    Chef27 chef27 = new Chef27(this);

    public Restaurant27() {
        exec.execute(chef27);
        exec.execute(waitPerson27);
        exec.execute(busBoy27);
    }
}