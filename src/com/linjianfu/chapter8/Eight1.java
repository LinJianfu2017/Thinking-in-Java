package com.linjianfu.chapter8;

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
}

class Bicycle extends Cycle {
    Bicycle() {
        System.out.println("Bicycle()");
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
    }

}
