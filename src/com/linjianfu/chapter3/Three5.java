package com.linjianfu.chapter3;

public class Three5 {
    String name, says;

    void dogshit(Three5 dog) {
        if (dog.name == "spot") {
            dog.says = "Ruff！";
            System.out.println("The spot is barking Ruff!");
        } else if (dog.name.equals("scruff")) {
            dog.says = "Wurf！";
            System.out.println("The scruff is barking Wurf!");
        } else
            System.out.println("Input error,no such dogshit!");
    }

    public static void main(String[] args) {
        Three5 spot = new Three5(), scruff = new Three5();
        spot.name = "spot";
        spot.dogshit(spot);
        scruff.name = "scruff";
        scruff.dogshit(scruff);
        spot.name = "...";
        spot.dogshit(spot);

    }
}
