package com.linjianfu.chapter18;

import java.io.*;

//use 'Externalizable' to selectively save and recover object member:
class Blip3 implements Externalizable {
    private int i;
    private String s;

    public Blip3() {
        System.out.println("Blip3()");
    }

    public Blip3(int i, String s) {
        System.out.println("Blip3(int i, String s)");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3 WriteExternal");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3 readExternal");
        s = (String) in.readObject();
//        i = in.readInt();
    }
}

public class Eighteen29 {
    public static void main(String[] args) throws Exception {
        Blip3 blip3 = new Blip3(47, "A string"),
                blip31 = new Blip3();
        System.out.println(blip3);
        System.out.println(blip31);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Eighteen29.out"));
        System.out.println("Writing: ");
        out.writeObject(blip3);
        out.writeObject(blip31);
        out.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Eighteen29.out"));
        System.out.println("Reading: ");
        blip3 = (Blip3) in.readObject();
        blip31 = (Blip3) in.readObject();
        System.out.println(blip3);
        System.out.println(blip31);
    }
}
