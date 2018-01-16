package com.linjianfu.chapter13;

import java.util.ArrayList;
import java.util.List;

//无意识的递归
public class Thirteen2 {
    @Override
    public String toString() {
        /**
         * 这里发生了自动类型转换（由Thirteen类型转换成了String类型）：
         * 由于一个String对象后面跟着一个“+”，而再后面的对象不是String，于是，编译器试着将
         * “this”转换成一个String-->通过调用this上的toString()方法。因而就发生了递归调用。
         * */
//        return "Thirteen2 address: " + this + "\n";
        /**
         * 修正：打印对象的内存地址，应该调用Object.toString()，“这才是负责此任务的方法”。
         * */
        return "Thirteen2 address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List<Thirteen2> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(new Thirteen2());
        System.out.println(list);
    }
}
