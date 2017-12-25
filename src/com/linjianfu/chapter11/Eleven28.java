package com.linjianfu.chapter11;

import java.util.PriorityQueue;
import java.util.Random;

public class Eleven28 {
    public static void main(String[] args) {
        Random random = new Random();
        PriorityQueue<Double> doublePQ = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            doublePQ.offer(random.nextDouble() * i);
        }
        System.out.println(doublePQ);
        while (doublePQ.peek() != null)
            System.out.print(doublePQ.poll() + ", ");
        System.out.println("\n" + doublePQ);
    }

    static void main(int n) {
        Random random = new Random();
        PriorityQueue<Integer> integerPQ = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            integerPQ.offer(random.nextInt(100) * i);
        }
        System.out.println(integerPQ);
        while (integerPQ.peek() != null)
            System.out.print(integerPQ.poll() + ", ");
        System.out.println("\n" + integerPQ);

    }

}