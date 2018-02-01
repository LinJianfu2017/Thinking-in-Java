package com.linjianfu.chapter17;

import net.mindview.util.TextFile;

import java.util.ArrayList;

public class Seventeen19 {
    private static void wordCount(String fileName) {
        ArrayList<String> allWords = new TextFile(fileName, "\\W+");
        SimpleHashMap<String, Integer> simpleHashMap =
                new SimpleHashMap<>();
        for (String word : allWords)
            simpleHashMap.put(word, simpleHashMap.containsKey(word) ?
                    simpleHashMap.get(word) + 1 : 1);
        System.out.println(simpleHashMap);
    }

    public static void main(String[] args) {
        String fn = "src\\com\\linjianfu\\chapter17\\Seventeen19.java";
        wordCount(fn);
    }
}
