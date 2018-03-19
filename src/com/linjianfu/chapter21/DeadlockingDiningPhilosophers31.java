package com.linjianfu.chapter21;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

/**
 * 把筷子放笼里，依然死锁（避免不了循环等待的那一幕）......何解？
 */


class Philosopher31 implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private LinkedBlockingQueue<Chopstick> bin;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    public Philosopher31(Chopstick left, Chopstick right,
                         LinkedBlockingQueue<Chopstick> bin, int ident, int ponder) {
        this.left = left;
        this.right = right;
        this.bin = bin;
        id = ident;
        ponderFactor = ponder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                print(this + " thinking");
                pause();
                print(this + " taking first, right chopstick");
                right = bin.take();
                print(this + " taking second, left chopstick");
                left = bin.take();
                print(this + " eating");
                pause();
                print(this + " returning chopsticks");
                bin.put(right);
                bin.put(left);
            }
        } catch (InterruptedException e) {
            print(this + " " + "exiting via interrupt");
        }
    }

    public String toString() {
        return "Philosopher " + id;
    }
}


public class DeadlockingDiningPhilosophers31 {
    public static void main(String[] args) throws Exception {
        int ponder = 0;
        int size = 5;
        ExecutorService exec = Executors.newCachedThreadPool();
        LinkedBlockingQueue<Chopstick> bin = new LinkedBlockingQueue<>();
        Chopstick[] sticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = new Chopstick();
            bin.put(sticks[i]);
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher31(sticks[i], sticks[(i + 1) % size], bin, i, ponder));
        }
        if (args.length == 3 && args[2].equals("timeout")) {
            TimeUnit.SECONDS.sleep(5);
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}