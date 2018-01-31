package com.linjianfu.chapter18;

import java.io.IOException;
import java.nio.ByteBuffer;

import static net.mindview.util.Print.print;

public class Eighteen25 {

    public static long allocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer bb = ByteBuffer.allocate(i);
        return System.nanoTime() - start;
    }

    public static long directAllocationTime(int i) {
        long start = System.nanoTime();
        ByteBuffer bb = ByteBuffer.allocateDirect(i);
        return System.nanoTime() - start;
    }

    public static void main(final String[] args) throws IOException {
        // allocation time related to startup time:
        print("Time to allocate 2048 bytes = "
                + allocationTime(2048) + " nanoseconds");
        print("Time to allocateDirect 2048 bytes = "
                + directAllocationTime(2048) + " nanoseconds");
        print("Time to allocate 1024 bytes = "
                + allocationTime(1024) + " nanoseconds");
        print("Time to allocateDirect 1024 bytes = "
                + directAllocationTime(1024) + " nanoseconds");
        print("Time to allocate 48 bytes = "
                + allocationTime(48) + " nanoseconds");
        print("Time to allocateDirect 48 bytes = "
                + directAllocationTime(48) + " nanoseconds");
        print("Time to allocate 1 byte = "
                + allocationTime(1) + " nanoseconds");
        print("Time to allocateDirect 1 byte = "
                + directAllocationTime(1) + " nanoseconds");
    }
}