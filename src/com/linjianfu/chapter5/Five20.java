package com.linjianfu.chapter5;

//去除中文，注释包名，Cmder测试OK。
public class Five20 {
    public static void main(String... args) {
        System.out.println("创建一个使用可变参数列表而不是普通的main()语法的main()");
        System.out.println("并用各种不同数量的命令行参数里测试它");
        for (String s : args)
            System.out.println(s + " ");
        System.out.println();
    }

}
