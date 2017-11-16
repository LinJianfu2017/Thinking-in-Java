package com.linjianfu.chapter6;

import com.linjianfu.chapter6.Six3.Debug.Debug;

class Six4 extends Debug {
    public static void main(String[] args) {
        new Six4().six4a();
        new InnerClass2();
        new ExtendsInnerClass();
        new ExtendsTest();
    }

    void six4a() {
        six4test1();
//        six4test2();
        /**注释部分：源类该方法虽为protected权限，但是此处调用方并非被调用方的子类，有包权限。
         * 说明protected方法只能包内类或包外子类可访问，但也并非public。
         */
    }

    protected static class InnerClass2 {
        InnerClass2() {
            System.out.println("protected static class InnerClass2");
        }
    }

    private static class ExtendsTest extends ExtendsInnerClass {
        ExtendsTest() {
            System.out.println("《内部类也可以继承自作为多重子类的外部类》");
        }
        class AA{
            AA(){
                System.out.println("私有内部类的非private内部类也可以被继承？");
                System.out.println("可以啊,说明内部类的修饰前缀对外意义不受外部类影响");
            }
        }
    }
}
/**-----------------受影响了----------------**/
//class BBextendsAA extends Six4.ExtendsTest.AA{
//
//}
/**
 * 关于继承：经测试得，《对于被继承类，同样受包权限影响》
 * 即：包内继承，所有public、包权限的外部类和非private的内部类都能实现；
 *    对于包外继承，父类必须为public类。
 * 此外，还可多重继承。即，可创建子子类。
 *
 * 突然发现内部类可以用protected、private以及static修饰，而外部类则不行，
 * 同时这种内部类也可以被继承，那么内部类跟方法很像哦？！
 */
class Six4Test extends Six4 {
    void six4b() {
        six4a();
        new InnerClass2();
//        six4test1();//原因同上"six4test2()"。
    }
}

class ExtendsInnerClass extends Six4.InnerClass2 {
    ExtendsInnerClass() {
        System.out.println("Extends inner class:");
        new Six4.InnerClass2();
    }
}