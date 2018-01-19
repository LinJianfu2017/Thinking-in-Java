package com.linjianfu.chapter14;

import net.mindview.util.TypeCounter;
import util.factory.Part;

public class Fourteen24 {
    public static void main(String[] args) {
        int i = 1000;
        TypeCounter nullTest = new TypeCounter(Part.class);
        while (i-- > 0)
            nullTest.count(Part.createRandom());
        System.out.println(nullTest);
    }
}
