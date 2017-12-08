package com.linjianfu.chapter10;

//Exercise 2,4,5.
class Str {
    private String s;

    Str(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}

class Sequence {
    private Object[] items;
    private int next = 0;


    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    protected class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i++ < items.length) ;
        }

        public Sequence outerReference() {
            return Sequence.this;
        }
    }

    protected void f() {
        System.out.println("Sequence.this");
    }

    public Selector selector() {
        return new SequenceSelector();
    }

}

public class Ten2 {
    private static Sequence sequence = new Sequence(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++)
            sequence.add(new Str(Integer.toString(i)));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        Str s1 = new Str("Selector");
        Str s2 = new Str("Sequence");
        Sequence sequence2 = new Sequence(2);
        sequence2.add(s1);
        sequence2.add(s2);
        Selector selector2 = sequence2.selector();
        while (!selector2.end()) {
            System.out.println(selector2.current() + " ");
            selector2.next();
        }
        Sequence.SequenceSelector ten5 = sequence.new SequenceSelector();
        ((Sequence.SequenceSelector) selector).outerReference().f();
        ten5.outerReference().f();

    }
}
