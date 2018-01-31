package com.linjianfu.chapter18;

import java.io.*;
import java.util.Random;

public class Eighteen27 {
    private static class SerializableImp1 implements Serializable {
        private int n;

        public SerializableImp1(int n) {
            this.n = n;
        }

        @Override
        public String toString() {
            return Integer.toString(n);
        }
    }

    private static class SerializableImp2 implements Serializable {
        private static Random rand = new Random(47);
        private SerializableImp1[] imp1s = {
                new SerializableImp1(rand.nextInt(20)),
                new SerializableImp1(rand.nextInt(20)),
                new SerializableImp1(rand.nextInt(20)),
        };
        private SerializableImp2 next;
        private char c;

        public SerializableImp2(int i, char c) {
            System.out.println("SerializableImp2 constructor: " + i);
            this.c = c;
            if (--i > 0)
                next = new SerializableImp2(i, (char) (c + 2));
        }

        public SerializableImp2() {
            System.out.println("Default constructor");
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(":");
            sb.append(c).append("(");
            for (SerializableImp1 imp1 : imp1s) sb.append(imp1);
            sb.append(")");
            if (next != null)
                sb.append(next);
            return sb.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "serializableImp.out";
        SerializableImp2 imp2 = new SerializableImp2(7, 'g');
        System.out.println(imp2);
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName));
        long start = System.nanoTime();
        out.writeObject("storage\n");
        out.writeObject(imp2);
        out.close();
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName));
        String s = (String) in.readObject();
        SerializableImp2 imp21 = (SerializableImp2) in.readObject();
        System.out.println(System.nanoTime() - start);
        System.out.println(s + "  imp2= " + imp21);

        //It's much faster than above.
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream out2 = new ObjectOutputStream(bout);
        start = System.nanoTime();
        out2.writeObject("storage\n");
        out2.writeObject(imp2);
        out2.flush();
        ObjectInputStream in2 = new ObjectInputStream(
                new ByteArrayInputStream(bout.toByteArray()));
        s = (String) in2.readObject();
        imp21 = (SerializableImp2) in2.readObject();
        System.out.println(System.nanoTime() - start);
        System.out.println(s + "  imp2= " + imp21);
    }
}
