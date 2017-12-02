package com.linjianfu.chapter7;

import java.util.Random;
/**
 * final和static的区别：
 * final形不可变但可复制，static可形变但不可复制，二者合一取并集。
 * */
public class Seven18 {
    static  Random rand = new Random(47);//此处final 可省
    int i = rand.nextInt(100);//此处final可省
    final int j = i;
    static final int KK_VALUE = rand.nextInt(100);

    public static void main(String[] args) {
        Seven18 s18 = new Seven18();
//        KK_VALUE = 4;
//        s18.i=3;//cannot assign(赋值) value to final variable(变量) 'KK_VALUE' ,'i' and 'j'.
        System.out.println("i=" + s18.i + ",  final j=" + s18.j + ",  static final KK_VALUE=" + KK_VALUE);
        Seven18 s182 = new Seven18();
        System.out.println("i=" + s182.i + ",  final j=" + s182.j + ",  static final KK_VALUE=" + KK_VALUE);
        Seven18 s183 = new Seven18();
        System.out.println("i=" + s183.i + ",  final j=" + s183.j + ",  static final KK_VALUE=" + KK_VALUE);
        new Seven18();
        new Seven18();
        new Seven18();
        Seven18 s184 = new Seven18();
        System.out.println("i=" + s184.i + ",  final j=" + s184.j + ",  static final KK_VALUE=" + KK_VALUE);
        for (int i = 0; i < 10; i++)//Testing.
            System.out.println(rand.nextInt(100));
    }
}
