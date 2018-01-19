package com.linjianfu.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Fourteen25 {
    public static void doNot(Class<?> c) {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            try {
                method.invoke(c.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Arrays.toString(methods));

        Field[] fields = c.getDeclaredFields();
        System.out.println(Arrays.toString(fields));

        Constructor[] constructors = c.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));
    }
    //........................And so on.
}
