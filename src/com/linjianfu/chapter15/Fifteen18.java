package com.linjianfu.chapter15;

import net.mindview.util.Generator;
import util.generator.Generators;

import java.util.*;

public class Fifteen18 {
    public static void eat(BigFish b, LittleFish l) {
        System.out.println(b + " eat " + l);
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        Queue<LittleFish> littleFish = new LinkedList<>();
        Generators.fill(littleFish, LittleFish.generator(), 10);
        List<BigFish> bigFish = new ArrayList<>();
        Generators.fill(bigFish, BigFish.generator, 10);
        for (LittleFish l : littleFish)
            eat(bigFish.get(random.nextInt(bigFish.size())), l);
    }
}

class BigFish {
    private static long counter = 0;
    private final long id = counter++;

    private BigFish() {
    }

    @Override
    public String toString() {
        return "BigFish " + id;
    }

    public static Generator<BigFish> generator =
            new Generator<BigFish>() {
                @Override
                public BigFish next() {
                    return new BigFish();
                }
            };
}

class LittleFish {
    private static long counter = 0;
    private final long id = counter++;

    private LittleFish() {
    }

    @Override
    public String toString() {
        return "LittleFish " + id;
    }

    public static Generator<LittleFish> generator() {
        return new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }
}
