package com.linjianfu.chapter10;
//Exercise 18,19.
public class Ten18 {
    Ten18() {
        System.out.println("Ten18()");
    }

    private static class A1 extends Ten18 {
        A1() {
            System.out.println("A1()");
        }

        private static class B1 extends A1 {
            B1() {
                System.out.println("B1()");
            }
        }

        private class B2 extends A1 {
            B2() {
                System.out.println("B2():non-static inner class");
            }
        }
    }

    private static A1 f1() {
        return new A1();
    }

    private static A1.B1 f2() {
        return new A1.B1();
    }

    public static void main(String[] args) {
        A1 a1 = new A1.B1();//Up casting.
        /**Error:'A1' is not an enclosing class.*/
//        a1 = new A1.B2();
        A1.B2 b2 = a1.new B2();
    }
}
