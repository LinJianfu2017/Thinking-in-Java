    package com.linjianfu.chapter6;

class FourWays {
    int a;
    public int b = 1;
    protected int c = 2;
    private int d = 3;

    FourWays() {
        System.out.println("FourWays() constructor");
    }

    void showa() {
        System.out.println(a);
    }

    public void showb() {
        System.out.println(b);
    }

    protected void showc() {
        System.out.println(c);
    }

    private void showd() {
        System.out.println(d);
    }

}

public class Six5 {
    public static void main(String[] args) {
        FourWays fw = new FourWays();
        fw.showa();
        fw.showb();
        fw.showc();
        fw.a = 10;
        fw.b = 20;
        fw.c = 30;
        fw.showa();
        fw.showb();
        fw.showc();
        /**private成员访问权限只为源类所有*/
//        fw.showd();
//        fw.d;
    }
}
