package com.linjianfu.chapter10;

import com.linjianfu.chapter10.T6one.Ten6interface;

//Exercise 9,10,11.
public class Ten9 {
    private Ten6interface ten9(String s) {
        if (s != "沙比") {
            class Inner implements Ten6interface {
                @Override
                public void face1() {
                    System.out.println("作用域内部类：\nTen9.ten9().Inner.face1()");
                }
            }
            return new Inner();

        }
        return null;
    }


    public class Inner implements Ten6interface {
        public void face1() {
            System.out.println("验证private内部类不能向下转型：\nTen9.Inner.face1()");
        }

        public Ten6interface f() {
            return new Inner();
        }
    }

    public static void main(String[] args) {
        Ten9 ten9 = new Ten9();
        String s1 = "", s2 = "沙比";
        ten9.ten9(s1).face1();
        ten9.ten9(s2).face1();
        Inner inner = ten9.new Inner();
        inner.face1();
        Ten6interface inner2 = inner.f();
        /**
         * Error:Incompatible types; cannot downcast.
         * */
//        Inner inner3 = inner.f();

    }
}
