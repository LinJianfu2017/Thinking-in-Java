package com.linjianfu.chapter13;

import java.util.Arrays;

//Exercise 8,9.
public class Thirteen8 {
    public static String k =
            "Then,when you have found the shrubbery,you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void split(String regex) {
        System.out.println(Arrays.toString(k.split(regex)));
    }

    public static void main(String[] args) {
        split("the|you");
        System.out.println(k.replaceAll("[aeiouAEIOU]", "_"));
    }
}
