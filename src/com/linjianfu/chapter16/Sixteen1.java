package com.linjianfu.chapter16;

import java.util.ArrayList;
import java.util.Arrays;

//Exercise 1,11,18.
class BerylliumSphere {
    private static long counter = 0;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Sphere " + id;
    }
}

/**
 * 以下表明，
 * 一、泛型方法接受的是包装器类型参数；
 * 二、基本类型的包装器类型的数组初始化，数组元素均当做对象来处理，默认初始化值为null；
 * 而基本类型数组则不然：数值型-->0 or 0.0，boolean-->false，char-->O(it's a char 'O'，
 * 但是以下验证结果是空字符（不是空格符！），咋回事？书里错了？P436)等等。
 * <p>
 * 三、Arrays.toString()和Arrays.asList()的区别：
 * 前者方法内部通过创建一个StringBuffer对象并由String.valueOf()调用数组对象的
 * toString方法来填充，最终返回一个“整合”后的String;
 * 查类库调用轨迹，后者接受的是一个泛型数组，再将输入的数组作为参数导入到一个Arrays类私有
 * 的ArrayList类（该私有类内继承自AbstractList类）对象当中，包装并返回为List对象，所以
 * 如果是输入的是基本类型的数组（数组不会自动包装或拆包，也不能强制转型，数组元素才有可能），
 * 打印结果是一个List对象地址？，即地址引用（以下运行结果确实也是这样）。
 */
public class Sixteen1 {
    public static <T> void test(T[] a) {
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.asList(a));//打印的是对象.toString()内容。
    }

//    public static <T extends Number> void test1(T[] a) {
//        System.out.println(Arrays.asList(a));
//    }

    public static void txtdouble(double[] d) {
        System.out.println(Arrays.toString(d));
        System.out.println(Arrays.asList(d));//打印地址
    }

    public static void txtboolean(boolean[] booleans) {
        System.out.println(Arrays.toString(booleans));
        System.out.println(Arrays.asList(booleans));//打印出一个地址
    }

    public static void txtchar(char[] chars) {
        char[] c = chars;
        System.out.println(Arrays.toString(c));
        System.out.println(Arrays.asList(c));//打印出一个地址
        System.out.println(new ArrayList<>(Arrays.asList(c)));//打印出一个地址
    }

    public static void txtInteger(Integer[] integers) {
        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.asList(integers));
        /**
         * OK，打印的是对象内容，这里接受的是基本类型的包装器类型数组;
         * 说明什么？
         * */

    }

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        //Dynamic aggregate initialization.
        test(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()});
        test(new Integer[]{new Integer(0), new Integer(1)});
        test(new Double[2]);
        test(new Boolean[2]);
        test(new Character[2]);
        txtdouble(new double[2]);
        txtboolean(new boolean[2]);
        txtchar(new char[2]);
        int[] i = new int[2];
        i[0] = new Integer(1);
        System.out.println(i.getClass().getSimpleName());
//        System.out.println(i[0] instanceof int);//Inconvertible(不可转换/变换/兑换的；不可逆的) types：cannot cast 'int' to 'int'.
        Integer[] l = new Integer[2];
        l[0] = (int) 3;
        System.out.println(l[0] instanceof Integer);
//        l = i;/数组本身是不能自动包装的。
        int[] k = new int[5];
        Arrays.fill(k, 66);
//        System.arraycopy(l, 0, k, 0, i.length);//ArrayStoreException//数组不能自动包装或拆包。
//        System.arraycopy(i, 0, k, 0, k.length);//ArrayIndexOutOfBoundsException
        Arrays.fill(i, 2233);
//        System.arraycopy(i, 1, k, 0, i.length);//ArrayIndexOutOfBoundsException
        System.arraycopy(i, 0, k, 0, i.length);
        System.out.println(Arrays.toString(i) + "   " + Arrays.toString(k));
        System.arraycopy(k, 2, i, 0, i.length);
        System.out.println(Arrays.toString(i) + "   " + Arrays.toString(k));

        txtInteger(l);
        Object[] objects = new Object[2];
//        (BerylliumSphere[]) objects=new BerylliumSphere[2];//Error
        /**
         * ClassCastException: [Ljava.lang.Object; cannot be cast to [Lcom.linjianfu.chapter16.BerylliumSphere;
         * **/
//        BerylliumSphere[] b=(BerylliumSphere[])new Object[2];
//        Arrays.fill(b,new BerylliumSphere());
    }
}
