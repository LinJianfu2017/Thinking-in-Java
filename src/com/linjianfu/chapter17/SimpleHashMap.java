package com.linjianfu.chapter17;

import java.util.*;

class Prime {
    public static int firstPrimeAfter(int n) {
        for (int i = n + 1; i > n; i++) {
            int factors = 0;
            for (int j = 1; j < (i + 2) / 2; j++) {
                if ((i % j) == 0) factors++;
            }
            if (factors < 2) return i;
        }
        return 0;
    }
}

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    private int capacity = SIZE;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public int getCapacity() {
        return capacity;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        capacity = Prime.firstPrimeAfter(capacity * 2);
        LinkedList<MapEntry<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[capacity];
        for (LinkedList<MapEntry<K, V>> bucket : oldBuckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mpair : bucket)
                this.put(mpair.getKey(), mpair.getValue());
        }
    }

    @Override
    public V put(K key, V value) {
        if (this.size() > 0.75 * capacity) rehash();
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
//                System.out.println("Collision: new" + pair + " for old " + iPair);
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found) buckets[index].add(pair);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        }
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> m : bucket)
                set.add(m);
        }
        return set;
    }

    @Override
    public V remove(Object key) {
        V v = null;
        if (get(key) != null) {
            int index = Math.abs(key.hashCode()) % SIZE;
            for (MapEntry<K, V> iPair : buckets[index])
                if (iPair.getKey().equals(key)) {
                    v = iPair.getValue();
                    int i =
                            buckets[index].indexOf(iPair);
                    buckets[index].remove(i);
                    break;
                }
        }
        return v;
    }

    @Override
    public void clear() {
        for (LinkedList<MapEntry<K, V>> bucket : buckets)
            bucket.clear();
    }

}
