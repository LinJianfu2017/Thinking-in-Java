package com.linjianfu.chapter16;

import java.util.Arrays;

public interface Sixteen2 {
    public static BerylliumSphere[] arrayBerylliumSphere(int n) {
        BerylliumSphere[] results = new BerylliumSphere[n];
        Arrays.fill(results, new BerylliumSphere());
        /**
         * 看看结果是不是同个一对象的多个引用还是不然??
         * --->果然是。。
         * #[Sphere 0, Sphere 0, Sphere 0]
         * so，还用for循环？!
         * */

        return results;
    }

    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = arrayBerylliumSphere(3);
        System.out.println(Arrays.asList(berylliumSpheres));
    }
}
