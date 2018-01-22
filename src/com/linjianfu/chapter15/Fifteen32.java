package com.linjianfu.chapter15;

import java.util.ArrayList;

class FixedSizeStack<T> {
    private int index = 0;
    private Object[] storage;

    FixedSizeStack(int size) {
        storage = new Object[size];
    }

    void push(T t) {
        storage[index++] = t;
    }

    @SuppressWarnings("unchecked")
    T pop() {
        return (T) storage[--index];
    }

    public int getIndex() {
        return index;
    }
}

public class Fifteen32 {
    private static int size = 6;

    public static void main(String[] args) {
        FixedSizeStack<String> sizeStack =
                new FixedSizeStack<>(size);
        for (String s : "1 23 456 7890 12345 678901".split(" "))
            sizeStack.push(s);
        if (sizeStack.getIndex() < size)
            sizeStack.push("2345678");
        while (size-- > 0)
            System.out.println(sizeStack.pop());
    }
}

//33:
class VariableSizeStack<T> {
    private ArrayList<T> storage = new ArrayList<>();

    void push(T t) {
        storage.add(t);
    }

    T pop() {
        return storage.get(storage.size() - 1);
    }

    int count() {
        return storage.size();
    }
}