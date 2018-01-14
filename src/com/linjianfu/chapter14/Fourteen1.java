package com.linjianfu.chapter14;

class Toy {
//    Toy() {       //使用Class.newInstance()来创建类，如果类中含有非默认构造器，则必须同时包含有非默认构造器。
//    }             //如若无非默认构造器，则缺省亦可。
//
//    Toy(int i) {
//
//    }
}

class FancyToy extends Toy {

    FancyToy() {
//        super(1);//这里调用的是父类非默认构造器
    }
}

public class Fourteen1 {
    static void printInfo(Class c) {
        System.out.println("Class name: " + c.getName() + " is interface? [" + c.isInterface() + "]");
        System.out.println("Simple name: " + c.getSimpleName());
        System.out.println("Canonical name: " + c.getCanonicalName());
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
//        Class c = new FancyToy();//Error
        Class up = c.getSuperclass();
        printInfo(up);
//        Object t=up.newInstance();//需置于try语句块中运行
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
        printInfo(obj.getClass());
    }
}
