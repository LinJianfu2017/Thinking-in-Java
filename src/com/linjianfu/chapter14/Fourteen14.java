package com.linjianfu.chapter14;

import net.mindview.util.TypeCounter;
import util.factory.Part;

public class Fourteen14 {
    public static void main(String[] args) {
        TypeCounter partTypeCounter = new TypeCounter(Part.class);
        int size = 20;
        while (size-- > 0) {
            partTypeCounter.count(Part.create2());
        }
        System.out.println(partTypeCounter);
    }
}
