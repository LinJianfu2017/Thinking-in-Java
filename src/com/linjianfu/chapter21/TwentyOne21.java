package com.linjianfu.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TwentyOne21 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Task2 task2 = new Task2(new Task1());
        exec.execute(task2.getTask1());
        exec.execute(task2);
        exec.shutdown();
    }
}

class Task1 implements Runnable {
    @Override
    public synchronized void run() {
        try {
            wait();
            System.out.println("Task1 awake");
        } catch (InterruptedException e) {
            System.out.println("wait interrupted");
        }
    }
}

class Task2 implements Runnable {
    private Task1 task1;

    Task2(Task1 task1) {
        this.task1 = task1;
    }

    public Task1 getTask1() {
        return task1;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            synchronized (task1) {
                System.out.println("B run() task1.notifyAll()");
                task1.notifyAll();
            }
        } catch (InterruptedException e) {
            System.out.println("Task2 sleep interrupted");
        }
    }
}
