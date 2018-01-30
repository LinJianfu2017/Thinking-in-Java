package com.linjianfu.chapter18;

import java.io.IOException;
import java.util.*;

public class Eighteen17 {
    public static void main(String[] args) throws IOException {
        String fileName = "Eighteen17.java";
        char[] chars = BufferedInputFile.read(fileName).toCharArray();
        Set<Character> charSet = new TreeSet<>();
        for (char c : chars) charSet.add(c);
        List<Character> charList = new ArrayList<>();
        for (char c : chars) charList.add(c);
        Map<Character, Integer> charMap = new TreeMap<>();
        for (Character c : charSet) {
            int count = 0;
            for (Character cc : charList)
                if (c.equals(cc)) count++;
            charMap.put(c, count);
        }
        System.out.println(charMap);
    }
}
