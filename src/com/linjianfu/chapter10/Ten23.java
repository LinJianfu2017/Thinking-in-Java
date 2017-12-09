package com.linjianfu.chapter10;

public class Ten23 {
    public static void main(String[] args) {
        A23 a1 = new A23(), a2 = new A23(), a3 = new A23();
        B23 b = new B23(3);
        b.addU(a1.getU(), 0);
        b.addU(a2.getU(), 1);
        b.addU(a3.getU(), 2);
        b.showUs();
        b.testU();
        b.eraseU(2);
        b.eraseU(0);
        b.showUs();
    }

}

interface U {
    void uf1();

    void uf2();

    String toString();
}

class A23 {
    U getU() {
        return new U() {
            @Override
            public void uf1() {
//                System.out.println("uf1");
            }

            @Override
            public void uf2() {
//                System.out.println("uf2");
            }

            @Override
            public String toString() {
                return "I'm an U";
            }
        };
    }
}

class B23 {
    private U[] us;

    B23(int i) {
        us = new U[i];
    }

    void addU(U x, int i) {
        us[i] = x;
    }

    void eraseU(int i) {
        us[i] = null;
    }

    void testU() {
        for (U u : us) {
            u.uf1();
            u.uf2();
            u.toString();
        }
    }

    void showUs() {
        for (U u : us)
            System.out.println(u);
    }
}