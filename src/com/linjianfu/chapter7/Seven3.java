package com.linjianfu.chapter7;

import static com.linjianfu.chapter7.C.cs;
import static com.linjianfu.chapter7.Seven3.s;

//Exercise 3,4,5,6.
class A {
    A() {
        System.out.println("A()" + s);
    }
}

class B extends A {
    B() {
        System.out.println("B()");
    }
}

class C extends B {
    C() {
        System.out.println("C()");
    }

    static String cs = "This is C.cs";
}

class D extends C {
    D(int i) {
        System.out.println("D()");
    }

    public static D makeD() {
        return new D(1);
    }

    public static void main(String[] args) {
        D d1 = new D(1);
        D d2 = makeD();
    }
}

class E extends A {
    E(int i) {
//        super();//父类构造器无参时可省。

        s = "s in E()";
        System.out.println("E()" + s + cs);
    }
}

public class Seven3 extends D {
    Seven3(int i) {
        /**基类构造器带参数时，必须显式调用基类构造器，且该动作必须是导出类构造器要做的第一件事*/
        super(i);
        System.out.println("Seven3()");
//        super(i);
    }

    static String s;
    E e = new E(1);

    {
        s = "static member initialized";
        System.out.println(s);
    }

    public static void main(String[] args) {
        Seven3 x = new Seven3(1);
//        D.main(args);
    }
}
