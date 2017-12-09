package com.linjianfu.chapter10;

import com.linjianfu.chapter10.T6one.Ten6interface;

public class Ten13 {
    private Ten6interface inner() {
        /**
         * Anonymous inner class：
         * */
        Ten6interface inner = new Ten6interface() {
            @Override
            public void face1() {
                System.out.println("Exercise 13.");
            }
        };
        return inner;
    }

    /**
     * Also can do like this:
     */
    Ten6interface inner2() {
        return new Ten6interface() {
            @Override
            public void face1() {
                System.out.println("Exercise 13.2333333");
            }
        };
    }

    public static void main(String[] args) {
        Ten13 ten13 = new Ten13();
        ten13.inner().face1();
        ten13.inner2().face1();
    }
}
