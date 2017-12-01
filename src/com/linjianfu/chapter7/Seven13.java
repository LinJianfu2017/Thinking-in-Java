package com.linjianfu.chapter7;

class Sev13 {
    void s13m() {
        System.out.println("Sev13.s13m()");
    }

    void s13m(int i) {
        System.out.println("Sev13.s13m(int)");
    }

    void s13m(Sev13 sev13) {
        System.out.println("Sev13.s13m(Sev13)");
    }

    Sev13 makeSev13() {
        return new Sev13();
    }
}

public class Seven13 extends Sev13 {
    @Override
//覆盖(or重写)
    void s13m() {
        System.out.println("Seven13.s13m(float)");

    }

    Sev13 s13m(float f) {
        System.out.println("Seven13.s13m(float) makeSev13()");
        return makeSev13();
    }

    public static void main(String[] args) {
        Seven13 s13 = new Seven13();
        s13.s13m();
        s13.s13m(0);
        s13.s13m(new Sev13());
        s13.s13m(0f);
    }
}


