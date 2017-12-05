package com.linjianfu.chapter8;

//Exercise 1,17.
enum Cycleclass {
    UNICYCLE, BICYCLE, TRICYCLE;
}

class Cycle {
    Cycle() {
        System.out.println("Cycle()");
    }

    void rev(Cycleclass cycleclass) {
        System.out.println(cycleclass + ".rev()");
    }
}

class Unicycle extends Cycle {
    Unicycle() {
        System.out.println("Unicycle()");
    }

    void balance() {
        System.out.println("Unicycle is hand to balance.");
    }
}

class Bicycle extends Cycle {
    Bicycle() {
        System.out.println("Bicycle()");
    }

    void balance() {
        System.out.println("Bicycle is easy to balance.");
    }
}

class Tricycle extends Cycle {
    Tricycle() {
        System.out.println("Tricycle()");
    }
}

public class Eight1 {
    static void ride(Cycle cycle, int i) {
        switch (i) {
            case 1:
                cycle.rev(Cycleclass.UNICYCLE);
                break;
            case 2:
                cycle.rev(Cycleclass.BICYCLE);
                break;
            case 3:
                cycle.rev(Cycleclass.TRICYCLE);
                break;
            default:
                System.out.println("Cycle class input error");

        }
    }
//    public static void ride2(Cycle cycle){
//        switch(cycle){
//            case new Unicycle():break;
//        }
//    }

    public static void main(String[] args) {
        Unicycle u = new Unicycle();
        Bicycle b = new Bicycle();
        Tricycle t = new Tricycle();
        ride(u, 1);
        ride(b, 2);
        ride(t, 3);
        Cycle[] c = {u, b, t};
        for (int i = 0; i < c.length; i++) {
            if (c[i] == u)
                ((Unicycle) c[i]).balance();
            if (c[i] == b)
                ((Bicycle) c[i]).balance();
            
        }
    }

}
