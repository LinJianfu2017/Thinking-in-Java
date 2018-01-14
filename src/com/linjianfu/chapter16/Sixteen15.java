package com.linjianfu.chapter16;

import net.mindview.util.CollectionData;
import net.mindview.util.Generated;
import net.mindview.util.Generator;

import java.lang.reflect.Array;
import java.util.Arrays;

class BerylliumSphereGenerator implements Generator<BerylliumSphere> {
    @Override
    public BerylliumSphere next() {
        return new BerylliumSphere();
    }
}

public class Sixteen15 {
    @SuppressWarnings("unchecked")
    private static <T> T[] array(Class<T> type, Generator<T> gen, int size) {
        T[] t = (T[]) Array.newInstance(type, size);
        return new CollectionData<T>(gen, size).toArray(t);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array(BerylliumSphere.class, new BerylliumSphereGenerator(), 3)));
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[3];
        System.out.println(Arrays.asList(Generated.array(berylliumSpheres, new BerylliumSphereGenerator())));
    }
}
