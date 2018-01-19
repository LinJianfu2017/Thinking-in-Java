package com.linjianfu.chapter14;

import net.mindview.util.TypeCounter;
import util.factory.PetFactory;
import util.pets.Pet;

//Exercise 15.
public class Fourteen15 {
    public static void main(String[] args) {
        int size = 20;
        TypeCounter petCount = new TypeCounter(Pet.class);
        while (size-- > 0) {
            petCount.count(PetFactory.createRandomPet());
        }
        System.out.println(petCount);
    }
}

//16一样的