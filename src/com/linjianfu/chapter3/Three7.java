package com.linjianfu.chapter3;

import java.util.Random;

public class Three7 {
    public static void main(String[] args) {
        Random rand = new Random();
        int coin = rand.nextInt();
        if (coin % 2 == 0) System.out.println(coin + ", Right side up!");
        else System.out.println(coin + ", The back up!");
    }
}
