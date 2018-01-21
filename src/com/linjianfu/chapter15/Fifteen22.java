package com.linjianfu.chapter15;

import java.lang.reflect.InvocationTargetException;

public class Fifteen22 {
    public static Object createNew(String s, Object... args) throws
            IllegalAccessException, InstantiationException, ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException {
        switch (args.length) {
            case 1:
                return Class.forName(s).getConstructor(args[0].getClass())
                        .newInstance(args[0]);
            case 2:
                return Class.forName(s).getConstructor(args[0].getClass(),
                        args[1].getClass()).newInstance(args[0], args[1]);
        }
        System.out.println("args exception");
        return null;
    }

    public static void main(String[] args) {
        try {
            createNew("com.linjianfu.chapter15.Ex22", "HelloWorld");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Ex22<T> {

    public Ex22() {
    }

    public Ex22(String s) {
        System.out.println(s);
    }


}