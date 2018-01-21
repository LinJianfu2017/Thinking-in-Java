package com.linjianfu.chapter15;

import util.coffee.Coffee;
import util.generator.CoffeeGenerator;

public class Fifteen5<T> {
    private class Node {
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }

    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end())
            top = top.next;
        return result;
    }

    public boolean end() {
        return top.end();
    }

    public static void main(String[] args) {
        Fifteen5<Coffee> coffees = new Fifteen5<>();
        for (Coffee coffee : new CoffeeGenerator(20)) {
            coffees.push(coffee);
        }
        int i = 0;
        while (!coffees.end()) {
            if (i++ % 5 == 4) System.out.println();
            System.out.print(coffees.pop() + ", ");
        }

    }


}
