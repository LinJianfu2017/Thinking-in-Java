package com.linjianfu.chapter9;
//Exercise 14,15.
interface A {
    void aone();

    void atwo();
}

interface B {
    void bone();

    void btwo();
}

interface C {
    void cone();

    void ctwo();
}

interface ABC extends A, B, C {
    void abc();
    void ctwo();
}

abstract class MakeWho {
    public void abc() {
    }
    protected abstract void who();
}

class MakeABC extends MakeWho
        implements ABC {
    @Override
    public void aone() {

    }

    @Override
    public void atwo() {

    }

    @Override
    public void bone() {

    }

    @Override
    public void btwo() {

    }

    @Override
    public void cone() {

    }

    @Override
    public void ctwo() {

    }

    @Override
    protected void who() {

    }
}

public class Nine14 {
    private static MakeABC makeABC = new MakeABC();

    private static void setA(A a) {
        a.aone();
    }

    private static void setB(B b) {
        b.bone();
    }

    private static void setC(C c) {
        c.cone();
    }

    private static void setMakeABC(ABC abc) {
        abc.abc();
    }

    public static void main(String[] args) {
        setA(makeABC);
        setB(makeABC);
        setC(makeABC);
        setMakeABC(makeABC);
    }
}
