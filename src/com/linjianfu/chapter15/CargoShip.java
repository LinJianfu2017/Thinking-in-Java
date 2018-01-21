package com.linjianfu.chapter15;


import net.mindview.util.Generator;
import util.generator.Generators;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;

class Item {
    private final int id;
    private String description;
    private String destination;
    private double price;
    private Formatter f = new Formatter(System.err);

    public Item(int idNumber, String what, String whereTo, double price) {
        id = idNumber;
        description = what;
        destination = whereTo;
        this.price = price;
        f.format("%-5d%15s%5s%5.2f%5s%10s\n", id, description,
                "¥", price, "to", destination);
    }

    public void priceChange(double change) {
        price += change;
    }

    @Override
    public String toString() {
        return id + ", " + description
                + ", ¥" + price + ",to:" + destination;
    }

    public static Generator<Item> generator =
            new Generator<Item>() {
                private Random rand = new Random();

                @Override
                public Item next() {
                    return new Item(rand.nextInt(500), "So delicious..."
                            , "Beijing", Math.round(rand.nextDouble() * 100.0));
                }
            };
}

class Shelf extends ArrayList<Item> {
    public Shelf(int nItems) {
        Generators.fill(this, Item.generator, nItems);
    }
}

class StorageArea extends ArrayList<Shelf> {
    public StorageArea(int nShelves, int nItems) {
        while (nShelves-- > 0)
            add(new Shelf(nItems));
    }
}

class Deck extends ArrayList<StorageArea> {
    public Deck(int nStorageAreas, int nShelves, int nItems) {
        while (nStorageAreas-- > 0)
            add(new StorageArea(nShelves, nItems));
    }
}

class Office {
}

public class CargoShip extends ArrayList<Deck> {
    private Office office;

    public CargoShip(int nDeck, int nStorageAreas, int nShelves, int nItems) {
        while (nDeck-- > 0)
            add(new Deck(nStorageAreas, nShelves, nItems));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Deck deck : this)
            for (StorageArea storageArea : deck)
                for (Shelf shelf : storageArea)
                    for (Item item : shelf)
                        result.append(item + "\n");
        return result.toString();
    }
}