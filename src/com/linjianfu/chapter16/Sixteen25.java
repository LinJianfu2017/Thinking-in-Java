package com.linjianfu.chapter16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Sixteen25 {

    public static void main(String[] args) {
        List<Integer> alist = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println(alist.getClass());
        System.out.println(alist);
        System.out.println(alist.get(4));
        alist.add(6);
        alist.addAll(Arrays.asList(7, 8));
        System.out.println(alist);
        List<Integer> list1 = alist.subList(2, 4);
        MyList<Integer> myList = new MyList<>(alist);
        System.out.println(myList.getReversed().myList);

    }
}

class MyList<T> extends ArrayList<T> {
    List<T> myList = new ArrayList();

    MyList(List list) {
        myList = list;
    }

    MyList getReversed() {
        ListIterator<T> listIterator = myList.listIterator(myList.size());
        List<T> reverseMyList = new ArrayList<>();
        while (listIterator.hasPrevious())
            reverseMyList.add(listIterator.previous());
        return new MyList(reverseMyList);
    }
}
