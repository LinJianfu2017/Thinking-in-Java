package com.linjianfu.chapter15;

import net.mindview.util.Generator;

import java.util.Iterator;

public class Fifteen7 {
    public static class Fibonacci implements Generator<Integer>, Iterable<Integer> {
        private int count = 0;
        private int size = 0;

        public Integer next() {
            return fibonacci(count++);
        }

        public Fibonacci() {
        }

        public Fibonacci(int n) {
            size = n;
        }


        private int fibonacci(int i) {
            if (i < 2) return 1;
            return fibonacci(i - 1) + fibonacci(i - 2);
        }

        private class FibonacciIterator implements Iterator<Integer> {
            @Override
            public boolean hasNext() {
                return size > count;
            }

            @Override
            public Integer next() {
                return Fifteen7.Fibonacci.this.next();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public Iterator<Integer> iterator() {
            return new FibonacciIterator();
        }

       // 或者匿名内部类形式：
//        @Override
//        public Iterator<Integer> iterator() {
//            return new Iterator<Integer>() {
//                @Override
//                public boolean hasNext() {
//                    return size > count;
//                }
//
//                @Override
//                public Integer next() {
//                    return Fifteen7.Fibonacci.this.next();
//                }
//
//                @Override
//                public void remove() {
//                    throw new UnsupportedOperationException();
//                }
//            };
//        }
    }

    public static void main(String[] args) {
        for (int i : new Fibonacci(20))
            System.out.print(i + "  ");
    }
}
