package com.linjianfu.chapter12;

class Eone extends Exception {
}

class Etwo extends Eone {
}

class Ethree extends Etwo {
}

class A {
    public void f() throws Eone {
        throw new Eone();
    }
}

class B extends A {
    public void f() throws Etwo {
        throw new Etwo();
    }
}

class C extends B {
    public void f() throws Ethree {
        throw new Ethree();
    }
}

public class Twelve25 {
    public static void main(String[] args) {
        A a = new C();
        try {
            a.f();
        }
        catch (Ethree e) {
            System.out.println("caught 3");
        }
        catch (Etwo e) {
            System.out.println("caught 2");
        }
        catch (Eone e) {
            System.out.println("caught 1");
        }
    }
}
