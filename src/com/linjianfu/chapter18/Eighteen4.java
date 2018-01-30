package com.linjianfu.chapter18;

import net.mindview.util.Directory;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Eighteen4 {
    public static void main(String[] args) throws Exception {
        long sum = 0;

        String[] input = new BufferedReader(
                new InputStreamReader(System.in)).readLine().split("\\s+");
        System.out.println(input.length);
        System.out.println(Arrays.toString(input));
        if (input.length == 0) {
            System.out.println("input.length = 0");
            for (File file : Directory.walk(".").files) {
                sum += file.length();
            }
        } else for (String regex : input) {
            for (File file : Directory.walk(".", regex)) {
                System.out.print(file + ": ");
                System.out.println(file.length());
                sum += file.length();
            }
        }
        System.out.println("Total size: " + sum);
    }
}
