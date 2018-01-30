package com.linjianfu.chapter17;

public class Seventeen2 {
    private static int x = 1;

    //"final" or "not final"?
    //'y' is automatic final and hide copy within inner-class?
    public static Seventeen2 f(final int y) {
        return new Seventeen2() {
            int z = x + y;
        };
    }

    public static void main(String[] args) {
        f(2);
    }
}
