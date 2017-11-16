package com.linjianfu.chapter6;

/**
 * 《一个编译单元最多只能有一个public的类》《且该类名称与编译单元文件名一致》《该类必须有main（）方法》
 * 如果不供包外调用，则也可以没有public修饰,在这种情况下，可以随意对文件命名，只是不提倡。
 */
class TestSix1 {
    TestSix1() {
        System.out.println("TestSix1");
    }
private static class InnerClass1{
        InnerClass1(){
            System.out.println("private InnerClass1");
        }
}
    public static void main(String[] args) {
        TestSix1 testSix1 = new TestSix1();
        new InnerClass1();
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
