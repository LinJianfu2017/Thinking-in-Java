package com.linjianfu.chapter10.T6two;

import com.linjianfu.chapter10.T6one.Ten6interface;

public class Ten6oo {
//    private int i;
    public Ten6oo() {
        System.out.println("Ten6oo:");
    }

    protected void f() {
        System.out.println("不同包中，子类怎么不能访问父类的protected内部类?\n");
    }

    /**
     * 为啥异包子类对象不能访问父类protected内部类？？
     */
//    protected
    public class OOinner implements Ten6interface {
        @Override
        public void face1() {
            System.out.println("OOinner.face1()");
        }


        @Override
        public String toString() {
            return "OOinner: +(i++)";
        }
    }
}
