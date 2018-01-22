package com.linjianfu.chapter15;

interface Payable<T> {
    float getPay();
}

class Employee implements Payable {
    @Override
    public float getPay() {
        return 0;
    }
}

class Hourly extends Employee implements Payable {
    @Override
    public float getPay() {
        return super.getPay();
    }
}

public class Fifteen31 {
    public static void main(String[] args) {
        System.out.println(new Hourly().getPay());
    }
}
