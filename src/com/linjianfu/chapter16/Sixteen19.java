package com.linjianfu.chapter16;

//Exercise 19,24.
class Ex19 implements Comparable<Ex19> {
    int i;

    Ex19(int i) {
        this.i = i;
    }

    @Override
    public int compareTo(Ex19 o) {
        return this.i < o.i ? -1 : (this.i == o.i ? 0 : 1);
    }

    @Override
    public boolean equals(Object obj) {
        return obj.getClass().getSimpleName().equals("Ex19") && this.i == ((Ex19) obj).i;
    }
}

public class Sixteen19 {


    public static void main(String[] args) {
        Ex19[] a = {new Ex19(1)};
//        Ex19[] b = {new Ex19(1)};
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));
//        System.out.println(Arrays.equals(a, b));
//        System.out.println(a[0].getClass().getSimpleName() == "Ex19");
//        System.out.println("Ex19".equals(a[0].getClass().getSimpleName()));
//        int index = Arrays.binarySearch(a, new Ex19(3));
//        System.out.println("index " + index + ", " + a[index]);

        //逻辑有问题，整整：
        //s1、s2并没创建String对象，s3则是一个方法调用的引用，s4显式的new才创建了对象，
        //说明缺省了new还是有所不同的;从实现来看，new一个String是通过创建了一个char[];
        // 而基本类型char，看起来就像是"static"的，不管你是通过包装器型对象创建的还是直接
        //基本类型来的，它都会是“同一个人”!!
        //另外,关系运算符" == "，底层是什么逻辑？

        String s1 = "Ex19", s2 = "Ex19", s3 = a[0].getClass().getSimpleName(),
                s4 = new String("Ex19");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        char c1 = 'a', c2 = 'a', c3 = new Character('a');
        System.out.println((int) 'a');
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
    }
}
/**
 * *result:
 * F:\JAVA\jdk1.8.0_144\bin\java ...
 * Ex19
 * Ex19
 * true
 * false
 * false
 * 97
 * a
 * a
 * true
 * true
 * <p>
 * Process finished with exit code 0
 * <p>
 * *byte-code:
 * F:\JAVA\jdk1.8.0_144\bin\javap.exe -c com.linjianfu.chapter16.Sixteen19
 * Compiled from "Sixteen19.java"
 * public class com.linjianfu.chapter16.Sixteen19 {
 * public com.linjianfu.chapter16.Sixteen19();
 * Code:
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 * <p>
 * public static void main(java.lang.String[]);
 * Code:
 * 0: iconst_1
 * 1: anewarray     #2                  // class com/linjianfu/chapter16/Ex19
 * 4: dup
 * 5: iconst_0
 * 6: new           #2                  // class com/linjianfu/chapter16/Ex19
 * 9: dup
 * 10: iconst_1
 * 11: invokespecial #3                  // Method com/linjianfu/chapter16/Ex19."<init>":(I)V
 * 14: aastore
 * 15: astore_1
 * 16: ldc           #4                  // String Ex19
 * 18: astore_2
 * 19: ldc           #4                  // String Ex19
 * 21: astore_3
 * 22: aload_1
 * 23: iconst_0
 * 24: aaload
 * 25: invokevirtual #5                  // Method java/lang/Object.getClass:()Ljava/lang/Class;
 * 28: invokevirtual #6                  // Method java/lang/Class.getSimpleName:()Ljava/lang/String;
 * 31: astore        4
 * 33: new           #7                  // class java/lang/String
 * 36: dup
 * 37: ldc           #4                  // String Ex19
 * 39: invokespecial #8                  // Method java/lang/String."<init>":(Ljava/lang/String;)V
 * 42: astore        5
 * 44: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 47: aload_2
 * 48: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 * 51: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 54: aload_3
 * 55: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 * 58: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 61: aload_2
 * 62: aload_3
 * 63: if_acmpne     70
 * 66: iconst_1
 * 67: goto          71
 * 70: iconst_0
 * 71: invokevirtual #11                 // Method java/io/PrintStream.println:(Z)V
 * 74: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 77: aload_2
 * 78: aload         4
 * 80: if_acmpne     87
 * 83: iconst_1
 * 84: goto          88
 * 87: iconst_0
 * 88: invokevirtual #11                 // Method java/io/PrintStream.println:(Z)V
 * 91: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 94: aload_2
 * 95: aload         5
 * 97: if_acmpne     104
 * 100: iconst_1
 * 101: goto          105
 * 104: iconst_0
 * 105: invokevirtual #11                 // Method java/io/PrintStream.println:(Z)V
 * 108: bipush        97
 * 110: istore        6
 * 112: bipush        97
 * 114: istore        7
 * 116: new           #12                 // class java/lang/Character
 * 119: dup
 * 120: bipush        97
 * 122: invokespecial #13                 // Method java/lang/Character."<init>":(C)V
 * 125: invokevirtual #14                 // Method java/lang/Character.charValue:()C
 * 128: istore        8
 * 130: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 133: bipush        97
 * 135: invokevirtual #15                 // Method java/io/PrintStream.println:(I)V
 * 138: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 141: iload         6
 * 143: invokevirtual #16                 // Method java/io/PrintStream.println:(C)V
 * 146: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 149: iload         7
 * 151: invokevirtual #16                 // Method java/io/PrintStream.println:(C)V
 * 154: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 157: iload         6
 * 159: iload         7
 * 161: if_icmpne     168
 * 164: iconst_1
 * 165: goto          169
 * 168: iconst_0
 * 169: invokevirtual #11                 // Method java/io/PrintStream.println:(Z)V
 * 172: getstatic     #9                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 175: iload         6
 * 177: iload         8
 * 179: if_icmpne     186
 * 182: iconst_1
 * 183: goto          187
 * 186: iconst_0
 * 187: invokevirtual #11                 // Method java/io/PrintStream.println:(Z)V
 * 190: return
 * }
 * <p>
 * Process finished with exit code 0
 */
