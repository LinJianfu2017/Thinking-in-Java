package com.linjianfu.chapter15;

import util.generator.CharactersGenerator;
import util.StoryCharacters.StoryCharacter;

public class Fifteen8 {
    public static void main(String[] args) {
        CharactersGenerator cg = new CharactersGenerator();
        for (int i = 0; i < 10; i++)
            System.out.println(cg.next());
        for (StoryCharacter sc : new CharactersGenerator(20))
            System.out.println(sc);
    }
}
