package com.linjianfu.chapter17;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.*;

//Exercise 29,30.
public class ListPerformance29 {
    static RandomGenerator.String randString = new RandomGenerator.String();
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<List<String>>> tests =
            new ArrayList<>();
    static List<Test<LinkedList<String>>> qTests =
            new ArrayList<>();

    static {
        tests.add(new Test<List<String>>("add") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(randString.next());
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<String>>("get") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<List<String>>("set") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), "hi");
                return loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            int test(List<String> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add("hi");
                return LOOPS;
            }
        });
        tests.add(new Test<List<String>>("insert") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    list.add(5, "hi"); // Minimize random-access cost
                return loops;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class,
                            new CountingGenerator.String(), size)));
                    while (list.size() > 5)
                        list.remove(5); // Minimize random-access cost
                }
                return loops * size;
            }
        });
        tests.add(new Test<List<String>>("Cs.sort()") {
            @Override
            int test(List<String> list, TestParam tp) {
                int LOOPS = 100;
                int size = tp.size;
                list.addAll(Arrays.asList(Generated.array(String.class,
                        new CountingGenerator.String(), size)));
                for (int i = 0; i < LOOPS; i++) {
                    Collections.sort(list);
                }
                list.clear();
                return LOOPS;
            }
        });
        qTests.add(new Test<LinkedList<String>>("addFirst") {
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst("hi");
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("addLast") {
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast("hi");
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("rmFirst") {
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class,
                            new CountingGenerator.String(), size)));
                    while (list.size() > 0)
                        list.removeFirst();
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("rmLast") {
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(Arrays.asList(Generated.array(String.class,
                            new CountingGenerator.String(), size)));
                    while (list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container, List<Test<List<String>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<String> initialize(int size) {
            container.clear();
            container.addAll(Arrays.asList(Generated.array(String.class,
                    new CountingGenerator.String(), size)));
            return container;
        }

        public static void run(List<String> list, List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        // Can only do these two tests on an array:
        Tester<List<String>> arrayTest =
                new Tester<List<String>>(null, tests.subList(1, 3)) {
                    // This will be called before each test. It produces
                    // a non-resizeable array-backed list:
                    @Override
                    protected List<String> initialize(int size) {
                        String[] ia = Generated.array(String.class,
                                new CountingGenerator.String(), size);
                        return Arrays.asList(ia);
                    }
                };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester.defaultParams = TestParam.array(
                10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        ListTester.run(new Vector<>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> qTest = new Tester<>(
                new LinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}
/**
 * --- Array as List ---
 * size     get     set
 * 10      13      14
 * 100      11      15
 * 1000      11      13
 * 10000      18      19
 * ------------------------- ArrayList -------------------------
 * size     add     get     set iteradd  insert  removeCs.sort()
 * 10     354      16      18      31     252     307   12709
 * 100     241      17      14      18     239     141   13479
 * 1000     172      12      13      49     155     158   49654
 * 10000     135      12      14     404    1351     574  363860
 * ------------------------- LinkedList -------------------------
 * size     add     get     set iteradd  insert  removeCs.sort()
 * 10     210      26      27      19     138     175    5084
 * 100     126      36      37       9      58      94   12384
 * 1000     129     310     306       6      46      96   61029
 * 10000     142    3754    3781      10      62     108  423423
 * --------------------------- Vector ---------------------------
 * size     add     get     set iteradd  insert  removeCs.sort()
 * 10     182      13      16      20     248     165     427
 * 100     122      13      16      19     268     102    2014
 * 1000     118      13      16      52     153     149   21083
 * 10000     124      12      13     411    1391     569  331581
 * -------------------- Queue tests --------------------
 * size    addFirst     addLast     rmFirst      rmLast
 * 10          45          38         167         167
 * 100          12          12          95          97
 * 1000          12          14         122          94
 * 10000           9           9          93          92
 * <p>
 * Process finished with exit code 0
 */