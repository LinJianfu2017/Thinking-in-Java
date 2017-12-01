package com.linjianfu.chapter7;

public class Seven11 {
    private Cleanser c = new Cleanser();

    public void append(String a) {
        c.append(a);
    }

    public void dilute() {
        c.dilute();
    }

    public void apply() {
        c.apply();
    }

    public void scrub() {
        append(" Seven11.scrub()");
        c.scrub();
    }

    public void foam() {
        append(" foam()");
    }

    @Override
    public String toString() {
        return c.toString();
    }

    /**
     * 通过代理的方式可实现选择性“继承”的目的，代理是介于组合和继承之间的一种状态。
     */
    public static void main(String[] args) {
        Seven11 s11 = new Seven11();
        s11.dilute();
        s11.apply();
        s11.scrub();
        s11.foam();
        System.out.println(s11);
        System.out.println("base class Cleanser（）：");
        Cleanser.main(args);
    }

}
