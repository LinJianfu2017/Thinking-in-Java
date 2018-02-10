package com.linjianfu.chapter20;

import java.util.LinkedList;

//Ex 4,6.
public class Twenty4 {
    private static int counter = 0;
    private final int id = counter++;
    LinkedList<String> testObject = new LinkedList<>();

    @Test
    void initialization() {
        assert testObject.isEmpty();
        System.out.println(id + ": initialization()");
    }

    @Test
    void _contains() {
        testObject.add("one");
        assert testObject.contains("one");
        System.out.println(id + ": _contains()");
    }

    @Test
    void _remove() {
        testObject.add("two");
        assert testObject.remove("one");
        assert testObject.remove("two");
        System.out.println(id + ": _remove()");
    }

    public static void main(String[] args) throws Exception {
        //报错，不知原因：
//        OSExecute.command("java com.linjianfu.chapter20.AtUnit Twenty4");
        //Bad tag 0, 什么字段的字节码int值是0？
        AtUnit.main(new String[]{"out/production/test1/com/linjianfu/chapter20/Twenty4"});
    }
}
