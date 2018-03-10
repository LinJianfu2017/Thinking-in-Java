package com.linjianfu.chapter21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwentyOne24 {

    public static void main(String[] args) {
        new Market();
    }
}

class Item {
    private final int itemNum;

    public Item(int itemNum) {
        this.itemNum = itemNum;
    }

    @Override
    public String toString() {
        return "Item " + itemNum;
    }
}

class Producer implements Runnable {
    private int count = 0;
    Market market;

    Producer(Market market) {
        this.market = market;
    }

    protected int getCount() {
        return count;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            while (count < 100) {
                synchronized (market.consumer) {
                    Item item = new Item(++count);
                    if (market.items.offer(item)) {
                        System.out.println("Produced " + item);
                        market.consumer.notify();
                    }
                }
                synchronized (this) {
                    while (!(market.items.size() < 1)) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            System.out.println("Producer-run()-wait()");
                        }
                    }
                }
            }
            System.out.println("Produced " + count + " items" +
                    "\nStopping production");
            market.exec.shutdownNow();
        }
    }
}

class Consumer implements Runnable {
    int consumed = 0;
    Market market;
    List<Item> items = new ArrayList<>();

    Consumer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            synchronized (this) {
                while (!(items.size() < market.producer.getCount())) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Consumer-run()-wait() interrupted");
                    }
                }
                if (items.add(market.items.poll())) {
                    ++consumed;
                    System.out.println("Consuming Item " + consumed);
                    synchronized (market.producer) {
                        market.producer.notify();
                    }
                }
            }
        }
        System.out.println("Consumed " + consumed + " items");
    }
}

class Market {
    ExecutorService exec = Executors.newCachedThreadPool();
    Queue<Item> items = new LinkedList<>();
    Producer producer = new Producer(this);
    Consumer consumer = new Consumer(this);

    public Market() {
        exec.execute(producer);
        exec.execute(consumer);
    }
}