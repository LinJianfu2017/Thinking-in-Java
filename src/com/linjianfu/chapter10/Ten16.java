package com.linjianfu.chapter10;

public class Ten16 {
    private static void f(CycleFactory cycleFactory) {
        Cycle cycle = cycleFactory.getCycle();
        cycle.balance();
    }

    public static void main(String[] args) {
        f(Unicycle.cycleFactory);
        f(Bicycle.cycleFactory);
        f(Tricycle.cycleFactory);
    }
}

interface Cycle {
    void balance();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    private Unicycle() {
    }

    @Override
    public void balance() {
        System.out.println("Hard");
    }

    static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle {
    private Bicycle() {
    }

    @Override
    public void balance() {
        System.out.println("Common");
    }

    static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}


class Tricycle implements Cycle {
    private Tricycle() {
    }

    @Override
    public void balance() {
        System.out.println("Easy");
    }

    static CycleFactory cycleFactory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}