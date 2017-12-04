package com.linjianfu.chapter8;

import static com.linjianfu.chapter8.Cycle2.travel;

class Cycle2 {
    private String name = "Cycle";
    int wheels = 0;

    static void travel(Cycle2 c) {
        System.out.println(c + ".ride()");
    }

    int wheels() {
        return wheels;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Unicycle2 extends Cycle2 {
    private String name = "Unicycle";

    {
        super.wheels = 1;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Bicycle2 extends Cycle2 {
    private String name = "Bicycle";

    {
        super.wheels = 2;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

class Tricycle2 extends Cycle2 {
    private String name = "Tricycle";

    {
        super.wheels = 3;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Eight5 {
    static void ride(Cycle2 cycle) {
        travel(cycle);
        System.out.println("Wheels:" + cycle.wheels());
    }

    public static void main(String[] args) {
        Unicycle2 u = new Unicycle2();
        Bicycle2 b = new Bicycle2();
        Tricycle2 t = new Tricycle2();
        ride(u);
        ride(b);
        ride(t);
    }

}
