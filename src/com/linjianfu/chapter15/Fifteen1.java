package com.linjianfu.chapter15;

import util.pets.Cat;
import util.pets.Dog;
import util.pets.Pet;

public class Fifteen1<T> {
    private T a;

    public Fifteen1(T a) {
        this.a = a;
    }

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        Fifteen1<Pet> petFifteen1 = new Fifteen1<>(new Pet());
        System.out.println(petFifteen1.get());
        petFifteen1.set(new Cat());
        System.out.println(petFifteen1.get());
        petFifteen1.set(new Dog());
        System.out.println(petFifteen1.get());

    }
}
