package com.linjianfu.chapter18;

import java.util.Arrays;

//Eighteen 2,3.
public class Eighteen2 {
    public static void main(String[] args) {
        String name = "src\\com\\linjianfu\\chapter16";
//        System.out.println(Arrays.toString(
//                new SortedDirList(name).list));
        System.out.println(Arrays.toString(
                new SortedDirList(name).list(".+[23]\\..+")));
        //test:
//        System.out.println(new File("src\\com\\linjianfu\\chapter18\\Eighteen2.java").length());
//        File path = new File(name);
//        System.out.println(path.length());
//        System.out.println(new File(name).length());
//        for (File file : path.listFiles())
//            System.out.println(file.length());
    }

}
