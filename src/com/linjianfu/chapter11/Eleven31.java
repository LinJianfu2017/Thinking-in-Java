
package com.linjianfu.chapter11;

import java.util.Iterator;

class RandomGerbilGenerator31 implements Iterable<Gerbil> {
    private Gerbil[] gerbils;

    public Gerbil make() {
        return new Gerbil();
    }

    RandomGerbilGenerator31(int n) {
        gerbils = new Gerbil[n];
        for (int i = 0; i < n; i++)
            gerbils[i] = make();
    }

    @Override
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

    public static void main(String[] args) {
        RandomGerbilGenerator31 r = new RandomGerbilGenerator31(10);
        for (Gerbil g : r)
            System.out.println(g);
    }
}

public class Eleven31 {
    public static void main(String[] args) {
        RandomGerbilGenerator31.main(args);
    }

}
