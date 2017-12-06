package com.linjianfu.chapter9.nine6;

import com.linjianfu.chapter9.nine5.Nine5;
//Exercise 5,6.
public class Nine6 implements Nine5 {
    //Error:cannot assign weaker access to public methods:
//    void n51(){}
//    protected void n52(){}
//    private void n53(){}
    public void n51() {
        System.out.println("n51");
    }

    public void n52() {
        System.out.println("n52");
    }

    public void n53() {
        System.out.println("n53");
    }

    public static void main(String[] args) {
        Nine6 nine6 = new Nine6();
        nine6.n51();
        nine6.n52();
        nine6.n53();
    }
}
