package com.linjianfu.chapter4;

public class Four1 {
    static int i = 1;

    private static boolean condition() {
        System.out.println(i);
        return (i < 100);
    }

    public static void main(String[] args) {

        for (; condition(); ) i++;
        i = 1;
        while (condition()) i++;
        i = 0;
        do i++; while (condition());


    }
}
