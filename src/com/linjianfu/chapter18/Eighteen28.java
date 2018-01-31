package com.linjianfu.chapter18;

import java.io.*;

/**
 * 注释掉默认构造器,readObject(), error：no valid constructor
 * 这下必须显式定义了？与书里不符，
 * 并不能"if no constructors are defined,so don't need."
 */
class Blip1 implements Externalizable {
//    public Blip1() {
//        System.out.println("Blip1()");
//    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip1 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1 readExternal");
    }
}

class Blip2 implements Externalizable {
//    public Blip2() {
//        System.out.println("Blip2()");
//    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2 writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2 readExternal");
    }
}

public class Eighteen28 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Eighteen28.out"));
        System.out.println("Writing: ");
        out.writeObject(blip1);
        out.writeObject(blip2);
        out.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Eighteen28.out"));
        System.out.println("Reading: ");
        blip1 = (Blip1) in.readObject();
        blip2 = (Blip2) in.readObject();
        in.close();
    }
}
