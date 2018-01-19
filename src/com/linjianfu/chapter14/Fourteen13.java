package com.linjianfu.chapter14;

import net.mindview.util.TypeCounter;
import util.factory.Part;

import java.util.Arrays;

public class Fourteen13 {
    public static void main(String[] args) {
        int size = 20;
        Part[] parts = new Part[size];
        for (int i = 0; i < size; i++)
            parts[i] = Part.createRandom();
        System.out.println(Arrays.toString(parts));
        TypeCounter partTypeCounter = new TypeCounter(Part.class);
        for (Part part : parts)
            partTypeCounter.count(part);
        System.out.println(partTypeCounter);
    }
}
