package com.linjianfu.chapter4;

public class Four5 {
    /**
     * 输出指定位数的末位为0或者1的交替二进制数
     *
     * @param factor 末位因子，取0或1
     * @param digit  指定二进制位数，不超过32位（int型）
     * @return 调用返回的是十进制形式的结果
     */
    static int alternatebinary(int factor, int digit) {
        int s = 0;
        for (int i = 0; i < digit; i++) {
            s = s + (int) Math.pow(2, i) * ((i + factor) % 2);
        }
        return s;
    }

    /**
     * 用三元操作符和按位操作符来显示二进制的1和0
     *
     * @param q 交替二进制数
     */
    static void binaryPrint(int q) {
        if (q == 0) System.out.print(0);
        else {
            int nlz = Integer.numberOfLeadingZeros(q);
            q <<= nlz;
            for (int p = 0; p < 32 - nlz; p++) {
                int n = (Integer.numberOfLeadingZeros(q) == 0) ? 1 : 0;
                System.out.print(n);
                q <<= 1;
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(alternatebinary(0, 16)));
        System.out.println(Integer.numberOfTrailingZeros(6) + "=" + Integer.toBinaryString(6));


        int i = 1 + 4 + 16 + 64;
        int j = 2 + 8 + 32 + 128;
        int k = 0x100;
        int m = 0;
        System.out.println("Using Integer.toBinaryString():");
        System.out.println("i = " + Integer.toBinaryString(i));
        System.out.println("j = " + Integer.toBinaryString(j));
        System.out.println("k = " + Integer.toBinaryString(k));
        System.out.println("m = " + Integer.toBinaryString(m));
        System.out.println("i & j = " + (i & j) + " = " + Integer.toBinaryString(i & j));
        System.out.println("i | j = " + (i | j) + " = " + Integer.toBinaryString(i | j));
        System.out.println("i ^ j = " + (i ^ j) + " = " + Integer.toBinaryString(i ^ j));
        System.out.println("~i = " + Integer.toBinaryString(~i));
        System.out.println("~j = " + Integer.toBinaryString(~j));
        System.out.println("Using binaryPrint():");
        System.out.print("i = " + i + " = ");
        binaryPrint(i);
        System.out.print("j = " + j + " = ");
        binaryPrint(j);
        System.out.print("k = " + k + " = ");
        binaryPrint(k);
        System.out.print("m = " + m + " = ");
        binaryPrint(m);
        System.out.print("i & j = " + (i & j) + " = ");
        binaryPrint(i & j);
        System.out.print("i | j = " + (i | j) + " = ");
        binaryPrint(i | j);
        System.out.print("i ^ j = " + (i ^ j) + " = ");
        binaryPrint(i ^ j);
        System.out.print("~i = " + ~i + " = ");
        binaryPrint(~i);
        System.out.print("~j = " + ~j + " = ");
        binaryPrint(~j);
    }

}


