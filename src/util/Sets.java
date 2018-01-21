package util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {
    @SuppressWarnings("unchecked")
    public static <T> Set<T> union(Set<T> a, Set<T> b) {

        try {
            if (a instanceof EnumSet) {
                Set<T> result = ((EnumSet) a).clone();
                result.addAll(b);
                return result;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {

        try {
            if (a instanceof EnumSet) {
                Set<T> result = ((EnumSet) a).clone();
                result.retainAll(b);
                return result;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <T> Set<T> difference(Set<T> a, Set<T> b) {
        try {
            if (a instanceof EnumSet) {
                Set<T> result = ((EnumSet) a).clone();
                result.removeAll(b);
                return result;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Set<T> result = new HashSet<>(a);
        result.removeAll(b);
        return result;
    }

    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

}
