package com.linjianfu.chapter7;
//Exercise 23,24.
class S23_1 {
    S23_1() {
        System.out.println("S23_1()");
    }

    private static int i = 0;
    private static int s1 = printInt("static S23_1.s1 initialiazed");

    public static int printInt(String s) {
        System.out.println(s);
//        return ++i;
        return 0;
    }
}

class S23_2 extends S23_1 {
    S23_2() {
        System.out.println("S23_2()");
    }

    private int s4 = printInt("non-static S23_2.s4 initialized");//说明，除了static成员之外，其他成员及构造器的初始化是按类捆绑，从上到下依次进行的。
    private static int s2 = printInt("static S23_2.s2 initialized");
}

public class Seven23 {
    Seven23() {
        System.out.println("Seven23()");
    }

    private static int s3 = S23_2.printInt("static Seven23.s3 initialized");//Upcasting ,只是利用了通往其父类的接口，并不加载S23_1 ！！！

    public static void main(String[] args) {
        new Seven23();//调用了S23_1的static方法的同时，先加载了(初始化)其static成员(尽管并没用到他们)，另外也说明了调用构造器可能是创建相关对象时才会发生的。
        new S23_2();
    }

}
