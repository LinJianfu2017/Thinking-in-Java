package com.linjianfu.chapter4;

import java.util.Arrays;

public class Four4 {
    public static void main(String[] args) {
        int range=100,k=0;
        int[] prime=new int[range];
        for (int i = 2; i <=range; i++) {
            int count = 0;
            for (int j = 1; j <(i+2)/2; j++) {
                if (i % j == 0) count++;
            }
            if (count==1) prime[k++]=i;
        }
        System.out.println("prime=" + Arrays.toString(Arrays.copyOfRange(prime,0,k)));
    }
}
