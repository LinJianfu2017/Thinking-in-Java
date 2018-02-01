package com.linjianfu.chapter17;

import net.mindview.util.Countries;

import java.util.*;

public class Seventeen17<K, V> implements Map<K, V> {
    public static void main(String[] args) {
        Seventeen17<String, String> map = new Seventeen17<>();
        map.putAll(Countries.capitals(10));
        System.out.println(map);
    }

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override
    public V remove(Object key) {
        V result = get(key);
        int i = keys.indexOf(key);
        keys.remove(i);
        values.remove(i);
        return result;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> e : m.entrySet())
            put(e.getKey(), e.getValue());
    }

    @Override
    public Set<K> keySet() {
        return new LinkedHashSet<>(keys);
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new AbstractSet<Entry<K, V>>() {
            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new Iterator<Entry<K, V>>() {
                    private int index = -1;

                    @Override
                    public boolean hasNext() {
                        return ++index < keys.size();
                    }

                    @Override
                    public Entry<K, V> next() {
                        return new MapEntry<>(keys.get(index),
                                values.get(index));
                    }
                };
            }

            @Override
            public int size() {
                return keys.size();
            }
        };
    }

    @Override
    public String toString() {
        return entrySet().toString();
    }

    private static class MapEntry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V result = this.value;
            this.value = value;
            return result;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MapEntry)) return false;
            MapEntry me = (MapEntry) obj;
            return (key == null ? me.getKey() == null : key.equals(me.getKey()))
                    && (value == null ? me.getValue() == null :
                    value.equals(me.getValue()));
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }

}