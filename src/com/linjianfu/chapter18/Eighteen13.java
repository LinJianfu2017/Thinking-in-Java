package com.linjianfu.chapter18;

import java.io.*;

//Exercise 13,14.
public class Eighteen13 {
    static String file = "Eighteen13.out";
    static String file2 = "Eighteen14.out";

    public static void main(String[] args) throws IOException {
        LineNumberReader lnr = new LineNumberReader(
                new FileReader("src\\com\\linjianfu\\chapter18\\Eighteen13.java"));
        //Unbuffered writer:
        PrintWriter out
                = new PrintWriter(file);
//                = new PrintWriter(new FileWriter(file));//渣渣，比上面更慢
        String s;
        long start = System.nanoTime();
        while ((s = lnr.readLine()) != null)
            out.println(lnr.getLineNumber() + ": " + s);
        long duration = System.nanoTime() - start;
        out.close();
        System.out.println("Unbuffered write: " + duration + " nanoseconds");
        //Buffered writer:
        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
        start = System.nanoTime();
        while ((s = lnr.readLine()) != null)
            out2.println(lnr.getLineNumber() + ": " + s);
        duration = System.nanoTime() - start;
        out2.close();
        System.out.println("Buffered write: " + duration + " nanoseconds");

//        System.out.println(BufferedInputFile.read(file));//Ex13

    }
}
