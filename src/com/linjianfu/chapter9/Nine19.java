package com.linjianfu.chapter9;

import java.util.Random;

interface Throw {
    void throwWhat();
}

interface ThrowFactory {
    Throw getThrow();
}

class ThrowDice implements Throw {
    private Random rand = new Random(47);

    public void throwWhat() {
        System.out.println("Throw dice: " + (rand.nextInt(6) + 1));
    }
}

class ThrowDiceFactory implements ThrowFactory {
    public Throw getThrow() {
        return new ThrowDice();
    }
}

class ThrowCoin implements Throw {
    private Random rand = new Random(47);

    public void throwWhat() {
        System.out.print("Throw coin: ");
        switch (rand.nextInt(2)) {
            default:
                System.out.println("OnEdge");
            case 0:
                System.out.println("Heads");
                return;
            case 1:
                System.out.println("Tails");
                return;
        }
    }
}

class ThrowCoinFactory implements ThrowFactory {
    public ThrowCoin getThrow() {
        return new ThrowCoin();
    }
}

public class Nine19 {
    public static void nine19(ThrowFactory throwFactory) {
        Throw t = throwFactory.getThrow();
        t.throwWhat();
    }

    public static void main(String[] args) {
        nine19(new ThrowDiceFactory());
        nine19(new ThrowCoinFactory());
    }
}
