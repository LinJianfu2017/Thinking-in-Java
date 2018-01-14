package com.linjianfu.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sixteen10 {
    private static class ArrayOfGenerics {
        //        @SuppressWarnings("unchecked")
        public static void main(String[] args) {
            List<String>[] ls;
            List[] la = new List[10];
            ls = (List<String>[]) la;
            ls[0] = new ArrayList<String>();
            //Compile-time checking produces an error:
//            ls[1]=new ArrayList<Integer>();

            Object[] objects = ls;
            objects[1] = new ArrayList<Integer>();
            List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[]) new List[10];

            for (int i = 0; i < spheres.length; i++)
                spheres[i] = new ArrayList<BerylliumSphere>(Arrays.asList(new BerylliumSphere()));
            System.out.println(Arrays.toString(spheres));


            List<List<String>> lls = new ArrayList<>();
            List<List> l = new ArrayList<>();
//            lls = (List<List<String>>) l;//error:inconvertible types,cannot cast...
            lls.add(new ArrayList<>());
            List<Object> lo = new ArrayList<>();
//            lo = lls;//incompatible types.

            /**
             * compile-time warning eliminated:
             * 以容器实现多维数组
             * */
            List<List<BerylliumSphere>> llb = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                llb.add(new ArrayList<>());
                for (int j = 0; j < 2; j++)
                    llb.get(i).add(new BerylliumSphere());
            }
            System.out.println(llb);
        }
    }
}
