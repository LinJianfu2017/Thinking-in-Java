package com.linjianfu.chapter17;

import net.mindview.util.TextFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Seventeen13 {
    private static Seventeen12<String, Integer> wordCount(String fileName)
            throws FileNotFoundException {
        ArrayList<String> allWords = new TextFile(fileName, "\\W+");
        Set<String> wordSet = new TreeSet<>(allWords);
        Seventeen12<String, Integer> map = new Seventeen12<>(wordSet.size());
        for (String s : wordSet) {
            int count = 0;
            for (String t : allWords)
                if (s.equals(t)) count++;
            map.put(s, count);
        }
        return map;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "src\\com\\linjianfu\\chapter17\\Seventeen13.java";
        System.out.println(wordCount(fileName));
    }
}
