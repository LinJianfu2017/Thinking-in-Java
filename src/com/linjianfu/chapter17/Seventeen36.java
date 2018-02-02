package com.linjianfu.chapter17;

import java.util.*;

class SlowMap36a<K, V> extends AbstractMap<K, V> {
    protected List<MapEntry<K, V>> entryList = new ArrayList<>();
    private EntrySet entries = new EntrySet();

    public Set<Map.Entry<K, V>> entrySet() {
        return entries;
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public int size() {
            return entryList.size();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                private int index = -1;

                public boolean hasNext() {
                    return index < entryList.size() - 1;
                }

                @SuppressWarnings("unchecked")
                public Map.Entry<K, V> next() {
                    int i = ++index;
                    return entryList.get(i);
                }

                public void remove() {
                    entryList.remove(index--);
                }
            };
        }
    }

    public V put(K key, V value) {
        V oldValue = get(key);
        Iterator<MapEntry<K, V>> it = entryList.iterator();
        while (it.hasNext()) {
            MapEntry<K, V> me = it.next();
            if (me.getKey().equals(key))
                me.setValue(value);
        }
        entryList.add(new MapEntry<>(key, value));
        return oldValue;
    }

    public V get(Object key) {
        Iterator<MapEntry<K, V>> it = entryList.iterator();
        while (it.hasNext()) {
            MapEntry<K, V> me = it.next();
            if (me.getKey().equals(key))
                return me.getValue();
        }
        return null;
    }
}

// SlowMap with modified put() and get() methods:
class SlowMap36b<K, V> extends SlowMap36a<K, V> {
    private List<MapEntry<Integer, V>> hashEntryList = new ArrayList<>();

    public List<MapEntry<Integer, V>> hashEntryList() {
        return hashEntryList;
    }

    private final MapEntryKeyComp<K, V> comp1 = new MapEntryKeyComp<>();
    private final MapEntryKeyComp<Integer, V> comp2 = new MapEntryKeyComp<>();

    // Very slow put() with 2 sorts:
    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        Iterator<MapEntry<K, V>> it = entryList.iterator();
        while (it.hasNext()) {
            MapEntry<K, V> me = it.next();
            if (me.getKey().equals(key)) {
                me.setValue(value);
            }
        }
        entryList.add(new MapEntry<>(key, value));
        hashEntryList.add(new MapEntry<>(key.hashCode(), value));
        // Sort (uses hashCode()) after adding:
        Collections.sort(entryList, comp1);
        Collections.sort(hashEntryList, comp2);
        return oldValue;
    }

    // Faster get() with sorting done in put:
    @Override
    public V get(Object key) {
        MapEntry<Integer, V> sub = new MapEntry<>(key.hashCode(), null);
        int i = Collections.binarySearch(hashEntryList, sub, comp2);
        if (i >= 0) return hashEntryList.get(i).getValue();
        return null;
    }
}

// Sort by key hashCode():
class MapEntryKeyComp<K, V> implements Comparator<MapEntry<K, V>> {
    public int compare(MapEntry<K, V> me1, MapEntry<K, V> me2) {
        return me1.getKey().hashCode() - me2.getKey().hashCode();
    }
}

public class Seventeen36 {
    static List<Test<Map<Integer, Integer>>> tests =
            new ArrayList<>(MapPerformance35.tests);

    public static void main(String[] args) {
        Tester.defaultParams
                = TestParam.array(10, 100, 50, 50, 100, 20);
        Tester.run(new SlowMap<>(), tests);
        //以下两个，除了iterator迭代进步了，其他越渣：
        Tester.run(new SlowMap36a<>(), tests);
        Tester.run(new SlowMap36b<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
    }
}
/**F:\JAVA\jdk1.8.0_144\bin\java
 ---------- SlowMap ----------
 size     put     get iterate
 10    4412     340     757
 50    6458     212    1438
 100    2209     282    1471
 --------- SlowMap36a ---------
 size     put     get iterate
 10    2686     422     115
 50    2104    1375      46
 100    3997    2647      45
 --------- SlowMap36b ---------
 size     put     get iterate
 10   22504     296      44
 50   20200     188      11
 100   36831     129       2
 ---------- HashMap ----------
 size     put     get iterate
 10     152     165     171
 50     144      87     130
 100     127      97      73
 ---------- TreeMap ----------
 size     put     get iterate
 10    1158     545     244
 50     423     135      57
 100     331     152      16
 ------- LinkedHashMap -------
 size     put     get iterate
 10     457     190      88
 50     133      61      18
 100     118      61      26
 ------ IdentityHashMap ------
 size     put     get iterate
 10     605     239     222
 50     273      85      54
 100    2001      53      32
 -------- WeakHashMap --------
 size     put     get iterate
 10     657     229     172
 50     278      64      33
 100     260      44      20
 --------- Hashtable ---------
 size     put     get iterate
 10     342     107     164
 50     220      56      15
 100     132      37      11

 Process finished with exit code 0
 */