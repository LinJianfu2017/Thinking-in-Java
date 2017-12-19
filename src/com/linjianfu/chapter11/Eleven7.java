package com.linjianfu.chapter11;

import java.util.ArrayList;
import java.util.List;

public class Eleven7 {
    public static List<Eleven7> makeEleven7(int n) {
        List<Eleven7> eleven7List = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            eleven7List.add(new Eleven7());
        }
        return eleven7List;
    }

    private static int counter = 0;
    private final int id = counter++;

    @Override
    public String toString() {
        return String.valueOf(id);
    }

    public static void main(String[] args) {
//        List<Eleven7> eleven7List = makeEleven7(7);
        Eleven7[] eleven7s = new Eleven7[10];
        for (int i = 0; i < eleven7s.length; i++)
            eleven7s[i] = new Eleven7();
        List<Eleven7> eleven7List = new ArrayList<>();
        for (Eleven7 e : eleven7s)
            eleven7List.add(e);
        System.out.println("List of Eleven7: " + eleven7List);
        List<Eleven7> sub = eleven7List.subList(1, 6);
        System.out.println("subList: " + sub);
        eleven7List.removeAll(sub);
        System.out.println("List of Eleven7: " + eleven7List);
    }
}
