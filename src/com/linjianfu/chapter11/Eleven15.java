package com.linjianfu.chapter11;

import java.util.LinkedList;

class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();

    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}

public class Eleven15 {
    public static void stackOperationTest(Stack<Character> stack, String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '+')
                stack.push(chars[++i]);
            else if (chars[i] == '-' && !stack.empty())
                System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        String s = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        Stack<Character> stack = new Stack<>();
        stackOperationTest(stack, s);
    }
}
