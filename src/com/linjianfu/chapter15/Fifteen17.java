package com.linjianfu.chapter15;

import util.Watercolors;

import java.util.EnumSet;
import java.util.Set;

import static util.Sets.*;
import static util.Watercolors.*;

//发现：Object.clone()声明的native关键字：解释为：本地方法，
// 存在于External Dynamic Link Library；Java调用用其他语言
// 实现的方法的方式。显然native与abstract不能共存。
public class Fifteen17 {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, BURNT_UMBER);
        Set<Watercolors> set2 = EnumSet.range(LEMON_YELLOW,
                ORANGE);
        Set<Watercolors> uSet, iSet, dSet, cSet;
        uSet = union(set1, set2);
        System.out.println(uSet);
        iSet = intersection(set1, set2);
        System.out.println(iSet);
        dSet = difference(set1, set2);
        System.out.println(dSet);
        cSet = complement(set1, set2);
        System.out.println(cSet);
    }
}

