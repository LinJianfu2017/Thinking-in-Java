package com.linjianfu.chapter10;

//Exercise 1,3,8.
public class Ten1 {
    private String s;
    Ten1(){
        s="2017.12.8";
    }
    private class Inner {
        private int i = 5;
        //Non-static inner classes cannot have static declarations:
        //域的生命周期不能超过它的作用域。
//        private static char c = 'a';

        private void iprint() {
            System.out.println(i);
        }

        @Override
        public String toString() {
            return s;
        }
    }

    static class Inner2 {
        private static int i2 = 666;
        //static inner classes can have non-static declarations:
        private int i3;

        private static void i2print() {
            System.out.println(i2);
//            i3=1001;
        }
    }

    protected Inner fx() {
        return new Inner();
    }

    public static void main(String[] args) {
        int j;
        /**
         * The objects of non-static inner class called:
         * */
        Ten1 ten1 = new Ten1();
        Ten1.Inner inner = ten1.new Inner();
        inner.iprint();//Class members only accessed via creating objects.
        j = inner.i;
        System.out.println(j);

        new Ten1().new Inner().iprint();

        Ten1.Inner inner3 = ten1.fx();
        inner3.iprint();
        System.out.println(inner3);
        /**
         * The objects and methods of static inner class called:
         * */
        Ten1.Inner2.i2print();//Accessed via outer&inner class's name.
        Inner2 inner2 = new Inner2();
        inner2.i2print();//Also can be accessed via instance reference.


    }
}
