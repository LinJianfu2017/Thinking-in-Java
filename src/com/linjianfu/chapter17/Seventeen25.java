package com.linjianfu.chapter17;

import net.mindview.util.Countries;

import java.util.*;

//just execute to see output.
public class Seventeen25<K, V> extends AbstractMap<K, V> {
    private class MapEntry25<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;
        private MapEntry25<K, V> nextEntry = null;

        public MapEntry25(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V v) {
            V result = value;
            value = v;
            return result;
        }

        public MapEntry25<K, V> getNextEntry() {
            return this.nextEntry;
        }

        public void setNextEntry(MapEntry25<K, V> nextEntry) {
            this.nextEntry = nextEntry;
        }

        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

        public boolean equals(Object o) {
            if (!(o instanceof MapEntry25)) return false;
            MapEntry25 me = (MapEntry25) o;
            return
                    (key == null ? me.getKey()
                            == null : key.equals(me.getKey())) &&
                            (value == null ? me.getValue() ==
                                    null : value.equals(me.getValue()));
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    // Choose a prime number for the hash table
    // size, to achieve a uniform distribution:
    static final int SIZE = 997;
    // You can't have a physical array of generics,
    // but you can upcast to one:

    //实现单链桶了还用LinkedList？因为还有其他接口需要，实现自包含单链仅为替代ListIterator。
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry25<K, V>>[] buckets =
            new LinkedList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        MapEntry25<K, V> pair = new MapEntry25<>(key, value);
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
            LinkedList<MapEntry25<K, V>> bucket = buckets[index];
            bucket.add(pair);
        }
        LinkedList<MapEntry25<K, V>> bucket = buckets[index];
        if (buckets[index].size() > 0) {
            for (MapEntry25<K, V> entry = bucket.get(0); entry != null;
                 entry = entry.getNextEntry()) {
                if (entry.getKey().equals(key)) {
                    oldValue = entry.getValue();
                    entry.setValue(value);
                    return oldValue;
                }
            }
            bucket.add(pair);
            int i = bucket.indexOf(pair);
            if (i > 0) bucket.get(i - 1).setNextEntry(pair);
            return pair.getValue();
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry25<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry25<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry25<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }

    public static void main(String[] args) {
        Seventeen25<String, String> m =
                new Seventeen25<>();
        m.putAll(Countries.capitals(5));
        System.out.println(m);
        System.out.println(m.put("BENIN", "New York?"));
        System.out.println(m.put("BENIN", "Porto-Novo"));
        System.out.println(m.get("BENIN"));
        System.out.println(m.entrySet());
    }
}