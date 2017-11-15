package com.linjianfu.chapter5;

import com.linjianfu.chapter6.Six1;

enum Banknote {
    YIJIAO, LIANGJIAO, WUJIAO, YIYUAN, LIANGYUAN, WUYUAN
}

public class Five21 {
    public static void main(String[] args) {
        for (Banknote s : Banknote.values())
            System.out.println(s + ", ordinal " + s.ordinal());
        for (Banknote2 s : Banknote2.values())
            System.out.println(s + ", ordinal " + s.ordinal());
        Six1 six1 = new Six1();

    }

    public static void f() {
        System.out.println("Five21");
    }
}

enum Banknote2 {
    SHIYUAN, ERSHI, WUSHI, YYIBAI, WUBAI, YIQIAN
}