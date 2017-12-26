package com.linjianfu.chapter12;

public class Twelve1 {
    public static void main(String[] args) {
        outer:
//标签，配合break和continue实现Java 类似"goto"功能的跳转操作。
        for (int j = 0; j < 5; j++) {
            inner:
            for (int i = 3; i < 5; i++) {
                switch (i) {//字符型或者整型。
                    default://可放开头、中间、末尾；当所有case都不符合时，
                        // 默认执行default语句及其后面的case语句直到遇到break或者switch语句结束为止。
                        System.out.println(i);
                    case 0:
                        System.out.println(i);
                        break;//结束该次switch判断；这与break在循环嵌套语句中的作用似乎有所不同：
                    // 在那里：break直接结束并跳出当层循环或所指示的标签所包含的循环；
                    //continue是结束当次循环并回到当层循环或标签所在起始处开始新一轮的循环动作。
                    case 3:
                        System.out.println(i);
                        return;//返回并结束所在方法。
                    case 2:
                        System.out.println(i);
                }
            }
        }
        System.out.println("haha");
    }
}
