package util.generator;

import java.util.*;

public class New {
    public static <X, Y> Map<X, Y> map() {
        return new HashMap<>();
    }

    public static <T> List<T> list() {
        return new ArrayList<>();
    }

    public static <T> Set<T> set() {
        return new HashSet<>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<>();
    }

    private static void f(List list) {
    }

    public static void main(String[] args) {
        f(list());
    }
}
