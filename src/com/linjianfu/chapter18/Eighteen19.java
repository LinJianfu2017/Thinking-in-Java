package com.linjianfu.chapter18;

import net.mindview.util.BinaryFile;

import java.io.IOException;
import java.util.*;

public class Eighteen19 {
    public static void main(String[] args) throws IOException {
        String fileName = Eighteen12.dirPath + "Eighteen19.java";
        Map<Byte, Integer> byteMap = new HashMap<>();
        Set<Byte> byteSet = new TreeSet<>();
        List<Byte> byteList = new ArrayList<>();
        byte[] bytes = BinaryFile.read(fileName);
        for (Byte b : bytes) byteSet.add(b);
        for (Byte b : bytes) byteList.add(b);
        for (Byte b : byteSet) {
            int count = 0;
            for (Byte bb : byteList)
                if (b.equals(bb)) count++;
            byteMap.put(b, count);
        }
        System.out.println(byteMap);
    }
}
