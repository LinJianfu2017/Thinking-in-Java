package com.linjianfu.chapter18;

import java.nio.CharBuffer;

public class Eighteen23 {
    public static void printCharBuffer(CharBuffer cb) {
        cb.clear();
        while (cb.hasRemaining()) {
            char c = cb.get();
            if (isPrintable(c)) System.out.print(c + " ");
        }
        System.out.println();
    }

    public static boolean isPrintable(char c) {
        return (c >= '!') && (c <= '~');
    }

    public static void main(String[] args) {
        CharBuffer cb = CharBuffer.wrap(new char[]{'x', 'y', 'z'}),
                cb2 = CharBuffer.allocate(8);
        cb2.put("a");
        cb2.put("bc");
        cb2.put(cb);
        printCharBuffer(cb2);
        cb2.clear();//Set position to zero,limit to capacity.
        printCharBuffer(cb2);
        System.out.println(cb2.length());// cb2.length = 0
        System.out.println(cb2.toString().equals(""));// true,空字符
        printCharBuffer(cb2);//a b c x y z
        // why?-->length()=limit-position:
        cb2.clear();
        System.out.println(cb2.length());// It's OK
        System.out.println(cb2.toString());
    }
}
