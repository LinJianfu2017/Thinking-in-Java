package com.linjianfu.chapter15;

import net.mindview.util.Generator;
import util.Addable;
import util.SimpleQueue;
import util.StoryCharacters.StoryCharacter;
import util.StoryCharacters.YueFei;
import util.factory.Part;
import util.generator.CharactersGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Fifteen41 {
    public static <T> void fill(Addable<T> addable,
                                Class<? extends T> c, int size) {
        try {
            for (int i = 0; i < size; i++)
                addable.add(c.newInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void fill(Addable<T> addable,
                                Generator<T> generator, int size) {
        for (int i = 0; i < size; i++)
            addable.add(generator.next());
    }

    public static void main(String[] args) {
        List<Part> partList = new ArrayList<>();
        fill(new AddableCollectionAdapter<>(partList),
                Part.class, 2);
        fill(Adapter.collectionAdapter(partList), Part.class, 3);
        for (Part part : partList)
            System.out.println(part);
        AddableSimpleQueue<StoryCharacter> addableSimpleQueue =
                new AddableSimpleQueue<>();
        fill(addableSimpleQueue, new CharactersGenerator(), 3);
        fill(addableSimpleQueue, YueFei.class, 2);
        for (StoryCharacter sc : addableSimpleQueue)
            System.out.println(sc);
    }
}


class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> collection;

    AddableCollectionAdapter(Collection<T> c) {
        collection = c;
    }

    @Override
    public void add(T t) {
        collection.add(t);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T> extends SimpleQueue<T> implements Addable<T> {
    @Override
    public void add(T t) {
        super.add(t);
    }
}
