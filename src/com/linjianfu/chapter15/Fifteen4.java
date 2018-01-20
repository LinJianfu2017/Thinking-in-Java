package com.linjianfu.chapter15;

import util.pets.Pet;
import util.pets.Pets;

import java.util.ArrayList;
import java.util.List;

public class Fifteen4 {
    public static void main(String[] args) {
        List<Pet> list = new ArrayList<>();
        GenericSequence<Pet> petGenericSequence =
                new GenericSequence<>(list);
        int size = 20;
        while (size-- > 0)
            petGenericSequence.add(Pets.randomPet());
        Selector selector = petGenericSequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}
