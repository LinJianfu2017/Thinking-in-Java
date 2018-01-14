package com.linjianfu.chapter16;

import net.mindview.util.Generator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Sixteen16 {
    public interface SkipGenerator<T> extends Generator<T> {
        T next();

        T next(int n);
    }

    static char[] chars = ("abcdefghijklmnopqnrstuvwxyz" + "ABCDEFGHIJKLMNOPQNRSTUVWXYZ").toCharArray();

    public static class CharacterSkipGenerator implements SkipGenerator<Character> {
        int index = -1, index2 = -1;

        @Override
        public Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }

        @Override
        public Character next(int n) {
            index2 = (index2 + n) % chars.length;
            return chars[index2];
        }
    }

    private static char[] primitive(Character[] in) {
        char[] results = new char[in.length];
        for (int i = 0; i < in.length; i++)
            results[i] = in[i];
        return results;
    }

    public static class CollectionData2<T> extends ArrayList<T> {
        public CollectionData2(SkipGenerator<T> gen, int size, int skip) {
            for (int i = 0; i < size; i++)
                add(gen.next(skip));
        }
    }

    public static <T> T[] array(T[] ts, SkipGenerator<T> gen, int skip) {
        return new CollectionData2<T>(gen, ts.length, skip).toArray(ts);
    }

    public static <T> T[] array(Class<T> type, SkipGenerator<T> gen, int size, int skip) {
        T[] ts = (T[]) Array.newInstance(type, size);
        return new CollectionData2<T>(gen, size, skip).toArray(ts);
    }

    public static void main(String[] args) {
        CharacterSkipGenerator characterSkipGenerator = new CharacterSkipGenerator();
        System.out.println(Arrays.toString(primitive(array(Character.class, characterSkipGenerator, 5, 2))));
        Character[] chars = new Character[5];
        System.out.println(Arrays.toString(primitive(array(chars, characterSkipGenerator, 2))));
    }
}
