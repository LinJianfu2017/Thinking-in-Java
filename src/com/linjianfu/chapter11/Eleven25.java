package com.linjianfu.chapter11;

import net.mindview.util.TextFile;

import java.util.*;

public class Eleven25 {
    public Map<String, ArrayList<Integer>> mapOfWords(TextFile textFile) {
        int count = 0;
        Map<String, ArrayList<Integer>> m = new LinkedHashMap<>();
        List<String> words = new LinkedList<>(textFile);
        Iterator<String> iterator = words.iterator();

        while (iterator.hasNext()) {
            String s = iterator.next();
            count++;
            if (m.keySet().contains(s)) {
                m.get(s).add(count);
            } else {
                ArrayList<Integer> id = new ArrayList<>();
                id.add(0, count);
                m.put(s, id);
            }
        }
        return m;
    }

    public static void main(String[] args) {
        Eleven25 eleven25 = new Eleven25();
        Map<String, ArrayList<Integer>> map =
                eleven25.mapOfWords(new TextFile("src/com/linjianfu/chapter11/Eleven24.java", "\\W+"));
        System.out.println(map);
    }
}
