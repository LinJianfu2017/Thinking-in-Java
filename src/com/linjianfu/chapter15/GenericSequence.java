package com.linjianfu.chapter15;

import java.util.ArrayList;
import java.util.List;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class GenericSequence<T> {
    private List<T> list = new ArrayList<>();
    private int next = 0;

    public GenericSequence(List<T> list) {
        this.list = list;
    }

    public void add(T t) {
        list.add(t);
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == list.size();
        }

        @Override
        public Object current() {
            return list.get(i);
        }

        @Override
        public void next() {
            if (i < list.size()) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }
}
