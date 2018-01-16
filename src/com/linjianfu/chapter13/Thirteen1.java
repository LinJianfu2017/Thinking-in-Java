package com.linjianfu.chapter13;

//不变的String
//重载 “+” 与StringBuilder
public class Thirteen1 {
    private String s1, s2, s3, s4;
    private int anInt;
    private float aFloat;
    private Mark mark = new Mark();

    @Override
    public String toString() {
        /**
         * 由反编译生成的JVM字节码可知，JVM已用StringBuilder做优化处理。
         * */
        return "s1=" + s1 + " s2=" + s2 + " s3=" + s3 + " s4=" + s4 + " anInt=" + anInt + " afloat=" + aFloat + " mark=" + mark;
    }

    public static void main(String[] args) {
        System.out.println(new Thirteen1());
    }
}
