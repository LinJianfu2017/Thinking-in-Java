package com.linjianfu.chapter18;

import java.io.*;

//Ex 15,16
public class Eighteen15 {
    static String file16 = "Ex16.dat";

    public static void main(String[] args) throws IOException {
        DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("Data.txt")));
        System.out.println("Initial,,out.size() = " + out.size());
        out.write((int) 255);
        byte[] bytes = {0, 1, 2, 3};
        out.write(bytes, 0, 3);
        out.write(bytes);
        out.writeDouble(3.14159);
        out.writeBoolean(false);
        out.writeByte((int) 1000);
        out.writeBytes((String) "hi");
        out.writeChar(120);
        out.writeChars("hi");
        out.writeFloat(0.618f);
        out.writeInt(47);
        out.writeLong(123456789L);
        out.writeShort(520);
        out.writeUTF("Beautiful");
        System.out.println("After writing,out.size() = " + out.size());
        out.close();
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(new FileInputStream("Data.txt")));
        System.out.println("Reading:");
        System.out.println("in.read()" + in.read());
        byte[] bytes1 = new byte[3];
        System.out.println("byte[] " + in.read(bytes1, 0, 3));
        for (int i = 0; i < bytes1.length; i++)
            System.out.print(bytes1[i] + " ");
        System.out.println();
        System.out.println("Read next 4 bytes as int: " + in.readInt());
        System.out.println("in.readDouble()" + in.readDouble());
        System.out.println("in.readBoolean()" + in.readBoolean());
        System.out.println("in.readByte()" + in.readByte());
        System.out.println("in.read()" + in.read());
        System.out.println("in.read()" + in.read());
        System.out.println("in.readChar()" + in.readChar());
        System.out.println("in.readChar()" + in.readChar());
        System.out.println("in.readChar()" + in.readChar());
        System.out.println("in.readFloat()" + in.readFloat());
        System.out.println("in.readInt()" + in.readInt());
        System.out.println("in.readLong()" + in.readLong());
        System.out.println("in.readShort()" + in.readShort());
        System.out.println("in.readUTF()" + in.readUTF());
        in.close();
        RandomAccessFile raf = new RandomAccessFile(file16, "rw");
        //Ex16,unfinished:
    }
}
