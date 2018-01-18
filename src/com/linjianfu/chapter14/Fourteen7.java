package com.linjianfu.chapter14;

import java.util.Arrays;

/**
 * 《cmd 文件索引机制，缺少一个“如果文件找不到，不妨再试试路径重组（剔除重名部分）再索引”的补丁》。
 * <p>
 * 因为以下问题极有可能就是因此缺陷导致：
 * <p>
 * 问题一：cmd下运行javac、Java；程序包含包名的情况下，在.Java文件直属的包目录下（如：
 * 此处的chapter14下），有时编译可以通过，但传入参数时却：“找不到或无法加载主类 XXX”。
 * 解决办法：
 * 法一、删除程序里的包名（package行），OK；
 * 法二、不删除package的情况下，请将索引路径退回到完整包名所在的目录下（如：索引到此处的src下），OK。
 * <p>
 * 问题二：问题二是由问题一的不同解法选择引起的：IDE下运行Java程序，Class.forName()传入的文件名String
 * 参数需要完整的类索引路径，如"com.linjianfu.chapter14.类名"；而在cmd下运行时情况就不一样了：
 * 若采用上述法一，则直接String="类名"即可，
 * 若是法二，则需String="com.linjianfu.chapter14.类名"，即同IDE运行要求.
 * <p>
 * Cause猜想：路径索引机制只是“笨笨地”将运行过程中所获得的路径“String”简单的拼接在一起再拿去索引导致的。
 * 这么“强大的脑”为何不动动？
 */
public class Fourteen7 {
    private static class Txt {
        public static void main(String[] args) {
            Fourteen7.main(new String[]{"Candy", "Gum"});
        }
    }

    public static void main(String[] args) {
        String name = Arrays.toString(args).replaceAll("(.*\\s+)|\\W+", "");
        try {
            Class.forName("com.linjianfu.chapter14." + name);
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find " + name);
        }
//        System.out.println(Arrays.toString(new String[]{"ss", "fsf", "fef"}));
    }
}

class Candy {

    static {
        System.out.println("Loading Candy");
    }
}

class Gum {

    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {

    static {
        System.out.println("Loading Cookie");
    }
}

