package com.linjianfu.chapter8;

import java.util.Random;

//Exercise 9,12,14.
class E9 {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    E9() {
        System.out.println("Creating" + this);
    }

    protected void addref14() {
        refcount++;
    }

    protected void dispose14() {
        if (--refcount == 0)
            System.out.println("Disposing" + this);
    }

    protected void finalize() {
        if (refcount > 0)
            System.out.println("Error: " + refcount + this + " objects on use.");
    }

    @Override
    public String toString() {
        return " E9() No." + id;
    }
}

class Rodent {
    protected String name = " Rodent";

//    Rodent() {
//        System.out.println("Creating" + this);
//    }

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
//    private E9 e9 = new E9();

    {
        super.name = " Mouse";
    }


}

class Gerbil extends Rodent {
//    private E9 e9 = new E9();

    {
        super.name = " Gerbil";
    }

}

class Hamster extends Rodent {
    //    private E9 e9 = new E9();
    private static long counter = 0;
    private final long id = counter++;

    Hamster(E9 e9) {
        super();
        System.out.println("Creating" + this);
        e9.addref14();
    }

    {
        super.name = " Hamster ";
    }

    protected void dispose(E9 e9) {
        System.out.println("Disposing" + this);
        e9.dispose14();
    }

    @Override
    public String toString() {
        return name + id;
    }

}

public class Eight9 {
    private Random rand = new Random(47);
    static E9 e14 = new E9();

    private Rodent next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Mouse();
            case 1:
                return new Gerbil();
            case 2:
                return new Hamster(e14);
        }
    }

    private static Rodent[] r = new Rodent[3];

    public static void main(String[] args) {
        Eight9 e = new Eight9();
        for (int i = 0; i < r.length; i++)
            r[i] = e.next();
        for (Rodent o : r)
            System.out.println(o);
        for (int i = 0; i < r.length; i++) {
            if (r[i].name == " Hamster ")
                ((Hamster) r[i]).dispose(e14);
        }
        e14.finalize();
        Hamster h = new Hamster(e14);
        e14.finalize();
        E9 e142=new E9();
        Hamster h2=new Hamster(e142);
        Hamster h3=new Hamster(e142);
        e142.finalize();
        h2.dispose(e142);
        h3.dispose(e142);
        e142.finalize();

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

