package com.linjianfu.chapter21;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 本题先演示了BlockingQueue之前的Java版本：任务间使用管道进行输入/输出,
 * 接着修改为使用BlockingQueue
 */
class NewSender implements Runnable {
    private Random rand = new Random(47);
    private LinkedBlockingQueue<Character> queue;

    NewSender(LinkedBlockingQueue blockingQueue) {
        queue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    queue.put(c);
                }
            }
        } catch (InterruptedException e) {
            //
        }
    }
}

class NewReceiver implements Runnable {
    private LinkedBlockingQueue<Character> queue;

    NewReceiver(LinkedBlockingQueue blockingQueue) {
        queue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Read: " + queue.take());
            }
        } catch (InterruptedException e) {
            //
        }
    }
}

public class TwentyOne30 {
    public static void main(String[] args) {
        PipedIO.main(args);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("main() interrupted");
        }
        System.out.println("-------------------------------------------------");
        LinkedBlockingQueue<Character> queue = new LinkedBlockingQueue<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new NewSender(queue));
        exec.execute(new NewReceiver(queue));
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("main() interrupted");
        }
        exec.shutdownNow();
    }
}

class PipedIO {
    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            System.out.println("PipedIO sleep Interrupted");
        }
        exec.shutdownNow();
    }
}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (IOException e) {
            System.out.println("Sender write exception");
        } catch (InterruptedException e) {
            System.out.println("Sender interrupted");
        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) {

        try {
            in = new PipedReader(sender.getPipedWriter());
        } catch (IOException e) {
            System.out.println("Receiver initializing exception");
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Read: " + (char) in.read() + ", ");
            }
        } catch (IOException e) {
            System.out.println("Receiver read exception");
        }
    }
}
