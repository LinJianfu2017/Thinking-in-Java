package com.linjianfu.chapter21;

/**
 * @author LINJIANFU
 * @date 2018.3.17
 */

public class Fodder {
    private static int counter = 0;
    private final int id = counter++;

    @Override
    public String toString() {
        return "Fodder " + id;
    }
}

