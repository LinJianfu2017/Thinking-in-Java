package com.linjianfu.chapter12;

//exercise 10,11,13
public class Twelve10 {
    public static void g(int i) throws LoggingException1 {
        System.out.println("LoggingException1 from g()");
        throw new LoggingException1();
    }

    private static void f() {
//        try {
        try {
            g(1);
        } catch (LoggingException1 e) {
            e.printStackTrace(System.out);
//                throw new LoggingException2();
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally block will always be executed.");
        }
    }
//        catch (LoggingException2 loggingException2) {
//            loggingException2.printStackTrace(System.out);
//        }
//    }

    public static void main(String[] args) {
        f();
    }
}
