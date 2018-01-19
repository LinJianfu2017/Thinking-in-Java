package com.linjianfu.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

//Exercise 17,18,19,20.
public class Fourteen17 {
    private static Pattern p = Pattern.compile("native |final |(\\w+\\.)");

    //18:
    public Fourteen17() {
    }

    Fourteen17(int i) {
    }

    private Fourteen17(long l) {
    }

    float aFloat;
    public String astring;

    //20:
    public static void showInfo(String className) {
        int i = 0, j = 0, k = 0;
        try {
            Class<?> c = Class.forName(className);
            Field[] fields = c.getDeclaredFields();
            Method[] methods = c.getDeclaredMethods();
            Constructor[] constructors = c.getDeclaredConstructors();
            for (Field field : fields) {
                System.out.println(p.matcher(field.toString()).replaceAll(""));
                i++;
            }
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
                j++;
            }
            for (Constructor constructor : constructors) {
                System.out.println(p.matcher(constructor.toString()).replaceAll(""));
                k++;
            }
            System.out.println("Total:\n " + c.getSimpleName()
                    + " has " + i + " fields, " + j + " methods, " + k + " constructors.");
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + className);
        }
    }

    public static void main(String[] args) {
        showInfo("com.linjianfu.chapter14.Fourteen17");
        System.out.println("\n-----------------------------------------------------------\n");
        //19:
        String s = "util.pets.Pet";
        try {
            System.out.println(Class.forName(s).getDeclaredConstructor(
                    String.class).newInstance("------!@#$%^&*------ "));
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
