package com.linjianfu.chapter4;

//Exercise 1,7.
public class Four1 {
    static int i = 0;

    private static boolean condition() {
        System.out.println(++i);
        return (i < 100);
    }

    public static void main(String[] args) {

        for (; condition(); )
//            if (i >= 99) break
            ;
        i = 0;
        while (condition())
//            if (i >= 99) return
            ;
        i = 0;
        do
//            if (i >= 99) continue       //瞎搞，卵用
            ; while (condition());


    }
}
