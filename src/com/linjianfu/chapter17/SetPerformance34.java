package com.linjianfu.chapter17;

import net.mindview.util.CountingGenerator;

import java.util.*;

public class SetPerformance34 {
    static CountingGenerator.String cgs = new CountingGenerator.String(5);
    static CountingGenerator.String cgs2 = new CountingGenerator.String(5);
    static List<Test<Set<String>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Set<String>>("add") {
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++)
                        set.add(cgs.next());
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++)
                        set.contains(cgs2.next());
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) it.next();
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<>(), tests);
        Tester.run(new HashSet<>(), tests);
        Tester.run(new LinkedHashSet<>(), tests);
    }
}
/**
 * ------------- TreeSet -------------
 * size       add  contains   iterate
 * 10       488       204        27
 * 100       205        86         6
 * 1000       100        91         2
 * 10000        82        78         3
 * ------------- HashSet -------------
 * size       add  contains   iterate
 * 10       187       103        43
 * 100        70        68         5
 * 1000        69        67         6
 * 10000        70        71         6
 * ---------- LinkedHashSet ----------
 * size       add  contains   iterate
 * 10       278       143        14
 * 100        92        72         6
 * 1000        74        81         5
 * 10000        72        73         7
 * <p>
 * Process finished with exit code 0
 */