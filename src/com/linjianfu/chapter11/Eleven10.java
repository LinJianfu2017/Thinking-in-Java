package com.linjianfu.chapter11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Eleven10 {
    private Random random = new Random(47);

    public Rodent nextRodent() {
        switch (random.nextInt(8999)%3) {
            default:
            case 0:
                return new Mouse();
            case 2:
                return new Hamster();
            case 1:
                return new Gerbil();
        }
    }

    protected static class Rodent {
        protected String name = "Rodent";

        void eat() {
            System.out.println(this + ".eat()");
        }

        void run() {
            System.out.println(this + ".run()");
        }

        void sleep() {
            System.out.println(this + ".sleep()");
        }

        @Override
        public String toString() {
            return name+"，  ";
        }
    }

    protected static class Mouse extends Rodent {
        Mouse() {
            super.name = "1 Mouse";
        }
    }

    protected static class Gerbil extends Rodent {
        Gerbil() {
            super.name = "2 Gerbil";
        }
    }

    protected static class Hamster extends Rodent {
        Hamster() {
            super.name = "3 Hamster";
        }
    }


    public static void main(String[] args) {
        Eleven10 e = new Eleven10();
        List<Rodent> rodentArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            rodentArrayList.add(e.nextRodent());
        Iterator<Rodent> iterator = rodentArrayList.iterator();
        while (iterator.hasNext()) {
            Rodent r = iterator.next();
            System.out.println(r + ":");
            r.eat();
            r.run();
            r.sleep();
        }
        iterator.remove();
        System.out.println(rodentArrayList);
        rodentArrayList.clear();
        System.out.println(rodentArrayList);
    }
}
