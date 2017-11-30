package com.linjianfu.chapter7;

class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute()");
    }

    public void apply() {
        append("apply()");
    }

    public void scrub() {
        append("scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}


public class Seven2 extends Cleanser {
    public void scrub() {
        append("Seven2.scrub()");
    }

    public void sterilize() {
        append("sterilize()");
    }

    public static void main(String[] args) {
        Seven2 x = new Seven2();
        x.dilute();
        x.apply();
        x.scrub();
        x.sterilize();
        System.out.println(x);
        System.out.println("Testing base class：");
        Cleanser.main(args);


    }

}
