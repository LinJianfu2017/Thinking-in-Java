package util.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<>();
    private static String[] typeNames = {
            "util.pets.Mutt", "util.pets.Pug", "util.pets.EgyptianMau",
            "util.pets.Manx", "util.pets.Cymric", "util.pets.Rat",
            "util.pets.Mouse", "util.pets.Hamster", "util.pets.Gerbil"
    };

    private static void loader() {
        try {
            for (String name : typeNames)
                types.add((Class<? extends Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public List<Class<? extends Pet>> types() {
        return types;
    }

    ;
}
