package com.linjianfu.chapter15;

import util.generator.Generators;
import util.generator.CharactersGenerator;
import util.StoryCharacters.StoryCharacter;
import util.coffee.Coffee;
import util.generator.CoffeeGenerator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Fifteen13 {
    public static void main(String[] args) {
        List<Coffee> coffees =
                Generators.fill(new ArrayList<>(), new CoffeeGenerator(), 10);
        for (Coffee c : coffees)
            System.out.print(c + " ");
        Set<StoryCharacter> characters =
                Generators.fill(new LinkedHashSet<>(), new CharactersGenerator(), 10);
        for (StoryCharacter sc : characters)
            System.out.println(sc);
    }
}
