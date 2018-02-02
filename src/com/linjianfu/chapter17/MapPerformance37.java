package com.linjianfu.chapter17;

import java.util.*;

class SimpleHashMap37a<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K, V>>[] buckets =
            new LinkedList[SIZE];

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
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
}

class SimpleHashMap37b<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    ArrayList<MapEntry<K, V>>[] buckets =
            new ArrayList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null)
            buckets[index] = new ArrayList<>();
        ArrayList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (ArrayList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            for (MapEntry<K, V> mpair : bucket)
                set.add(mpair);
        }
        return set;
    }
}

public class MapPerformance37 {
    static List<Test<Map<Integer, Integer>>> tests
            = new ArrayList<>(MapPerformance35.tests);

    public static void main(String[] args) {
        Tester.defaultParams =
                TestParam.array(10, 1000, 100, 1000, 1000, 100);
        Tester.run(new SimpleHashMap37a<>(), tests);
        Tester.run(new SimpleHashMap37b<>(), tests);
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
    }
}
/**
 * ------ SimpleHashMap37a ------
 * size     put     get iterate
 * 10    2273     168     415
 * 100    1442      37     950
 * 1000    7937      75    7775
 * ------ SimpleHashMap37b ------
 * size     put     get iterate
 * 10    1072     342     156
 * 100    1017       9     776
 * 1000    7716      42    7568
 * ---------- TreeMap ----------
 * size     put     get iterate
 * 10     405     147     142
 * 100      45      19       5
 * 1000      47      41       6
 * ---------- HashMap ----------
 * size     put     get iterate
 * 10      18      31      41
 * 100      15       9       9
 * 1000      16      11       8
 * ------- LinkedHashMap -------
 * size     put     get iterate
 * 10      84      29      19
 * 100      24      10       6
 * 1000      24      14       6
 * ------ IdentityHashMap ------
 * size     put     get iterate
 * 10     128      67      42
 * 100      41      22      12
 * 1000      55      50      14
 * -------- WeakHashMap --------
 * size     put     get iterate
 * 10     185      74      35
 * 100      48       8      10
 * 1000      42      18       9
 * --------- Hashtable ---------
 * size     put     get iterate
 * 10     114      32      38
 * 100      64      41       7
 * 1000      35      31       7
 * <p>
 * Process finished with exit code 0
 */