package com.linjianfu.chapter6;

import com.linjianfu.chapter5.Five21;

/**
 * 若同一个编译单元内调用不同包之间的类，存在类名冲突（即类名相同）时，
 * 使用单个类导入的形式来防止冲突，或者用指定全名的方式来创建对应类对象。
 **/
public class Six2 {
    public static void main(String[] args) {
        com.linjianfu.chapter5.Five21 s1 = new com.linjianfu.chapter5.Five21();
        Five21 s2 = new Five21();
        s1.f();
        s2.f();
    }
}
