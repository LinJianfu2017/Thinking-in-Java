package com.linjianfu.chapter9;

interface FastFood {
    void cheeseburger();//芝士汉堡

    void fries();//炸薯条

    void softDrink();//汽水
}

class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {//奶酪

    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {//莴苣

    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {//便当午餐

    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

class Sandwich extends PortableLunch implements FastFood {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    //    private Lettuce l=new Lettuce();
    private Lunch l = new Lunch();

    Sandwich() {
        System.out.println("Sandwich()");
    }

    public void cheeseburger() {
        System.out.println("cheeseburger()");
    }

    public void fries() {
        System.out.println("fries()");
    }

    public void softDrink() {
        System.out.println("softDrink()");
    }

    public static void main(String[] args) {
        Sandwich s = new Sandwich();
        s.cheeseburger();
        s.fries();
        s.softDrink();
    }
}

public class Nine8 {
    public static void main(String[] args) {
        Sandwich.main(args);
    }
}
