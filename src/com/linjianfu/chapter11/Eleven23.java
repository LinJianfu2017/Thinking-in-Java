package com.linjianfu.chapter11;

import java.util.*;

public class Eleven23 {
    private static int getBestInt20(int n) {
        Random rand = new Random();
        Map<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        int max = 0;
        for (int i = 0; i < m.keySet().size(); i++) {
            max = max < m.get(i) ? m.get(i) : max;
        }
        /**
         * Entry：Entry<K,V>是Map的一个内部泛型接口，包含getKey()和getValue()方法
         * Map.entryset()返回一个Map.Entry实例化后的对象集(Set)
         * */
//        Set<Map.Entry<Integer, Integer>> me =
//                new LinkedHashSet<>(m.entrySet());
//        int maxKey = 0;
//        Iterator<Map.Entry<Integer, Integer>> it = me.iterator();
//        while (it.hasNext()) {
//            Map.Entry<Integer, Integer> findMax = it.next();
//            if (findMax.getValue() == max)
//                maxKey = findMax.getKey();
//        }
//        return maxKey;
        Set<Integer> me2 = new LinkedHashSet<>(m.keySet());
        int maxKey2 = 0;
        Iterator<Integer> it2 = me2.iterator();
        while (it2.hasNext()) {
            Integer findMax2 = it2.next();
            if (m.get(findMax2) == max)
//                maxKey2 = m.get(findMax2);
                maxKey2 = findMax2;
        }
        return maxKey2;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> m20 = new TreeMap<>();
        for (int i = 0; i < 2000; i++) {
            int x = getBestInt20(10000);
            Integer freq = m20.get(x);
            m20.put(x, freq == null ? 1 : freq + 1);
        }
        System.out.println("Most often picked ints, 0 - 19, in 2000 tests " +
                "of 10,000 random picks: " + m20);
        System.out.println(new Random().nextInt(20));
    }

}




