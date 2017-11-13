package com.linjianfu.chapter4;
//Exercise 2,3.

import java.util.Arrays;
import java.util.Random;

public class Four2 {
    public static void main(String[] args) {
        int rand[] = new int[30];
        String[] relation = new String[30];
//        while (true){
        for (int j = 0; j < 25; j++) {
            rand[j] = new Random().nextInt(100);
            if (j > 0) {
                if (rand[j - 1] > rand[j])
                    relation[j - 1] = "大于";
                else if (rand[j - 1] < rand[j])
                    relation[j - 1] = "小于";
                else relation[j - 1] = "等于";
            }
        }
        System.out.println(rand[23] + "    " + rand[24]);
        System.out.println(relation[23] + "    " + relation[24]);
        System.out.println(Arrays.toString(rand) + rand.length);
        System.out.println(Arrays.toString(relation) + relation.length);

    }
//}
}
