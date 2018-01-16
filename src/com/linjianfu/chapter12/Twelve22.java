package com.linjianfu.chapter12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Exercise 22,23,24.
class MarkCleanup {
    private static long counter = 0;
    private final long id = counter++;

    public void dispose() {
        System.out.println("MarkCleanup " + id + " disposed");
    }

}

public class Twelve22 {
    private BufferedReader br;
    private MarkCleanup m1, m2;

    Twelve22(String fname) throws Exception {
        m1 = new MarkCleanup();
        try {
            br = new BufferedReader(new FileReader(fname));
        } catch (FileNotFoundException e) {
            System.out.println("Not found file " + fname);
            throw e;
        } catch (Exception e) {
            try {
                br.close();
            } catch (IOException io) {
                System.out.println("br.close() failed");
            }
            throw e;
        }
        m2 = new MarkCleanup();
    }

    public String getLine() {
        String s;
        try {
            s = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine() failed");
        }
        return s;
    }


    public static void main(String[] args) {
        try {
            Twelve22 t = new Twelve22("./src/com/linjianfu/chapter12/Twelve21.java");
            try {
                String s;
                while ((s = t.getLine()) != null) {
                    System.out.println(s);
                }
            } catch (Exception e) {
                System.out.println("Exception from inner try block");
            } finally {
                t.m2.dispose();
                t.m1.dispose();
            }
        } catch (Exception e) {
            System.out.println("Twelve22 construction failed");
        }
    }
}
