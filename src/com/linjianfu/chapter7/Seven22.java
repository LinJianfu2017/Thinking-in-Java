package com.linjianfu.chapter7;

/**
 * 不论类是否定义为final，定义成员变量的规则不受此约束。However，由于final类禁止继承，so
 * final类中所有的方法都隐式指定为final的，无法被覆盖。你可以给他们添加final修饰词，但不会增添任何意义。
 */
final class S22 {
    S22() {
        System.out.println("S22 constructor");
    }
}

/**
 * Cannot inherit(继承) from final 'com.linjianfu.chapter7.S22'.
 */
//class S221 extends S22{}
public class Seven22 {
    public static void main(String[] args) {
        S22 s22 = new S22();
    }
}
