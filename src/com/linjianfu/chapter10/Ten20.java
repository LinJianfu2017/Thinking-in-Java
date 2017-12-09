package com.linjianfu.chapter10;
//Exercise 20,21.
public class Ten20 {
    public static void main(String[] args) {
//        A20.B20 b20=new A20.B20();//error use
        A20.B20 b20 = A20.B20.f();
    }
}

interface A20 {
    class B20 implements A20 {
        @Override
        public void a21() {
            System.out.println("A20.a20()");
        }

        private B20() {
            System.out.println("Inner class in interface is default 'public' and 'static' ");
        }

        static protected B20 f() {
            return new B20();
        }

        public static void main(String[] args) {
            new B20().f().a21();
        }
    }
    void a21();
}