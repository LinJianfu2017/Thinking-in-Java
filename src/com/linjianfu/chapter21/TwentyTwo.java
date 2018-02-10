package com.linjianfu.chapter21;

public class TwentyTwo {
    public static class Fibonacci1 implements Runnable {
        private int n;

        Fibonacci1(int n) {
            this.n = n;
        }

        public int fab(int x) {
            if (x < 2) return 1;
            return fab(x - 1) + fab(x - 2);
        }

        @Override
        public void run() {
            System.out.println(this.getClass().getSimpleName());
            for (int i = 0; i < n; i++) {
                System.out.print(fab(i) + " ");
            }
            System.out.println();
        }
    }

    public static class Fibonacci2 extends Fibonacci1 {
        Fibonacci2(int n) {
            super(n);
        }

        @Override
        public int fab(int x) {
            int a = 1;
            int b = 1;
            while (x > 1) {
                a = a + b;
                b = b + a;
                x -= 2;
            }
            if (x % 2 == 0) return a;
            return b;
        }
    }

    public static class Fibonacci3 extends Fibonacci1 {
        Fibonacci3(int n) {
            super(n);
        }

        @Override
        public int fab(int x) {
            int a = 1;
            int b = 1;
            while (x-- > 1) {
                b = a + b;
                a = b - a;
            }
            return b;
        }
    }

    public static class Fibonacci4 extends Fibonacci1 {
        Fibonacci4(int n) {
            super(n);
        }

        @Override
        public int fab(int x) {
            int a = 1;
            int b = 1;
            while (x-- > 1) {
                a = a + b;
                a ^= b;
                b ^= a;
                a ^= b;
            }
            return b;
        }
    }

    public static void main(String[] args) {
        new Thread(new Fibonacci1(10)).start();
        new Thread(new Fibonacci2(10)).start();
        new Thread(new Fibonacci3(10)).start();
        new Thread(new Fibonacci4(10)).start();
    }
}
