package com.linjianfu.chapter15;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;
import util.coffee.Coffee;
import util.pets.Pet;

public class Fifteen14 {
    public static void main(String[] args) {
        Generator<Pet> petGenerator = new BasicGenerator<>(Pet.class);
        Generator<Coffee> coffeeGenerator = BasicGenerator.create(Coffee.class);
        for (int i = 0; i < 5; i++) {
            System.out.println(petGenerator.next());
            System.out.println(coffeeGenerator.next());
        }
    }
}
