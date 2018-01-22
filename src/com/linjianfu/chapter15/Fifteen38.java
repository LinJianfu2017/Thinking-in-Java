package com.linjianfu.chapter15;

public class Fifteen38 {
    public static void main(String[] args) {
        Milk milk = new Milk(new BasicCoffee());
        System.out.println(milk.getMilk());
        Foam foam = new Foam(new Decorator(new BasicCoffee()));
        System.out.println(foam.getFoam());

    }
}

class BasicCoffee {
    private static long counter = 0;
    private final long id = counter++;
    private String value;

    void setValue(String val) {
        value = val;
    }

    String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class Decorator extends BasicCoffee {
    private BasicCoffee bc;

    Decorator(BasicCoffee bc) {
        this.bc = bc;
    }

    @Override
    void setValue(String val) {
        bc.setValue(val);
    }

    @Override
    String getValue() {
        return bc.getValue();
    }
}

class Milk extends Decorator {
    private final String milk = "Milk";

    Milk(BasicCoffee bc) {
        super(bc);
    }

    String getMilk() {
        return milk;
    }
}

class Foam extends Decorator {
    private final String foam = "Foam";

    Foam(BasicCoffee bc) {
        super(bc);
    }

    String getFoam() {
        return foam;
    }
}

class Chocolate extends Decorator {
    private final String chocolate = "Chocolate";

    Chocolate(BasicCoffee bc) {
        super(bc);
    }

    String getChocolate() {
        return chocolate;
    }
}

class Caramel extends Decorator {
    private final String caramel = "Caramel";

    Caramel(BasicCoffee bc) {
        super(bc);
    }

    String getCaramel() {
        return caramel;
    }
}

class WhippedCream extends Decorator {
    private final String whippedCream
            = "WhippedCream";

    WhippedCream(BasicCoffee bc) {
        super(bc);
    }

    String getWhippedCream() {
        return whippedCream;
    }
}

