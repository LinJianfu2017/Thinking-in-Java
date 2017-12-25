package com.linjianfu.chapter11;

import net.mindview.util.TextFile;

import java.util.*;

public class Eleven26 {

    public static void main(String[] args) {
//        List<String> words = new LinkedList<>();
//        words.addAll(new TextFile("src/com/linjianfu/chapter11/Eleven25.java", "\\W+"));
//        Map<String, ArrayList<Integer>> stringArrayListMap = new TreeMap<>();
//        Iterator<String> stringIterator = words.iterator();
//        int count = 0;
//        while (stringIterator.hasNext()) {
//            String s = stringIterator.next();
//            count++;
//            if (!stringArrayListMap.keySet().contains(s)) {
//                ArrayList<Integer> ai = new ArrayList<>();
//                ai.add(0, count);
//                stringArrayListMap.put(s, ai);
//            } else {
//                stringArrayListMap.get(s).add(count);
//            }
//        }
        Map<String, ArrayList<Integer>>
                stringArrayListMap = new Eleven25().mapOfWords(
                new TextFile("src/com/linjianfu/chapter11/Eleven25.java", "\\W+"));

        Map<Integer, String> replay = new TreeMap<>();
        Iterator<Map.Entry<String, ArrayList<Integer>>>
                entryIterator = stringArrayListMap.entrySet().iterator();
        while (entryIterator.hasNext()) {
            Map.Entry<String, ArrayList<Integer>> map = entryIterator.next();
            for (int i = 0; i < map.getValue().size(); i++)
                replay.put(map.getValue().get(i), map.getKey());
        }
        System.out.println("TreeMap of ordered locations,words: ");
        System.out.println(replay);
        System.out.println("Words in original order: ");
        System.out.println(replay.values());


    }

}
