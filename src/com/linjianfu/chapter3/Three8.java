package com.linjianfu.chapter3;

//Exercise 8,9,10,11,12 and 13,Chaptor Three.
public class Three8 {
    int alternatebinary(int factor) {
        int s = 0;
        for (int i = 0; i < 31; i++) {
            s = s + (int) Math.pow(2, i) * ((i + factor) % 2);//不使用条件语句，还有更简便的二进制开关吗？
//            factor=~factor;//实际为补全取反，故不可取。
//            System.out.println("s=" + s + ",factor=" + factor + ",i=" + i + ",qiuyu=" + (i + factor) % 2);//测试用
        }
        return s;

    }

    void char2binary(char c) {
        System.out.println(c + "'s binary format is:" + Integer.toBinaryString(c));
    }

    public static void main(String[] args) {
        long l1 = 0x123abc, l2 = 0123;
        System.out.println("l1:" + Long.toBinaryString(l1));
        System.out.println("l2:" + Long.toBinaryString(l2));
        double maxd = Double.MAX_VALUE, mind = Double.MIN_VALUE;
        System.out.println("Max and min double value are the:" + maxd + "and" + mind);
        float maxf = Float.MAX_VALUE, minf = Float.MIN_VALUE;
        System.out.println("Max and min float value are the:" + maxf + "and" + minf);
//        Three8 constant1 = new Three8(), constant2 = new Three8();
//        int c1 = constant1.alternatebinary(0), c2 = constant2.alternatebinary(1);//繁杂、、
//        Three8 constant = new Three8();
        int c1 = new Three8().alternatebinary(0), c2 = new Three8().alternatebinary(1);
        System.out.println("c1=" + c1 + "=" + Integer.toBinaryString(c1));
        System.out.println("c2=" + c2 + "=" + Integer.toBinaryString(c2));
        System.out.println("~c1=" + (~c1) + "=" + Integer.toBinaryString(~c1));
        System.out.println("~c2=" + (~c1) + "=" + Integer.toBinaryString(~c2));
        System.out.println("c1&c2=" + Integer.toBinaryString(c1 & c2));
        System.out.println("c1|c2=" + Integer.toBinaryString(c1 | c2));
        System.out.println("c1^c2=" + Integer.toBinaryString(c1 ^ c2));
//        System.out.println("~c1=" + (~c1) + "=" + Integer.toBinaryString(~c1));
//        System.out.println("~c2=" + (~c1) + "=" + Integer.toBinaryString(~c2));
//        System.out.println("Test,Math.pow:"+(int) Math.pow(2, 3) + ",~xx=" + (~0));//验证用
//        int c12 = c1 ^ c2;
        int c12 = 0xFFFFFFFF;
//        for (int i = 0; i < 16; i++) {
            c12 = c12 << 16;
//            c12 = c12 >> 1;
            System.out.println("c12<<1=" + c12 + ",binary c12=" + Integer.toBinaryString(c12));

//        }
        for (int j = 0; j < 48; j++) {
//            int c11 = c1 >> 1;
//            System.out.println("c1>>1=" + c11 + ",binary c1=" + Integer.toBinaryString(c11));
            c12 = c12 >>> 1;//无符号右移，不论正负，高位插0。
//            c12 = c12 >> 1;
            System.out.println("c12>>>1=" + c12 + ",binary c12=" + Integer.toBinaryString(c12));


        }
        new Three8().char2binary('n');
        new Three8().char2binary('Q');

    }

}
