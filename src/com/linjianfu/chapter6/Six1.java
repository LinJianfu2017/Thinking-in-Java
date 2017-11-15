package com.linjianfu.chapter6;

/**
 * 《一个编译单元最多只能有一个public的类》《且该类名称与编译单元文件名一致》《该类必须有main（）方法》
 * 如果不供包外调用，则也可以没有public修饰。
 */
class TestSix1 {
    TestSix1() {
        System.out.println("TestSix1");
    }

    public static void main(String[] args) {
        TestSix1 testSix1 = new TestSix1();
    }
}

//练习1，Six1.java结合Five21.java完成。
public class Six1 {
    public Six1() {
        System.out.println("Six1");
    }

    public static void main(String[] args) {
        Six1 six1 = new Six1();

    }
}
