package com.linjianfu.chapter9;

abstract class N4dad {
}

class N4son extends N4dad {
    protected void m1() {
        System.out.println("N4son.m1()");
    }
}

abstract class N4dad2 {
    protected abstract void m1();
}

class N4son2 extends N4dad2 {
    protected void m1() {
        System.out.println("N4son2.m1()");
    }
}

public class Nine4 {
    private static void m2(N4dad n4dad) {
        ((N4son) n4dad).m1();
    }

    private static void m3(N4dad2 n4dad2) {
        n4dad2.m1();
    }

    public static void main(String[] args) {
        N4son s1 = new N4son();
        Nine4.m2(s1);
        N4son2 s2 = new N4son2();
        Nine4.m3(s2);
    }

}
