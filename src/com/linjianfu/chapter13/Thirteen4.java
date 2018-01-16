package com.linjianfu.chapter13;

import java.util.Formatter;
//格式化输出之格式化说明符
public class Thirteen4 {
    private double total = 0;
    private Formatter f = new Formatter(System.err);
    private static final int w1 = 15;
    private static final int w2 = 5;
    private static final int w3 = 10;
    private String s1 = "%-" + w1 + "s%" + w2 + "s%" + w3 + "s\n";
    private String s2 = "%-" + w1 + "." + w1 + "s%" + w2 + "d%" + w3 + ".2f\n";
    private String s3 = "%-" + w1 + "s%" + w2 + "s%" + w3 + ".2f\n";

    public void printTitle() {
        f.format(s1, "Item", "Qty", "Price");
        f.format(s1, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        f.format(s2, name, qty, price);
        total += price * qty;
    }

    public void printTotal() {
        f.format(s3, "Tax", "", total * 0.06);//tax:税金
        f.format(s1, "", "", "-----");
        f.format(s3, "Total", "", total * 1.06);
    }

    public static void main(String[] args) {
        Thirteen4 thirteen4 = new Thirteen4();
        thirteen4.printTitle();
        thirteen4.print("egg", 1, 9.90);
        thirteen4.print("supper", 1, 15.60);
        thirteen4.print("la,du,zi", 4, 100);
        thirteen4.printTotal();
    }
}
