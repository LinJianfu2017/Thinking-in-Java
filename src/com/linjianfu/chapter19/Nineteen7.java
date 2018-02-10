package com.linjianfu.chapter19;

//解释EnumSet的工作原理：

/**
 * 这边主要研究了它的“扩容机制”。
 * 根据Enum的elements数量分为两种情况，分别对应一个EnumSet的子类：
 * RegularEnumSet（universe.length<=64）和JumboEnumSet（universe.length>64）；
 * EnumSet将一个Enum的所有elements映射到了一个long型数据上，并以一个bit位代表一个
 * element,bit置1代表存在相应element，所以如果是刚好length=64,则long值=-1；当length
 * 超过64时，被称为'jumbo enum'，此时elements被拆分成64个一组映射到一个long型数组上，
 * 对应的就是每个数组元素最多可以代表64个element；遍历元素用到了Iterator接口。
 * <p>
 * 其间，主要的算法均是基于基本数据类型的移位操作，所以速度极快，且快于容器类Set等。
 */
public class Nineteen7 {
}
/**************************部分源码**********************************/
//public abstract class EnumSet<E extends Enum<E>> extends AbstractSet<E>
//        implements Cloneable, java.io.Serializable {
//    /**
//     * The class of all the elements of this set.
//     */
//    final Class<E> elementType;
//
//    /**
//     * All of the values comprising T.  (Cached for performance.)
//     */
//    final Enum<?>[] universe;
//
//    private static Enum<?>[] ZERO_LENGTH_ENUM_ARRAY = new Enum<?>[0];
//
//    EnumSet(Class<E> elementType, Enum<?>[] universe) {
//        this.elementType = elementType;
//        this.universe = universe;
//    }
//    public static <E extends Enum<E>> java.util.EnumSet<E> noneOf(Class<E> elementType) {
//        Enum<?>[] universe = getUniverse(elementType);
//        if (universe == null)
//            throw new ClassCastException(elementType + " not an enum");
//
//        if (universe.length <= 64)
//            return new RegularEnumSet<>(elementType, universe);
//        else
//            return new JumboEnumSet<>(elementType, universe);
//    }
//
//    public static <E extends Enum<E>> java.util.EnumSet<E> allOf(Class<E> elementType) {
//        java.util.EnumSet<E> result = noneOf(elementType);
//        result.addAll();
//        return result;
//    }
/*******************************************************************/
//class RegularEnumSet<E extends Enum<E>> extends EnumSet<E> {
//    private static final long serialVersionUID = 3411599620347842686L;
//    /**
//     * Bit vector representation of this set.  The 2^k bit indicates the
//     * presence of universe[k] in this set.
//     */
//    private long elements = 0L;
//
//    RegularEnumSet(Class<E> elementType, Enum<?>[] universe) {
//        super(elementType, universe);
//    }
//
//    void addRange(E from, E to) {
//        elements = (-1L >>> (from.ordinal() - to.ordinal() - 1)) << from.ordinal();
//    }
//
//    void addAll() {
//        if (universe.length != 0)
//            elements = -1L >>> -universe.length;
//    }

/****************************************************************/
//class JumboEnumSet<E extends Enum<E>> extends EnumSet<E> {
//    private static final long serialVersionUID = 334349849919042784L;
//
//    /**
//     * Bit vector representation of this set.  The ith bit of the jth
//     * element of this array represents the  presence of universe[64*j +i]
//     * in this set.
//     */
//    private long elements[];
//
//    // Redundant - maintained for performance
//    private int size = 0;
//
//    JumboEnumSet(Class<E> elementType, Enum<?>[] universe) {
//        super(elementType, universe);
//        elements = new long[(universe.length + 63) >>> 6];
//    }
//
//    void addAll() {
//        for (int i = 0; i < elements.length; i++)
//            elements[i] = -1;
//        elements[elements.length - 1] >>>= -universe.length;
//        size = universe.length;
//    }
//
//    public Iterator<E> iterator() {
//        return new java.util.JumboEnumSet.EnumSetIterator<>();
//    }
//
//    private class EnumSetIterator<E extends Enum<E>> implements Iterator<E> {
//        /**
//         * A bit vector representing the elements in the current "word"
//         * of the set not yet returned by this iterator.
//         */
//        long unseen;
//
//        /**
//         * The index corresponding to unseen in the elements array.
//         */
//        int unseenIndex = 0;
//
//        /**
//         * The bit representing the last element returned by this iterator
//         * but not removed, or zero if no such element exists.
//         */
//        long lastReturned = 0;
//
//        /**
//         * The index corresponding to lastReturned in the elements array.
//         */
//        int lastReturnedIndex = 0;
//
//        EnumSetIterator() {
//            unseen = elements[0];
//        }
//
//        @Override
//        public boolean hasNext() {
//            while (unseen == 0 && unseenIndex < elements.length - 1)
//                unseen = elements[++unseenIndex];
//            return unseen != 0;
//        }
//
//        @Override
//        @SuppressWarnings("unchecked")
//        public E next() {
//            if (!hasNext())
//                throw new NoSuchElementException();
//            lastReturned = unseen & -unseen;
//            lastReturnedIndex = unseenIndex;
//            unseen -= lastReturned;
//            return (E) universe[(lastReturnedIndex << 6)
//                    + Long.numberOfTrailingZeros(lastReturned)];
//        }
//    }
/********************Long.numberOfTrailingZeros()*********************/
//public static int numberOfTrailingZeros(long i) {
//    // HD, Figure 5-14
//    int x, y;
//    if (i == 0) return 64;
//    int n = 63;
//    y = (int) i;
//    if (y != 0) {
//        n = n - 32;
//        x = y;
//    } else x = (int) (i >>> 32);
//    y = x << 16;
//    if (y != 0) {
//        n = n - 16;
//        x = y;
//    }
//    y = x << 8;
//    if (y != 0) {
//        n = n - 8;
//        x = y;
//    }
//    y = x << 4;
//    if (y != 0) {
//        n = n - 4;
//        x = y;
//    }
//    y = x << 2;
//    if (y != 0) {
//        n = n - 2;
//        x = y;
//    }
//    return n - ((x << 1) >>> 31);
//}