package com.linjianfu.chapter12;

public class Twelve5 {
    public static void main(String[] args) {
        int[] ints = new int[]{666};
        int index = 3;
        while (true) {
            try {
                System.out.println(ints[index--]);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException");
            } finally {
                System.out.println("Well you?");
            }
        }
        System.out.println("Yeah!");
    }
}
