package util.coffee;

import util.factory.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    private static List<Factory<? extends Coffee>> coffeeFactories =
            new ArrayList<>();
    //unfinished：
//    static {
//
//    }
    private static Random random = new Random(47);

    public static ArrayList<Coffee> createRandomCoffee(int size) {
        ArrayList<Coffee> results = new ArrayList<>();
        while (size-- > 0)
            results.add(coffeeFactories.get(random.nextInt(coffeeFactories.size())).create());
        return results;
    }
}
