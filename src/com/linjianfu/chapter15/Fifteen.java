package com.linjianfu.chapter15;

import util.factory.Part;

import java.util.ArrayList;
import java.util.Random;

public class Fifteen {
    public static class RandomList<T> {
        private ArrayList<T> storage = new ArrayList<>();
        private Random rand = new Random(47);

        public void add(T t) {
            storage.add(t);
        }

        public T select() {
            return storage.get(rand.nextInt(storage.size()));
        }

        public static void main(String[] args) {
            RandomList<Part> parts = new RandomList<>();
            int size = 20;
            while (size-- > 0)
                parts.add(Part.createRandom());
            while (size++ <20)
                System.out.println(parts.select());
        }
    }
}
