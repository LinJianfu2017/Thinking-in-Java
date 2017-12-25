package com.linjianfu.chapter11;

import java.util.*;

class GerbilSequence implements Iterable {
    private static Gerbil[] getGerbils(int n) {
        Gerbil[] gerbils = new Gerbil[n];

        for (int i = 0; i < n; i++)
            gerbils[i] = new Gerbil();
        return gerbils;
    }

    protected Gerbil[] gerbils = getGerbils(10);

    public Iterator<Gerbil> iterator() {
        return new Iterator<Gerbil>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < gerbils.length;
            }

            @Override
            public Gerbil next() {
                return gerbils[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class Eleven32 extends GerbilSequence {
    public Iterable<Gerbil> reversed() {
        return new Iterable<Gerbil>() {
            public Iterator<Gerbil> iterator() {
                return new Iterator<Gerbil>() {
                    private int current = gerbils.length - 1;

                    @Override
                    public boolean hasNext() {
                        return current > -1;
                    }

                    @Override
                    public Gerbil next() {
                        return gerbils[current--];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public Iterable<Gerbil> randomized() {
        return new Iterable<Gerbil>() {
            @Override
            public Iterator<Gerbil> iterator() {
                List<Gerbil> shuffledGerbil =
                        new ArrayList<>(Arrays.asList(gerbils));
                Collections.shuffle(shuffledGerbil, new Random());
                return shuffledGerbil.iterator();
            }
        };
    }

    public static void main(String[] args) {
        Eleven32 eleven32 = new Eleven32();
//        for (Gerbil g : eleven32)//为啥这样不行，这样不是默认调用iterator()方法吗？？？  书里P244就是这样。
        for (Gerbil g : eleven32.gerbils)
            System.out.print(g + ",  ");
        System.out.println("\n****************");
        for (Gerbil g : eleven32.reversed())
            System.out.print(g + ",  ");
        System.out.println("\n****************");
        for (Gerbil g : eleven32.randomized())
            System.out.print(g + ",  ");

    }
}
