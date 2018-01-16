package com.linjianfu.chapter12;

//Exercise 14,15.
public class Twelve14 {
    static Integer[] integers = new Integer[1];

    public static void main(String[] args) {
//        f2();
        f1();
    }

    private static void f1() {
        Swith swith = new Swith();
        try {
            swith.on();
            Twelve10.g(integers[0]);
        } catch (LoggingException1 e) {
            System.out.println(e);
        } finally {
            swith.off();
        }

    }

    private static void f2() {
        Swith sw = new Swith();
        try {
            sw.on();
            Twelve10.g(integers[0]);
            sw.off();
        } catch (LoggingException1 e) {
            System.out.println(e);
            sw.off();
        }
    }
}

class Swith {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return state ? "on" : "off";
    }


}