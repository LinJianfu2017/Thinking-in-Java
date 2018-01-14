package com.linjianfu.chapter16;

import net.mindview.util.CountingGenerator;

public class Sixteen13 {
    public static String fillString(int n) {
        if (n % 2 == 0) {
            CountingGenerator.String s = new CountingGenerator.String(n);
            return s.next();
        }
        CountingGenerator.Character c = new CountingGenerator.Character();
        char[] chars = new char[n];
        for (int i = 0; i < n; i++)
            chars[i] = c.next();
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(fillString(6));
        System.out.println(fillString(11));
    }
}
