package com.linjianfu.chapter14;

import java.util.Arrays;

//Exercise 8,9,10.

/**
 * 下面的while咋了？？？
 * 答：在while里面递归while循环所在的方法，待递归完，回去继续while。。。
 * 但是，又发现，最后while循环的条件是递归条件不满足的前一次的条件（即循环的是最后一次满足条件的状态），
 * 这么说，前面被递归“占用”时的while状态被覆盖了？
 * <p>
 * 至于为何会用while？
 * 答：我之前不是用递归，就是在方法里面while到底的，但是代码多了几行，
 * 后面看了参考答案用的递归，就改递归了，但是while没改掉.....
 * <p>
 * 基本类型不是对象？
 * 书p318：
 * 但是它们有.class文件,如boolean.class/int.class，
 * 它们的包装器类型也有:Boolean.TYPE/Integer.TYPE.
 * “TYPE字段是一个引用，指向基本数据类型的Class对象”。
 */
public class Fourteen8 {
    public static void getClassInfo(Class c) throws ClassNotFoundException {
        //while有问题啊啊啊，get到Object也不管，一直循环,所以改用if
        System.out.println(c == null);
        if (c != null) {
            System.out.println(c.getSimpleName());
            System.out.println("Fields inside: ");
            System.out.println(Arrays.toString(c.getDeclaredFields()));
            getClassInfo(c.getSuperclass());
        }
    }

    static int j = 9;

    static void id() {
        while (j-- > 0) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        id();
        try {
            getClassInfo(ACircle.class);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        //ex9
        char c = 'c';//c is not a object,基本类型不是对象.
//        System.out.println(c.getClass().getSimpleName());
//        System.out.println(c.getClass().getSuperclass());
//        System.out.println(c instanceof Object);
        char[] chars = new char[2];//基本类型数组是对象
        System.out.println(chars.getClass().getSimpleName());
        System.out.println(chars.getClass().getSuperclass());
        System.out.println(chars instanceof Object);
        Character[] characters = new Character[2];
        System.out.println(characters.getClass().getSimpleName());
        System.out.println(characters.getClass().getSuperclass());
    }
}
