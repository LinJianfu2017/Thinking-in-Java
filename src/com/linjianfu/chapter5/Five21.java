package com.linjianfu.chapter5;

enum Banknote {
    YIJIAO, LIANGJIAO, WUJIAO, YIYUAN, LIANGYUAN, WUYUAN
}

public class Five21 {
    public static void main(String[] args) {
        for (Banknote s : Banknote.values())
            System.out.println(s + ", ordinal " + s.ordinal());
        for (Banknote2 s : Banknote2.values())
            System.out.println(s + ", ordinal " + s.ordinal());
    }
}

enum Banknote2 {
    SHIYUAN, ERSHI, WUSHI, YYIBAI, WUBAI, YIQIAN
}