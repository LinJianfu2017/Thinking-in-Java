package com.linjianfu.chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TwentyOne29 {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(),
                peanutQueue = new ToastQueue(),
                jelliedQueue = new ToastQueue();
        SandwitchQueue sandwitchQueue = new SandwitchQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new PeanutButterer(dryQueue, peanutQueue));
        exec.execute(new Jelly(dryQueue, jelliedQueue));
        exec.execute(new SandwitchMaker(peanutQueue, jelliedQueue, sandwitchQueue));
        exec.execute(new SandwitchEater(sandwitchQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}

class PeanutButterer implements Runnable {
    private ToastQueue dryQueue, peanutQueue;

    PeanutButterer(ToastQueue dry, ToastQueue peanut) {
        dryQueue = dry;
        peanutQueue = peanut;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.peanutButter();
                System.out.println(toast);
                peanutQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("PeanutButterer interrupted");
        }
        System.out.println("Peanutbutterer off");
    }
}

class Jelly implements Runnable {
    private ToastQueue dryQueue, jelliedQueue;

    Jelly(ToastQueue dry, ToastQueue jelly) {
        dryQueue = dry;
        jelliedQueue = jelly;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.jelly();
                System.out.println(toast);
                jelliedQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("Jelly interrupted");
        }
        System.out.println("Jelly off");
    }
}

class Sandwitch {
    private Toast top, bottom;
    private final int id;

    Sandwitch(Toast top, Toast bottom, int idn) {
        this.top = top;
        this.bottom = bottom;
        id = idn;
    }

    public Toast getTop() {
        return top;
    }

    public Toast getBottom() {
        return bottom;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SandWitch " + id + "\ntop:" + top + "\nbottom:" + bottom;
    }
}

class SandwitchQueue extends LinkedBlockingQueue<Sandwitch> {
}

class SandwitchMaker implements Runnable {
    private int count = 0;
    private ToastQueue peanutButteredQueue, jelliedQueue;
    private SandwitchQueue sandwitchQueue;

    SandwitchMaker(ToastQueue peanutButtered, ToastQueue jellied, SandwitchQueue sq) {
        peanutButteredQueue = peanutButtered;
        jelliedQueue = jellied;
        sandwitchQueue = sq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Sandwitch sandwitch = new Sandwitch(peanutButteredQueue.take(), jelliedQueue.take(), count++);
                System.out.println(sandwitch);
                sandwitchQueue.put(sandwitch);
            }
        } catch (InterruptedException e) {
            System.out.println("SandwitchMaker interrupted");
        }
        System.out.println("SandwitchMaker off");
    }
}

class SandwitchEater implements Runnable {
    private SandwitchQueue sandwitchQueue;
    private int counter = 0;

    SandwitchEater(SandwitchQueue sq) {
        sandwitchQueue = sq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Sandwitch sandwitch = sandwitchQueue.take();
                if (sandwitch.getId() != counter++ ||
                        sandwitch.getTop().getStatus() != Toast.Status.PEANUTBUTTERED
                        || sandwitch.getBottom().getStatus() != Toast.Status.JELLY) {
                    System.out.println(">>>>>Error " + sandwitch);
                    System.exit(1);
                } else {
                    System.out.println("NumNum! " + sandwitch);
                }

            }
        } catch (InterruptedException e) {
            System.out.println("SandwitchEater interrupted");
        }
        System.out.println("SandwitchEater off");
    }
}