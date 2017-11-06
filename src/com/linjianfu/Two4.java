package com.linjianfu;

public class Two4 {
    public static void main(String args[]) {
        System.out.println("主类");
    }
    static {
        System.out.println("静态块优先于主类执行？");
    }
    static {
        System.out.println("静态块");
//        System.exit(0);
    }
    static {
        System.out.println("出不来？");
    }
}
