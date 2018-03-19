package com.linjianfu.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private Restaurant26 restaurant;
    protected boolean clean = true;
    protected Meal m;

    WaitPerson(Restaurant26 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                m = restaurant.meal;
                System.out.println("WaitPerson got " + m);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
                System.out.println("WaitPerson delivered " + m);
                synchronized (restaurant.busBoy) {
                    clean = false;
                    restaurant.busBoy.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private Restaurant26 restaurant;
    private int count = 0;

    Chef(Restaurant26 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("Out of food,closing");
                    restaurant.exec.shutdownNow();
                    return;
                }
                System.out.println("Order up!");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}

class BusBoy implements Runnable {
    private Restaurant26 restaurant;

    BusBoy(Restaurant26 restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.waitPerson.clean) {
                        wait();
                    }
                    System.out.println("BusBoy cleaning up " + restaurant.waitPerson.m);
                    restaurant.waitPerson.clean = true;
                }

            }
        } catch (InterruptedException e) {
            System.out.println("BudBoy interrupted");
        }
    }
}

public class Restaurant26 {
    Meal meal;
    ExecutorService exec = Executors.newCachedThreadPool();
    WaitPerson waitPerson = new WaitPerson(this);
    BusBoy busBoy = new BusBoy(this);
    Chef chef = new Chef(this);

    public Restaurant26() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant26();
    }
}
