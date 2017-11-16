package com.linjianfu.chapter6;

import com.linjianfu.chapter6.Six3.Debug.Debug;

class Six4 extends Debug {
    public static void main(String[] args) {

    }

    void six4a() {
        six4test1();
//        six4test2();
        /**注释部分：源类该方法虽为protected权限，但是此处调用方并非被调用方的子类，有包权限。
         * 说明protected方法只能包内类或包外子类可访问，但也并非public。
         */
    }
}
/**
 * 关于继承：经测试得，《对于被继承类，同样受包权限影响》
 *              即：包内继承，public和非public（缺省修饰类）类都可以，即所有类都可以包内继承；
 *                 对于包外继承，父类必须为public类。
 *            此外，还可多重继承。即，可创建子子类。
 * */
class Six4Test extends Six4 {
    void six4b() {
        six4a();
//        six4test1();//原因同上"six4test2()"。
    }
}
