package com.linjianfu.chapter5;

public class Five19 {
    static void test19(String... s) {
        System.out.println("test19");
        for (String ss : s)
            System.out.print(" " + ss);
        System.out.println();
    }

    public static void main(String[] args) {
        test19("wo", "shi", "zhu");
        test19(new String[]{"ni", "ye", "shi", "zhu",});
        Other.main(new String[]{"1", "2", "3"});
        /**
         * 如下注释行所示，该形式用于当Other.main()参数为"String...args",则OK。
         * ---------------------------------------why??
         * ---------------列表可接受数组，反过来数组不能接受列表？
         *
         * */
//        Other.main("4","5","6");
    }

}

class Other {
    public static void main(String[] args) {
        System.out.println("Other main():");
        for (String s : args)
            System.out.print(s + " ");
        System.out.println();
    }
}