package com.linjianfu.chapter15;

import util.generator.New;
import util.Null;
import util.StoryCharacters.BadGuy;
import util.StoryCharacters.StoryCharacter;
import util.coffee.Coffee;
import util.factory.Part;
import util.pets.Person;
import util.pets.Pet;

import java.util.*;

//Exercise 11,12.
public class Fifteen11 {
    private static void f(Map<Person, List<? extends Pet>> map) {
    }

    private static void f(List<? extends Part> list) {
    }

    private static void f(Queue<Null> queue) {
    }

    private static void f(Set<? extends StoryCharacter> set) {
    }

    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> map = New.map();
        List<? extends Part> parts = New.list();
        LinkedList<? extends StoryCharacter> linkedList = New.lList();
        Set<? extends Coffee> set = New.set();
        Queue<Null> queue = New.queue();

        //12 现在编译器版本已经进化到支持非赋值语句的 "type argument inference"
        f(New.<BadGuy>set());//OK

        //Error,unexpected wildcard:
//        f(New.<?extends StoryCharacter>set());
//        f(New.<?extends Part>list());

        //The following are all redundant:
        f(New.<Part>list());
        f(New.<Null>queue());
        f(New.<Person, List<? extends Pet>>map());//Why not unexpected wildcard here???

        //Error,cannot resolve method ...:??
//        f(New.<Person, List<Pet>>map());
//        f(New.<Person, List<Cat>>map());

    }
}
