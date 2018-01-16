package com.linjianfu.chapter12;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

//Exercise3,7，27.
public class Twelve3 {
    private static Logger logger = Logger.getLogger("Twelve3 exception");

    public static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }

    public static void main(String[] args) {
        int[] ints = new int[3];
        try {
            ints[6] = 7;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace(System.out);
            logException(e);
//            throw new RuntimeException(e);//exercise 27
        }
    }
}
