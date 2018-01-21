package util.generator;

import net.mindview.util.Generator;

import java.util.*;

public class CollectionGenerator {
    public static <T> Collection<T> fill(Collection<T> collection,
                                         Generator<T> generator, int n) {
        while (n-- > 0)
            collection.add(generator.next());
        return collection;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> generator,
                                   int n) {
        while (n-- > 0)
            list.add(generator.next());
        return list;
    }

    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> generator,
                                    int n) {
        while (n-- > 0)
            queue.add(generator.next());
        return queue;
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> generator,
                                  int n) {
        while (n-- > 0)
            set.add(generator.next());
        return set;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> linkedList, Generator<T>
            generator, int n) {
        while (n-- > 0)
            linkedList.add(generator.next());
        return linkedList;
    }
}
