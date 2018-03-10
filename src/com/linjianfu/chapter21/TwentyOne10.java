package com.linjianfu.chapter21;

import java.util.concurrent.*;

public class TwentyOne10 implements Callable<Integer> {
    private Integer n = 0;
    ExecutorService exec = Executors.newSingleThreadExecutor();

    private int fibonacci(int x) {
        if (x < 2) {
            return 1;
        }
        return fibonacci(x - 1) + fibonacci(x - 2);
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += fibonacci(i);
        }
        return result;
    }

    public Future<Integer> runTask(Integer n) {
        this.n = n;
        return exec.submit(this);
    }

    public static void main(String[] args) {
        TwentyOne10 twentyOne10 = new TwentyOne10();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(twentyOne10.runTask(i).get());
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (ExecutionException e) {
            System.out.println(e);
        } finally {
            twentyOne10.exec.shutdown();
        }
    }
}

