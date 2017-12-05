package com.linjianfu.chapter8;

import java.util.Random;

//Exercise 9,12,14.
class E9 {
    E9() {
        System.out.println("E9()");
    }
}

class Rodent {
    protected String name = "Rodent";
    private E9 r1 = new E9();

    Rodent() {
        System.out.println("Rodent()");
    }

    protected void eat() {
        System.out.println(name + ".eat()");
    }

    protected void run() {
        System.out.println(name + ".run()");
    }

    protected void sleep() {
        System.out.println(name + ".sleep()");
    }

    @Override
    public String toString() {
        return name;
    }
}

class Mouse extends Rodent {
    private E9 m2 = new E9();

    Mouse() {
        System.out.println("Mouse()");
    }

    {
        super.name = "Mouse";
    }
}

class Gerbil extends Rodent {
    private E9 g3 = new E9();

    Gerbil() {
        System.out.println("Gerbil()");
    }

    {
        super.name = "Gerbil";
    }

}

class Hamster extends Rodent {
    private E9 h4 = new E9();

    Hamster() {
        System.out.println("Hamster()");
    }

    {
        super.name = "Hamster";
    }

}

public class Eight9 {
    private Random rand = new Random(47);

    private Rodent next() {
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

    private static Rodent[] r = new Rodent[10];

    public static void main(String[] args) {
        Eight9 e = new Eight9();
        for (int i = 0; i < r.length; i++)
            r[i] = e.next();
        for (Rodent o : r)
            System.out.println(o);
//        int num = 0;
//        switch (num) {
//            case 0:
//                System.out.println("0000");
//            case 3:
//                System.out.println("0011");break;
//            case 7:
//                System.out.println("0111");
//            default:
//                System.out.println("default");
    }
}

