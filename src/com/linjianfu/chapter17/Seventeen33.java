package com.linjianfu.chapter17;

import net.mindview.util.CountingIntegerList;

import java.util.*;

public class Seventeen33 {
    static Random rand = new Random();
    static int reps = 1000;
    static List<Test<FastTraversalLinkedList<Integer>>> tests
            = new ArrayList<>();
    static List<Test<FastTraversalLinkedList<Integer>>> qTests
            = new ArrayList<>();

    static {
        tests.add(new Test<FastTraversalLinkedList<Integer>>("add") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++)
                        list.add(j);
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("get") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.get(rand.nextInt(listSize));
                return loops;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("set") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++)
                    list.set(rand.nextInt(listSize), 47);
                return loops;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("iteradd") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<Integer> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    it.add(47);
                return LOOPS;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("insert") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++)
                    list.add(5, 47); // Minimize random-access cost
                return loops;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("remove") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 5)
                        list.remove(5); // Minimize random-access cost
                }
                return loops * size;
            }
        });
        tests.add(new Test<FastTraversalLinkedList<Integer>>("addAll") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int LOOPS = 100;
                int listSize = tp.size;
                for (int j = 0; j < LOOPS; j++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(listSize));

                }
                return LOOPS;
            }

        });
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("addFirst") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst(47);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("addLast") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast(47);
                }
                return loops * size;
            }
        });
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("rmFirst") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 0)
                        list.removeFirst();
                }
                return loops * size;
            }
        });
        qTests.add(new Test<FastTraversalLinkedList<Integer>>("rmLast") {
            int test(FastTraversalLinkedList<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingIntegerList(size));
                    while (list.size() > 0)
                        list.removeLast();
                }
                return loops * size;
            }
        });
    }

    static class ListTester extends Tester<FastTraversalLinkedList<Integer>> {
        public ListTester(FastTraversalLinkedList<Integer> container,
                          List<Test<FastTraversalLinkedList<Integer>>> tests) {
            super(container, tests);
        }

        public static void run(FastTraversalLinkedList<Integer> list,
                               List<Test<FastTraversalLinkedList<Integer>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }

    public static void main(String[] args) {
        Tester.defaultParams = TestParam.array(
                10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        ListTester.run(new FastTraversalLinkedList<>(), tests);
        Tester.fieldWidth = 12;
        Tester<FastTraversalLinkedList<Integer>> qTest =
                new Tester<>(
                        new FastTraversalLinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }
}