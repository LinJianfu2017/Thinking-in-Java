package com.linjianfu.chapter15;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunctiion<R, T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunctiion<T, T> {
    T result();
}

//interface Unarypredicate<T> {
//    boolean test(T x);
//}

public class Fifteen42 {
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext())
                result = combiner.combine(result, it.next());
            return result;
        }
        return null;
    }

    public static <T> Collector<T> forEach(Iterable<T> seq,
                                           Collector<T> collector) {
        for (T t : seq)
            collector.function(t);
        return collector;
    }

//    public static <R, T> List<R> transform(Iterable<T> seq,
//                                           UnaryFunctiion<R, T> func) {
//        List<R> result = new ArrayList<>();
//        for (T t : seq)
//            result.add(func.function(t));
//        return result;
//    }

    //    public static <T> List<T> filte(Iterable<T> seq,
//                                    Unarypredicate<T> pred) {
//        List<T> result = new ArrayList<>();
//        for (T t : seq)
//            if (pred.test(t))
//                result.add(t);
//        return result;
//    }
    private static class MealMaker implements Combiner<Food> {
        @Override
        public Food combine(Food x, Food y) {
            return new Food(x.get() + " " + y.get());
        }
    }

    private static class DrinkMaker implements Combiner<Drink> {
        @Override
        public Drink combine(Drink x, Drink y) {
            return new Drink(x.get() + " " + y.get());
        }
    }

    private static class CookedMeal implements Collector<Food> {
        private Food food = new Food("");

        @Override
        public Food function(Food x) {
            food = new Food(food.get() + " " + x.get());
            return food;
        }

        @Override
        public Food result() {
            return new Food("cooked " + food.get());
        }
    }

    public static void main(String[] args) {
        List<Food> foodList = Arrays.asList(
                new Food("braised chicken "),
                new Food("bread"), new Food("dried meat floss"));
        Food meal = reduce(foodList, new MealMaker());
        System.out.println(meal);
        List<Drink> drinkList = Arrays.asList(new Drink("water"),
                new Drink("lemon"), new Drink("orange juice"));
        Drink drink = reduce(drinkList, new DrinkMaker());
        System.out.println(drink);
        System.out.println(forEach(foodList, new CookedMeal()).result());
    }
}

class Food {
    private String foodName = "";

    public Food() {
        foodName = "";
    }

    public Food(String foodName) {
        this.foodName = foodName;
    }

    public void set(String foodName) {
        this.foodName = foodName;
    }

    public String get() {
        return foodName;
    }

    public void eat() {
        foodName = "";
    }

    @Override
    public String toString() {
        return "Food: " + foodName;
    }
}

class Drink {
    private String drinkName = "";

    public Drink() {
        drinkName = "";
    }

    public Drink(String drinkName) {
        this.drinkName = drinkName;
    }

    public void set(String drinkName) {
        this.drinkName = drinkName;
    }

    public String get() {
        return drinkName;
    }

    public void eat() {
        drinkName = "";
    }

    @Override
    public String toString() {
        return "Drink: " + drinkName;
    }
}