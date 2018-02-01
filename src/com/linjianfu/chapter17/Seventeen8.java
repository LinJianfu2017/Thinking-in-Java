package com.linjianfu.chapter17;


public class Seventeen8 {
    public static void main(String[] args) {
        SList<String> sList = new SList<>();
        System.out.println(sList);
        SList.SListIterator<String> sListIter = sList.iterator();
        sListIter.insert("sad");
        sListIter.insert("tired");
        sListIter.insert("oh Baby");
        sListIter.insert("come on");
        System.out.println(sList);
        SList.SListIterator<String> sListIter2 = sList.iterator();
        while (sListIter2.hasNext())
            sListIter2.remove();
        System.out.println(sList);


    }

}
