package com.linjianfu.chapter10;

import com.linjianfu.chapter10.T6one.Ten6interface;
import com.linjianfu.chapter10.T6two.Ten6oo;


public class Ten6 extends Ten6oo {
    Ten6() {
//        super();
        System.out.println("Ten6 extends Ten6oo:");
    }

    Ten6interface getOOinner() {
        return new OOinner();

    }

    Ten6interface ff() {
        OOinner t = new OOinner();
        return t;
    }

    public static void main(String[] args) {
        Ten6 ten6 = new Ten6();
        ten6.f();
        Ten6.OOinner oOinner = ten6.new OOinner();
        System.out.println(oOinner);
        ten6.getOOinner().face1();
        System.out.println(ten6.ff());


    }

}
