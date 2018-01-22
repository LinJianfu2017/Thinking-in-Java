package com.linjianfu.chapter15;

import util.coffee.Coffee;
import util.factory.PetFactory;
import util.pets.Cat;
import util.pets.Pet;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Fifteen40 {
    public static void main(String[] args) throws Exception {
        int size = 10;
        List<Pet> pets = new ArrayList<>();
        while (size-- > 0)
            pets.add(PetFactory.createRandomPet());
        Apply.apply(pets, Pet.class.getMethod("speak"));
        List<Cat> cats = new ArrayList<>();
        while (size++ < 10)
            cats.add(new Cat());
        Apply.apply(cats, Pet.class.getMethod("id"));
        Apply.apply(new FilledList<>(Coffee.class, 10),
                Coffee.class.getMethod("toString"));
    }
}

class Apply {
    static <T, S extends Iterable<? extends T>> void
    apply(S seq, Method method, Object... args) {
        try {
            for (T t : seq)
                method.invoke(t, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape {
    public void ratate() {
        System.out.println(this + " rotate");
    }

    public void resize(int newSize) {
        System.out.println(this + " resize " + newSize);
    }
}

class Square extends Shape {
}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++)
                add(type.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
