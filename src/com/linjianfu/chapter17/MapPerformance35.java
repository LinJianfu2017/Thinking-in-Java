package com.linjianfu.chapter17;

import java.util.*;

public class MapPerformance35 {
    static List<Test<Map<Integer, Integer>>> tests
            = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++)
                        map.put(j, j);
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        map.get(j);
                return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            int test(Map<Integer, Integer> map, TestParam tp) {
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
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        else
            Tester.defaultParams =
                    TestParam.array(10, 500, 100, 500, 500, 100);
        Tester.run(new SlowMap<>(), tests);
//        Tester.run(new SimpleHashMap<>(), tests);
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
    }
}
/**
 * ---------- SlowMap ----------
 * size     put     get iterate
 * 10    1936     320     379
 * 100    1972     143    1007
 * 500    5765     362    3704
 * ---------- TreeMap ----------
 * size     put     get iterate
 * 10     643     153     236
 * 100      34      39      56
 * 500      46      31       5
 * ---------- HashMap ----------
 * size     put     get iterate
 * 10     208     103     103
 * 100      53      34      18
 * 500      19      10       8
 * ------- LinkedHashMap -------
 * size     put     get iterate
 * 10     244      40      36
 * 100      32      10       6
 * 500      25      13       6
 * ------ IdentityHashMap ------
 * size     put     get iterate
 * 10     173      56      69
 * 100      58      20      13
 * 500      62      48      16
 * -------- WeakHashMap --------
 * size     put     get iterate
 * 10     252      75      76
 * 100      47      10      10
 * 500      30      28       9
 * --------- Hashtable ---------
 * size     put     get iterate
 * 10     170      48      47
 * 100      44      41       9
 * 500      28      17       8
 * <p>
 * Process finished with exit code 0
 */