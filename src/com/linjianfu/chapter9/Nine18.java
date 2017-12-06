package com.linjianfu.chapter9;

interface Cycle {
    void balance();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    @Override
    public void balance() {
        System.out.println("Unicycle is hand to balance.");
    }
}

class UnicycleFactory implements CycleFactory {
    public Unicycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {
    public void balance() {
        System.out.println("Bicycle is common to balance.");
    }
}

class BicycleFactory implements CycleFactory {
    public Bicycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {
    public void balance() {
        System.out.println("Tricycle is easy to balance.");
    }
}

class TricycleFactory implements CycleFactory {
    public Tricycle getCycle() {
        return new Tricycle();
    }
}

public class Nine18 {
    public static void nine18(CycleFactory cycleFactory) {
        Cycle cycle = cycleFactory.getCycle();
        cycle.balance();
    }

    public static void main(String[] args) {
        nine18(new UnicycleFactory());
        nine18(new BicycleFactory());
        nine18(new TricycleFactory());
    }
}
