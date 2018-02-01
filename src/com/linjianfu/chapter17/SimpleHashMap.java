package com.linjianfu.chapter17;

import java.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    @Override
    public V put(K key, V value) {
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
                System.out.println("Collision: new" + pair + " for old " + iPair);
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
