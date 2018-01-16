package com.linjianfu.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public class Twelve6 {
    private static void f() throws LoggingException1 {
        throw new LoggingException1();
    }

    private static void g() throws LoggingException2 {
        throw new LoggingException2();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception e) {

        }
        try {
            g();
        } catch (Exception e) {

        }
    }
}

class LoggingException1 extends Exception {
    private static Logger logger = Logger.getLogger(" ");

    public LoggingException1() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    @Override
    public String getMessage() {
        return "Detail Message: " + super.getMessage();
    }
}

class LoggingException2 extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException2");

    public LoggingException2() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

}