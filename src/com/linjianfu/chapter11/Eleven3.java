package com.linjianfu.chapter11;

import java.util.ArrayList;

public class Eleven3 {
    private interface Selector {
        boolean end();

        Object current();

        void next();
    }

    class Sequence {
        private ArrayList<Object> items = new ArrayList<>();//items:项目、事项。

        public void add(Object x) {
            items.add(x);
        }

        private class SequenceSelector implements Selector {
            private int i = 0;

            @Override
            public boolean end() {
                return i == items.size();
            }

            @Override
            public Object current() {
                return items.get(i);
            }

            @Override
            public void next() {
                i++;
            }
        }

        public Selector selector() {
            return new SequenceSelector();
        }
    }

    public static void main(String[] args) {
        Eleven3.Sequence sequence = new Eleven3().new Sequence();
        for (int i = 0; i < 10; i++)
            sequence.add(i);
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        sequence.add(13);
        sequence.add(13);
        sequence.add("miss you");
        sequence.add(520);
        sequence.add(false);
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

