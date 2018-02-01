package com.linjianfu.chapter17;

import java.util.PriorityQueue;
import java.util.Random;

public class Seventeen11 implements Comparable<Seventeen11> {
    private int i;

    public Seventeen11(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return Integer.toString(i) + " ";
    }

    @Override
    public int compareTo(Seventeen11 s11) {
        return Integer.compare(s11.i, this.i);
    }

    public static void main(String[] args) {
        PriorityQueue<Seventeen11> priorityQueue =
                new PriorityQueue<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            priorityQueue.add(new Seventeen11(rand.nextInt(1000)));
        }
        int size = priorityQueue.size();
        while (size-- > 0)
            System.out.println(priorityQueue.poll());
    }
}
