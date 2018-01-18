package com.linjianfu.chapter14;

public class Fourteen3 {
    @Override
    public String toString() {
//        return this + "?";//StackOverflowError递归调用导致堆栈溢出错误
        return super.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Fourteen3());
    }
}
