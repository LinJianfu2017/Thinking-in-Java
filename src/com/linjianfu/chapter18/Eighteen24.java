package com.linjianfu.chapter18;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

public class Eighteen24 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        DoubleBuffer db = bb.asDoubleBuffer();
        System.out.println(db.mark());

        db.put(new double[]{1, 3, 4, 7, 11, 18, 29});
        System.out.println(db.mark());

        System.out.println(db.get(3));
        System.out.println(db.mark());

        db.put(3, 7777);
        System.out.println(db.mark());

        db.flip();
        System.out.println(db.mark());

        while (db.hasRemaining())
            System.out.println(db.get());
        System.out.println(db.mark());

    }
}
