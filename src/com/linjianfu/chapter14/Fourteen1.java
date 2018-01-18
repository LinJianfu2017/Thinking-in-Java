package com.linjianfu.chapter14;

import java.util.Arrays;

interface Hi {
}

interface Byby {
}

class Toy implements Hi {
    //    Toy() {       //使用Class.newInstance()来创建类，如果类中含有非默认构造器，则必须同时包含有非默认构造器。
//    }             //如若无非默认构造器，则缺省亦可。
//
//    Toy(int i) {
//
//    }
    interface Test {//怎么找到这个内部接口？？？没被使用的情况下。

        void test();
    }
}

class FancyToy extends Toy implements Byby, Toy.Test {
    @Override
    public void test() {

    }

    class InnerClass {//怎么找到这个内部类？没被使用的情况下。
    }

    FancyToy() {
//        super(1);//这里调用的是父类非默认构造器
    }
}

public class Fourteen1 {
    static void printInfo(Class c) {
        System.out.println("Class name: " + c.getName() + " is interface? [" + c.isInterface() + "]");
        System.out.println("Simple name: " + c.getSimpleName());
        System.out.println("Canonical name: " + c.getCanonicalName());
//        System.out.println("Method inside: " + Arrays.toString(c.getMethods()));
        System.out.println("Interface inside? " + Arrays.toString(c.getGenericInterfaces()));
        System.out.println("Inner classes: " + Arrays.toString(c.getClasses()));
        System.out.println();
    }

    public static void main(String[] args) {
        Class c = null;
        try {
//            c = Class.forName("FancyToy");//Can't find FancyToy

            c = Class.forName("com.linjianfu.chapter14.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class cc : c.getInterfaces())
            printInfo(cc);

//        Class c = new FancyToy();//Error
        Class up = c.getSuperclass();
        printInfo(up);
        for (Class cc : up.getInterfaces())
            printInfo(cc);

        // Unhanded exceptions:InstantiationException,IllegalAccessException
        // 故需置于try语句块中运行:
//        Object t=up.newInstance();
//        System.out.println(t);
        Object obj = null;
        try {
            obj = up.newInstance();

        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(9);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(9);
        }
//        printInfo(obj.getClass());
    }
}
