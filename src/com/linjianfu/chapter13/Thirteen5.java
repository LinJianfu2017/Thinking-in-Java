package com.linjianfu.chapter13;

import java.math.BigInteger;
import java.util.Formatter;

//格式化输出之Formatter转换
public class Thirteen5 {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.err);
        Thirteen5 t = new Thirteen5();
        System.out.println("t=new Thirteen5()");
        f.format("%-20s%-20S%-5b%-5B%-10h%-10H%%\n", t, t, t, t, t, t, t);

        char c = 'a';
        System.out.println("char c='a'");
        f.format("%s%S%c%C%b%B%h%H%%\n", c, c, c, c, c, c, c, c, c);

        int i = 116;
        System.out.println("int i=116");
        f.format("%d%c%C%b%B%s%S%x%X%h%H%%\n", i, i, i, i, i, i, i, i, i, i, i, i, i, i, i);

        BigInteger b = new BigInteger("1000000000000");
        System.out.println("b=new BigInteger(\"1000000000000\")");
        f.format("%d%b%B%s%S%x%X%h%H%%\n", b, b, b, b, b, b, b, b, b, b);

        double d = 6.8;
        System.out.println("double d=6.8");
        f.format("%b%B%s%S%f%e%E%h%H%%\n", d, d, d, d, d, d, d, d, d, d, d);

        boolean z = true;
        System.out.println("boolean z=false");
        f.format("%b%B%s%S%h%H%%\n", z, z, z, z, z, z, z);
    }
}
