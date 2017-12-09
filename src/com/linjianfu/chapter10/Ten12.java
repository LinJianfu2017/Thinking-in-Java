package com.linjianfu.chapter10;

interface Inner12 {
    void ifs();
}

public class Ten12 {
    private int i = 0;

    private void fs() {
        System.out.println("AAAAAAAAA");
    }

    Inner12 inner() {
        return new Inner12() {
            @Override
            public void ifs() {
                i += 6;
                fs();
            }
        };
    }

    protected void iprint() {
        System.out.println(i);
    }

    public static void main(String[] args) {
        Ten12 ten12 = new Ten12();
        ten12.iprint();
        ten12.inner().ifs();
        ten12.iprint();

    }
}
