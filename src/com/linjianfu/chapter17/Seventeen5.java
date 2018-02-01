package com.linjianfu.chapter17;

import java.util.*;

public class Seventeen5 extends AbstractMap<Integer, String> {
    private static String[] chars =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
                    .split(" ");

    private static class Entry implements AbstractMap.Entry<Integer, String> {
        int index;

        public Entry(int index) {
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            return Integer.valueOf(index).equals(obj);
        }

        @Override
        public Integer getKey() {
            return index;
        }

        @Override
        public String getValue() {
            return chars[index % chars.length] +
                    Integer.toString(index / chars.length);
        }

        @Override
        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
        private int size;

        protected EntrySet(int size) {
            this.size = size < 0 ? 0 : (size < chars.length ? size : chars.length);
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {
                private Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return entry.index++ < size;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return size;
        }
    }

    private static Set<Map.Entry<Integer, String>> entries =
            new EntrySet(chars.length);

    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return entries;
    }

    public static Map<Integer, String> select(final int size) {
        return new Seventeen5() {
            @Override
            public Set<Map.Entry<Integer, String>> entrySet() {
                return new EntrySet(size);
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(select(10));
        System.out.println(new Seventeen5());
    }
}
