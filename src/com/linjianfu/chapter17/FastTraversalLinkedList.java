package com.linjianfu.chapter17;

import java.util.*;

public class FastTraversalLinkedList<E> {
    private LinkedList<E> lList = new LinkedList<>();
    private ArrayList<E> aList = new ArrayList<>();

    private ArrayList<E> toArrayList(LinkedList<E> lList) {
        aList.clear();
        aList.addAll(lList);
        lList.clear();
        return aList;
    }

    private LinkedList<E> toLinkedList(ArrayList<E> aList) {
        lList.clear();
        lList.addAll(aList);
        aList.clear();
        return lList;
    }

    public int size() {
        return aList.size() < lList.size() ? lList.size() : aList.size();
    }

    public void clear() {
        if (aList.size() < lList.size())
            lList.clear();
        else
            toLinkedList(aList).clear();
    }

    public void add(E e) {
        if (aList.size() < lList.size())
            lList.add(e);
        else
            toLinkedList(aList).add(e);
    }

    public void add(int i, E e) {
        if (aList.size() < lList.size())
            lList.add(i, e);
        else
            toLinkedList(aList).add(i, e);
    }

    public boolean addAll(Collection<? extends E> c) {
        if (aList.size() < lList.size())
            return lList.addAll(c);
        else
            //addAll()LinkedList也快？不都System.arrayCopy()么
            //ArrayList是，LinkedList不是。那不应该用前者？
            //从结果看：size大的时候（10000）差不多，不稳定，小的时候LinkedList确实强些。
            return toLinkedList(aList).addAll(c);
    }

    public void addFirst(E e) {
        if (aList.size() < lList.size())
            lList.addFirst(e);
        else
            toLinkedList(aList).addFirst(e);
    }

    public void addLast(E e) {
        if (aList.size() < lList.size())
            lList.addLast(e);
        else
            toLinkedList(aList).addLast(e);
    }

    public E set(int i, E e) {
        if (lList.size() < aList.size())
            return aList.set(i, e);
        else
            return toArrayList(lList).set(i, e);
    }

    public E remove(int i) {
        if (aList.size() < lList.size())
            return lList.remove(i);
        else
            return toLinkedList(aList).remove(i);
    }

    public E removeFirst() {
        if (aList.size() < lList.size())
            return lList.removeFirst();
        else
            return toLinkedList(aList).removeFirst();
    }

    public E removeLast() {
        if (aList.size() < lList.size())
            return lList.removeLast();
        else
            return toLinkedList(aList).removeLast();
    }

    public E get(int i) {
        if (lList.size() < aList.size())
            return aList.get(i);
        else
            return toArrayList(lList).get(i);
    }

    public Iterator<E> iterator() {
        if (lList.size() < aList.size())
            return aList.iterator();
        else
            return toArrayList(lList).iterator();
    }

    public ListIterator<E> listIterator() {
        if (aList.size() < lList.size())
            return lList.listIterator();
        else
            return toLinkedList(aList).listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        if (aList.size() < lList.size())
            return lList.listIterator(i);
        else
            return toLinkedList(aList).listIterator(i);
    }

    public String toString() {
        return aList.size() > lList.size() ? aList.toString() :
                lList.size() == 0 ? aList.toString() : lList.toString();
    }

    public static void main(String[] args) {
        Seventeen33.main(args);
    }
}
/**
 * ------------------ FastTraversalLinkedList ------------------
 * size     add     get     set iteradd  insert  remove  addAll
 * 10     102      13      15      18     208     251     628
 * 100      25      13      13      12     118      41    1004
 * 1000      37      12      12      70      55      82    9485
 * 10000      19      20      17      25      89      24  163789
 * -------------------- Queue tests --------------------
 * size    addFirst     addLast     rmFirst      rmLast
 * 10         104         111         126         130
 * 100          34          34          32          72
 * 1000          14          16          21          20
 * 10000          12          12          18          15
 * <p>
 * Process finished with exit code 0
 */