package com.linjianfu.chapter10.T6two;

import com.linjianfu.chapter10.T6one.Ten6interface;

public class Ten6oo {
    public Ten6oo() {
        System.out.println("Ten6oo:");
    }

    protected void f() {
        System.out.println("咋了???");
    }

    protected class OOinner implements Ten6interface {
        @Override
        public void face1() {
            System.out.println("OOinner.face1()");
        }

        @Override
        public void face2() {
            System.out.println("OOinner.face2()");
        }
    }
}
