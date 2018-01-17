package com.linjianfu.chapter13;

import java.util.Scanner;

public class Thirteen20 {
    private int i;
    private long l;
    private float f;
    private double d;
    private String s;
    private Scanner scanner;

    Thirteen20(String inputForScanner) {
        scanner = new Scanner(inputForScanner);
        i = scanner.nextInt();
        l = scanner.nextLong();
        f = scanner.nextFloat();
        d = scanner.nextDouble();
        s = scanner.nextLine();
    }

    @Override
    public String toString() {
        return " i = " + i + "\n l = " + l + "\n f = " + f + "\n d = " + d + "\n s = " + s;
    }

    public static void main(String[] args) {
        System.out.println(new Thirteen20("1 2 3 4 ss"));
    }
}
