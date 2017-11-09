package com.linjianfu.chapter3;

class Dog {
    String name, says;

    void setName(String n) {
        name = n;
    }

    void setSays(String s) {
        says = s;
    }

    void showName() {
        System.out.println(name);
    }

    void bark() {
        System.out.println(says);
    }
}

class Three6 {
    public static void main(String[] args) {
        Dog spot = new Dog(), scruff = new Dog(), dogshit = new Dog();
        spot.setName("spot");
        spot.setSays("Ruff！");
        scruff.setName("scruff");
        scruff.setSays("Wurf!");
        spot.showName();
        spot.bark();
        scruff.showName();
        scruff.bark();
        dogshit.setName("shitdog");
        dogshit.setSays("shit！");
        dogshit.showName();
        dogshit.bark();
        System.out.println("Comparison:");
        System.out.println("spot==dogshit:" + (spot == dogshit));
        System.out.println("spot.eqals(dogshit):" + spot.equals(dogshit));
        System.out.println("dogshit.eqals(spot):" + dogshit.equals(spot));
        System.out.println("Now spot=dogshit,and compare again:");
        spot = dogshit;
        System.out.println("spot==dogshit:" + (spot == dogshit));
        System.out.println("spot.eqals(dogshit):" + spot.equals(dogshit));
        System.out.println("dogshit.eqals(spot):" + dogshit.equals(spot));
        System.out.println("spot:");
        spot.showName();
        spot.bark();
        System.out.println("dogshit:");
        dogshit.showName();
        dogshit.bark();
    }
}
