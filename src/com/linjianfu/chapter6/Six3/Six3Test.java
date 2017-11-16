package com.linjianfu.chapter6.Six3;

import static com.linjianfu.chapter6.Six3.Debug.Debug.debug;

public class Six3Test {
    public static void main(String[] args) {
        debug("Who is?");
        com.linjianfu.chapter6.Six3.Debugoff.Debug.debug("jj");
        /**我擦，试了半天，发现另一个只能以指定全名的方式来引用了........*/
    }
}
