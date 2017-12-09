package com.linjianfu.chapter10;

import java.util.Random;

public class Ten17 {
    private static void f(ThrowFactory throwFactory) {
        Throw th = throwFactory.getThrow();
        th.what();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            f(ThrowDice.throwFactory);
            f(ThrowCoin.throwFactory);
        }
    }
}

interface Throw {
    void what();
}

interface ThrowFactory {
    Throw getThrow();
}

class ThrowDice implements Throw {
    private Random random = new Random(47);

    private ThrowDice() {
    }

    @Override
    public void what() {

        System.out.println((random.nextInt(6) + 1));
    }

    static ThrowFactory throwFactory = new ThrowFactory() {
        @Override
        public Throw getThrow() {
            return new ThrowDice();
        }
    };

}

class ThrowCoin implements Throw {
    private Random random = new Random(47);

    private ThrowCoin() {
    }

    @Override
    public void what() {
        switch (random.nextInt(3)) {
            case 0:
                System.out.println("Heads");
                return;
            case 1:
                System.out.println("OnEdge");
                return;
            case 2:
                System.out.println("Tails");
                return;
        }
    }

    static ThrowFactory throwFactory = new ThrowFactory() {
        @Override
        public Throw getThrow() {
            return new ThrowCoin();
        }
    };

}
