package com.linjianfu.chapter9;

import java.util.Random;

abstract class Rodent {
    private String name = "Rodent";

    protected abstract void eat();

    protected abstract void run();

    protected abstract void sleep();

    public abstract String toString();
}

class Mouse extends Rodent {
    private String name = "Mouse";

    protected void eat() {
        System.out.println(this + ".eat() ");
    }

    protected void run() {
        System.out.println(this + ".run() ");
    }

    protected void sleep() {
        System.out.println(this + ".sleep() ");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Gerbil extends Rodent {
    private String name = "Gerbil";

    protected void eat() {
        System.out.println(this + ".eat() ");
    }

    protected void run() {
        System.out.println(this + ".run() ");
    }

    protected void sleep() {
        System.out.println(this + ".sleep() ");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Hamster extends Rodent {
    private String name = "Hamster";

    protected void eat() {
        System.out.println(this + ".eat() ");
    }

    protected void run() {
        System.out.println(this + ".run() ");
    }

    protected void sleep() {
        System.out.println(this + ".sleep() ");
    }

    @Override
    public String toString() {
        return name;
    }
}

class RodentRandomGenerator {
    private Random rand = new Random(47);

    public Rodent next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Mouse();
            case 1:
                return new Gerbil();
            case 2:
                return new Hamster();

        }
    }
}

public class Nine1 {
    private static RodentRandomGenerator gen = new RodentRandomGenerator();

    public static void main(String[] args) {
        //Error:cannot instantiate(实例化) abstract class:
//        Rodent x = new Rodent();
        //But OK to creat array to be downcast to derived(导出/派生) objects(对象):
        Rodent[] rodents = new Rodent[10];
        for (Rodent r : rodents) {
            r = gen.next();//Upcasting.
            System.out.println(r + ":");
            r.eat();
            r.run();
            r.sleep();

        }

    }
}
