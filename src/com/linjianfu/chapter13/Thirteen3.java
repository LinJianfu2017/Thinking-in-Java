package com.linjianfu.chapter13;

import java.io.PrintStream;
import java.util.Formatter;
//格式化输出之Formatter类
public class Thirteen3 {
    private String name;
    private Formatter f;

    public Thirteen3(String name, Formatter f) {
        this.name = name;
        this.f = f;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at(%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
        PrintStream outAlias = System.err;
        Thirteen3 t1 = new Thirteen3("An", new Formatter(System.err));
        Thirteen3 t2 = new Thirteen3("Bn", new Formatter(outAlias));
        t1.move(0, 0);
        t2.move(2, 2);
    }
}
