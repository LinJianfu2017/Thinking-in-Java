package com.linjianfu.chapter17;

import net.mindview.util.CountingGenerator;
import net.mindview.util.CountingMapData;

import java.util.*;

public class Seventeen38 {
    static List<Test<Map<Integer, String>>> tests =
            new ArrayList<>();
    static CountingGenerator.String cgs =
            new CountingGenerator.String(5);

    static {
        tests.add(new Test<Map<Integer, String>>("put") {
            int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++)
                        map.put(j, cgs.next());
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, String>>("get") {
            int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        map.get(j);
                return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, String>>("iterate") {
            int test(Map<Integer, String> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) it.next();
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        System.out.println("map1: " + map1);
        map1.putAll(new CountingMapData(16));
        System.out.println("map1: " + map1);
        HashMap<Integer, String> map2 = new HashMap<>(64);
        System.out.println("map2: " + map2);
        map2.putAll(map1);
        System.out.println("map2: " + map2);
        HashMap<Integer, String> map3 = new HashMap<>(1028);
        System.out.println("map3: " + map3);
        map3.putAll(map1);
        System.out.println("map3: " + map3);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        else
            Tester.defaultParams =
                    TestParam.array(10, 1000, 100, 1000, 1000, 1000,
                            10000, 500);
        System.out.println("Comparative time tests:");
        Tester.run(map1, tests);
        Tester.run(map2, tests);
        Tester.run(map3, tests);
        /**看不出啥区别，把上面三行次序调换一下，结果分布趋势惊人的相似，
         * 似乎更大程度是受到了电脑启动算力的瞬时性能影响，是数据不够大？
         */
    }
}
