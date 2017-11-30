package com.linjianfu.chapter7;

import java.util.Random;
import java.util.Scanner;

//exercise 1 and some independent verification
public class Seven1 {
    private Ob ob;

    @Override
    public String toString() {
//        System.out.println("Before delayed initialization，ob="+ob);//needless，unnecessary!
        if (ob == null) ob = new Ob();
        return "After delayed initialization，ob=" + ob;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner("aa  bb cc ddee");
        /**hasNext()和next()方法可以探测输入流中是否还有一个string和获取下一个string，
         * string间以空格为分割标志
         * */
        while (s.hasNext()) {
            System.out.println(s.next());
        }
        System.out.println(Sev11.THREE);
        System.out.println(Sev11.ONE);
        System.out.println(Sev11.TWO);
        System.out.println(Sev11.THREE);

        Seven1 ss = new Seven1();
        System.out.println(ss);


    }
}

class Ob {
    private String s;

    Ob() {
        System.out.println("Ob()");
        s = "Obobobobob";
    }

    @Override
    public String toString() {
        return s;
    }
}

/**
 * 测试interface成员是否为static final的
 */
interface Sev11 {
    Random R = new Random(47);
    int ONE = R.nextInt(100);
    long TWO = R.nextInt(100);
    float THREE = R.nextInt(100);
}