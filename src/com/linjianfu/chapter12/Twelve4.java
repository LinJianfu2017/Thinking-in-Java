package com.linjianfu.chapter12;

//Exercise 4,28,29.
class RuntimeEx extends RuntimeException {
}

public class Twelve4 {
    public static void f() throws MyException, RuntimeEx {
        System.out.println("Twelve4.f()");
        throw new MyException("Exception throw from Twelve4");

    }

    public static void f28() throws RuntimeEx {
        System.out.println("Twelve4.f28()");
        throw new RuntimeEx();
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            System.out.println(e);
            e.printStackTrace(System.out);
        }

        f28();//对于“RuntimeException”异常类，编译器允许省略try语句块。
    }
}
