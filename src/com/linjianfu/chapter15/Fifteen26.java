package com.linjianfu.chapter15;

import java.util.ArrayList;
import java.util.List;

//Exercise 26,27.
public class Fifteen26 {
    public static void main(String[] args) {
        Number[] numbers = new Integer[2];
        numbers[0] = 0;
        try {
            numbers[1] = 1.0;
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Number n : numbers)
//            System.out.println(n.getClass().getSimpleName());
            try {
                List<? extends Number> numberList = new ArrayList<Integer>();
                //add(capture<? extends Number>)in list cannot be applied to Integer,Double
                //and any types of Number:
//            numberList.add(new Integer(0));
//            numberList.add(new Double(1.0));
                numberList.add(null);
                Number x = numberList.get(0);
                System.out.println(x);//为啥连续打印了两个null。。。
                /**
                 71: invokeinterface #11,  2    // InterfaceMethod java/util/List.get:(I)Ljava/lang/Object;
                 76: checkcast     #12          // class java/lang/Number
                 79: astore        7
                 81: getstatic     #6           // Field java/lang/System.out:Ljava/io/PrintStream;
                 84: aload         7
                 86: invokevirtual #7           // Method java/io/PrintStream.println:(Ljava/lang/Object;)V
                 以上可以看到，确实是打印了两次，先是System.out打印了field，
                 再调用了method:printStream.println又打印了一次。
                 */

//                numberList.add(null);
//                System.out.println(numberList.get(1));//一个坑填两个null？？
//                System.out.println(null);//字符串null加上值null，于是就打了两个出来？那哪个先？
            } catch (Exception e) {
//            System.out.println(e);
            }
    }
}
