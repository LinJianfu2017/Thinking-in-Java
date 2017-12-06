package com.linjianfu.chapter9;

abstract class N3dad {
    N3dad() {
        System.out.println("N3dad() before print():");
        print();
        System.out.println("N3dad() after print()");
    }

    protected abstract void print();
}

class N3son extends N3dad {
    private int i = 6;
    private static int j = 666;

    @Override
    protected void print() {
        System.out.println("N3son private int i=" + i + ", j=" + j);
    }
}

public class Nine3 {
    public static void main(String[] args) {
        N3son b2 = new N3son();
        b2.print();
    }
}



















