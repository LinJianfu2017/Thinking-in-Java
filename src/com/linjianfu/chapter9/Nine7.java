package com.linjianfu.chapter9;

import java.util.Random;

interface Rodent2 {
    //Compile-time constant:
    String name = "Rodent2";//static & final

    //Cannot have method definitions:
    void eat();//Automatically public

    void run();

    void sleep();

    String toString();
}

class Mouse2 implements Rodent2 {
    private String name = "Mouse2";

    public void eat() {
        System.out.println(this + ".eat()");
    }

    public void run() {
        System.out.println(this + ".run()");
    }

    public void sleep() {
        System.out.println(this + ".sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Rat implements Rodent2 {
    private String name = "Rat";

    public void eat() {
        System.out.println(this + ".eat()");
    }

    public void run() {
        System.out.println(this + ".run()");
    }

    public void sleep() {
        System.out.println(this + ".sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Squirrel implements Rodent2 {
    private String name = "Squirrel";

    public void eat() {
        System.out.println(this + ".eat()");
    }

    public void run() {
        System.out.println(this + ".run()");
    }

    public void sleep() {
        System.out.println(this + ".sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class RandomRodent2Generator {
    private Random rand = new Random(47);

    public Rodent2 next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Mouse2();
            case 1:
                return new Rat();
            case 2:
                return new Squirrel();
        }
    }
}

public class Nine7 {
    private static RandomRodent2Generator gen = new RandomRodent2Generator();

    public static void main(String[] args) {
        //Error:'Rodent2' is abstract; cannot be instantiated:
//        Rodent2 rodent2=new Rodent2();
        Rodent2[] rodent2s = new Rodent2[6];
        for (Rodent2 r : rodent2s) {
            r = gen.next();
            System.out.println(r + ": ");
            r.eat();
            r.run();
            r.sleep();
        }

    }
}
