package com.linjianfu.chapter11;

import java.util.LinkedList;
import java.util.Queue;

class Command {
    String s;

    Command(String s) {
        this.s = s;
    }

    public void operation() {

//        Random random = new Random();
//        switch (random.nextInt(5)) {
//            default:
//            case 0:
//                s = "zero";
//                break;
//            case 1:
//                s = "one";
//                break;
//            case 2:
//                s = "two";
//                break;
//            case 3:
//                s = "three";
//                break;
//            case 4:
//                s = "four";
//                break;
//            case 5:
//                s = "five";
//                break;
//        }
        System.out.println(s);
    }
}

class CommandQ {
    Queue<Command> commandQueue = new LinkedList<>();

    public Queue<Command> makeQueue() {
        for (int i = 0; i < 6; i++)
            commandQueue.offer(new Command(i + " "));
        return commandQueue;
    }
}

public class Eleven27 {
    public static void eatQCommand(Queue<Command> commandQueue) {
        while (commandQueue.peek() != null) {
            commandQueue.poll().operation();//关键点
        }
    }

    public static void main(String[] args) {
        eatQCommand(new CommandQ().makeQueue());
    }
}
