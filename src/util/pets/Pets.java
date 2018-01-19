package util.pets;

import util.factory.PetFactory;

import java.util.ArrayList;
import java.util.List;

public class Pets {
    public static final PetCreator creator =
            new LiteralPetCreator();

    //old :
//    public static Pet randomPet() {
//        return creator.randomPet();
//    }
    //new :
    public static Pet randomPet() {
        return PetFactory.createRandomPet();
    }

    public static List<Class<? extends Pet>> types() {
        return creator.types();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
