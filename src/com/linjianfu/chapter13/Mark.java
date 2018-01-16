package com.linjianfu.chapter13;

public class Mark {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "\"Mark " + id + "\"";
    }
}
