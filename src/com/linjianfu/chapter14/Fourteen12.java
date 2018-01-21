package com.linjianfu.chapter14;

import net.mindview.util.TypeCounter;
import util.coffee.Coffee;
import util.generator.CoffeeGenerator;

public class Fourteen12 {
    public static void main(String[] args) {
        TypeCounter coffeTypeCounter = new TypeCounter(Coffee.class);
        for (Coffee coffee : new CoffeeGenerator(20))
            coffeTypeCounter.count(coffee);
        System.out.println(coffeTypeCounter);
    }
}
