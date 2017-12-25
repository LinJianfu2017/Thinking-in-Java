package com.linjianfu.chapter11;

import java.util.PriorityQueue;

class None {

}

/**
 * F:\JAVA\jdk1.8.0_144\bin\java...
 * Exception in thread "main" java.lang.ClassCastException: com.linjianfu.chapter11.None cannot be cast
 * to java.lang.Comparable
 * * *at java.util.PriorityQueue.siftUpComparable(PriorityQueue.java:652)
 * * *at java.util.PriorityQueue.siftUp(PriorityQueue.java:647)
 * * *at java.util.PriorityQueue.offer(PriorityQueue.java:344)
 * * *at com.linjianfu.chapter11.Eleven29.main(Eleven29.java:13)
 * <p>
 * Process finished with exit code 1
 */

public class Eleven29 {
    public static void main(String[] args) {
        PriorityQueue<None> nonesPQ = new PriorityQueue<>();
        for (int i = 0; i < 10; i++)
            nonesPQ.offer(new None());
        while (nonesPQ.peek() != null)
            nonesPQ.poll();
    }

}
