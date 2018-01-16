package com.linjianfu.chapter12;

//Exercise8,9.
public class Twelve8 {

    private static void f(int i) throws MyException, LoggingException1, LoggingException2 {
        if (i < 0) throw new MyException();
        if (i == 0) throw new LoggingException1();
        if (i > 0) throw new LoggingException2();
    }

    public static void main(String[] args) {
        try {
            f(-1);
            f(0);
            f(1);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}
