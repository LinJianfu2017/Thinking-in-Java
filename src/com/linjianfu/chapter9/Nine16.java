package com.linjianfu.chapter9;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

class CharsGenerator {
    private Random rand = new Random(47);

    public char next() {
        return (char) rand.nextInt(128);
    }
/**Use to test*/
//    public static void main(String[] args) {
//        CharsGenerator c = new CharsGenerator();
//        for (int i = 0; i < 10; i++) {
//            System.out.println(c.next() + " ");
//        }
//    }
}

class CharsGeneratorAdapter extends CharsGenerator
        implements Readable {
    private int count;

    public CharsGeneratorAdapter(int count) {
        this.count = count;
    }

    public int read(CharBuffer cb) {
        if (count-- == 0)
            return -1;
        String result = Character.toString(next())+" linjianfu" ;
        cb.append(result);
//        return result.length();
        return 0;
    }
}

public class Nine16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(new CharsGeneratorAdapter(5));
        while (s.hasNext())
            System.out.println(s.next() + " ");
    }
}
