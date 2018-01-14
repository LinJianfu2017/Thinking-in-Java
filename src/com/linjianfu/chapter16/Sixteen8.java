package com.linjianfu.chapter16;

import net.mindview.util.CollectionData;
import net.mindview.util.Generator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sixteen8<T > {
    public static class BSphere implements Generator<BerylliumSphere> {
        public BerylliumSphere next() {
            return new BerylliumSphere();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] createArray1T(Class<? extends T> type, Generator<T> gen, int size) {
        T[] t = (T[]) Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(t);
    }

    //    @SuppressWarnings("unchecked")
//    public static <T> T[][] createArray2T(Class<? extends T> type, Generator<T> gen, int size1, int size2) {
//        T[][] result = (T[][]) new Object[size1][size2];
//        ArrayList<T> arrayList = new ArrayList<>();
//        for (int i = 0; i < size1; i++) {
//            result[i] = createArray1T(type, gen, size2);
//            arrayList.add(result[i])//add(T) in ArrayList cannot be applied to (T[]).
//        }
//        return result;
//    }
    @SuppressWarnings("unchecked")
    T[] a = (T[]) new Object[2];//能编译运行，但a只能用作object数组？？

    public static void main(String[] args) {
        BerylliumSphere[] b1 = createArray1T(BerylliumSphere.class, new BSphere(), 2);
        System.out.println(Arrays.asList(b1));
//        BerylliumSphere[][] b = createArray2T(BerylliumSphere.class, new BSphere(), 2, 2);
//        System.out.println(Arrays.asList(b));

        String[] sa = new String[]{"sss", "bbb"};
//        sa[0] = new Integer(0);//error:incompatible types
        Object[] oa = new Object[2];
        oa[0] = 1;
        oa[1] = 'a';
        System.out.println(oa[0].getClass() + "  " + oa[1].getClass());
        oa = sa;
        System.out.println(oa.getClass());
        Sixteen8 e = new Sixteen8();
        e.a[0] = oa[0];
        System.out.println(e.a[0]);
        /**
         * 下面给它插入泛型：
         * 插入元素时：runtime ClassCastException: [Ljava.lang.Object; cannot be cast to [Lcom.linjianfu.chapter16.BerylliumSphere;
         * 说明边界擦除到Object（为啥不是BerylliumSphere?）；
         * 然而，放入其他类型对象，又编译期报错。。。
         * Incompatible types,Found：int，Required:BerylliumSphere.
         * 这样一来，BerylliumSphere不是，Object也不是。说明废了已经。。。
         *
         * 那么，泛型参数化的数组到底想怎么样？
         * */
        Sixteen8<BerylliumSphere> e2 = new Sixteen8<>();
//        e2.a[0] = new BerylliumSphere();
////        e2.a[1]=1;//编译期类型检查报错，是错误，不是警告。Incompatible types,Found：int，Required:BerylliumSphere.
//        System.out.println(e2.a[0]);
    }
}
