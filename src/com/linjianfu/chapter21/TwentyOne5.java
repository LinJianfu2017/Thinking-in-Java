package com.linjianfu.chapter21;

import java.util.ArrayList;
import java.util.concurrent.*;

public class TwentyOne5 implements Callable<Integer> {
    private int n = 0;

    public TwentyOne5(int n) {
        this.n = n;
    }

    private int fib(int x) {
        if (x < 2) {return 1;}
        return fib(x - 1) + fib(x - 2);
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fib(i);
        }
        return result;
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> fibonacciSums = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            fibonacciSums.add(exec.submit(new TwentyOne5(10)));
        }
        for (Future<Integer> fi : fibonacciSums) {
            try {
                System.out.println(fi.get());

            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
    }
}
