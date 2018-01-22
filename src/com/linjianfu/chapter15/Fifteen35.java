package com.linjianfu.chapter15;

import util.coffee.Breve;
import util.coffee.Coffee;
import util.coffee.Latte;
import util.coffee.Mocha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fifteen35 {
    @SuppressWarnings("unchecked")
    private static void oldStyleMethod(List probablyBreve) {
        probablyBreve.add(new Latte());
    }

    public static void main(String[] args) {
        List<Breve> breveList = new ArrayList<>();
        oldStyleMethod(breveList);
        List<Breve> breveList1 = Collections.
                checkedList(breveList, Breve.class);
        try {
            oldStyleMethod(breveList1);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }
        List<Coffee> coffeeList = Collections.checkedList(
                new ArrayList<Coffee>(), Coffee.class);
        oldStyleMethod(coffeeList);
        coffeeList.add(new Mocha());
        System.out.println("over");
    }
}
