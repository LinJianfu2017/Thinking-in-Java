package com.linjianfu.chapter10;

class A15 {
    A15(int i) {
        System.out.println(i);
    }
}

public class Ten15 {

    A15 makeA15(int i) {
        return new A15(i) {
        };
    }

    public static void main(String[] args) {
        Ten15 ten15 = new Ten15();
        A15 a15 = ten15.makeA15(15);

    }

}
