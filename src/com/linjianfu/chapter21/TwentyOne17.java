package com.linjianfu.chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RadCount {
    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized int increment() {
        return count++;
    }
}

class Sensor implements Runnable {
    private static RadCount radCount = new RadCount();
    private static List<Sensor> sensors = new ArrayList<>();
    private final int id;
    private int number = 0;
    private static volatile boolean cancel = false;

    public Sensor(int id) {
        this.id = id;
        sensors.add(this);
    }

    public static void cancel() {
        cancel = true;
    }

    @Override
    public void run() {
        while (!cancel) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + radCount.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(25);
            } catch (InterruptedException e) {
                System.out.println(this + " interrupted");
            }
        }
        System.out.println("Stopping " + this);
    }

    private synchronized int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Sensor " + id + ": " + getNumber();
    }

    public static int getTotalCount() {
        return radCount.getCount();
    }

    public static int sumSensors() {
        int sum = 0;
        for (Sensor s : sensors) {
            sum += s.getNumber();
        }
        return sum;
    }
}

public class TwentyOne17 {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Sensor(i));
        }
        TimeUnit.SECONDS.sleep(2);
        Sensor.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(100, TimeUnit.MICROSECONDS)) {
            System.out.println("Some tasks were not terminated");
        }
        System.out.println("Total: " + Sensor.getTotalCount());
        System.out.println("Sum of Sensors: " + Sensor.sumSensors());
    }
}
