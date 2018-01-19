package util.factory;

import util.pets.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PetFactory {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    private static List<Factory<? extends Pet>> petFactories =
            new ArrayList<>();

    static {
        petFactories.add(new Pet.Factory());
        petFactories.add(new Cat.Factory());
        petFactories.add(new Dog.Factory());
        petFactories.add(new Rodent.Factory());
        petFactories.add(new EgyptianMau.Factory());
        petFactories.add(new Manx.Factory());
        petFactories.add(new Pug.Factory());
        petFactories.add(new Mutt.Factory());
        petFactories.add(new Rat.Factory());
        petFactories.add(new Mouse.Factory());
        petFactories.add(new Gerbil.Factory());
        petFactories.add(new Hamster.Factory());
        petFactories.add(new Cymric.Factory());
    }

    private static Random random = new Random(47);

    public static Pet createRandomPet() {
        int n = random.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }
}
