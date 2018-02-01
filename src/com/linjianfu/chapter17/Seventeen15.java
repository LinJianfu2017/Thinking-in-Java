package com.linjianfu.chapter17;

import net.mindview.util.TextFile;

import java.util.ArrayList;

//Exercise 15,16,19.
public class Seventeen15 {
    private static SlowMap<String, Integer> wordCount(String fileName) {
        ArrayList<String> allWords = new TextFile(fileName, "\\W+");
        SlowMap<String, Integer> slowMap = new SlowMap<>();
        for (String s : allWords)
            slowMap.put(s, slowMap.containsKey(s) ? slowMap.get(s) + 1 : 1);
        return slowMap;
    }

    public static void main(String[] args) {
        String fileName = "src\\com\\linjianfu\\chapter17\\Seventeen15.java";
        System.out.println(wordCount(fileName));
        //Ex16:
        Seventeen14.test(new SlowMap<>());
    }
}
