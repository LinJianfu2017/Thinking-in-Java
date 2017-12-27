package com.linjianfu.chapter12;

/**
 * 关于try、finally以及置于它们之内的return三者之间的联系
 * <p>
 * try块和finally块有各自的操作数栈，用来保存“临时（暂且称为临时）”返回值，
 * 最终返回给invoker的结果取决于return语句发生的栈；
 * ***********************************
 * finally块可以看作是try块的subroutine,finally块始终排在try or catch块中的控制转移语句之前得到执行；
 * ***********************************
 * 发现，，不论如何，执行catch块之后，try块剩下的语句都不会被执行，
 * 因此catch块必须包含return语句（因返回值void而缺省是默认的情况）。
 */
public class Twelve2 {
    public static void main(String[] args) {
        System.out.println("main():\n" + test());
        System.out.println("***************************************");
        System.out.println("main():\n" + test2());
    }

    private static String test() {
        int i = 1;
        try {
            i = 4;
            System.out.println("try block");
            return test1() + ",  try__i=" + i;
        } finally {
            i++;
            System.out.println("finally block" + ",  finally__i++=" + i);
//            return "finally__i=" + i;
        }

    }

    private static String test2() {
        float j = 1;
        try {
            j = 2.222222f;
            System.out.println("try block,before f(), j=" + j);
            f();
            /**
             * 可以看出，执行catch之后,try块剩下的部分不会被执行
             * */
            System.out.println(test());
            System.out.println("try block,after f(), j=" + j);
            return "try block return statement";
        } catch (MyException e) {
//           e.printStackTrace();
            j = 3.333333f;
            System.out.println("catch block, j=" + j);
            return "catch block return statement BEFORE printStackTrace()";//Error：导致下句成为unreachable statement
//            e.printStackTrace(System.out);
//            return "catch block return statement AFTER printStackTrace()";
        } finally {
            j++;
            System.out.println("finally block, j=" + j);
        }
    }

    private static String test1() {
        System.out.println("return statement");
        return "after return";
    }

    private static void f() throws MyException {
        System.out.println("throwing MyException from f()");
        throw new MyException();
    }
}

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String string) {
        super(string);
    }
}
/**
 * 运行结果：
 * F:\JAVA\jdk1.8.0_144\bin\java ...
 * try block
 * return statement
 * finally block,  finally__i++=5
 * main():
 * after return,  try__i=4
 * **************************************
 * try block,before f(), j=2.222222
 * throwing MyException from f()
 * catch block, j=3.333333
 * finally block, j=4.333333
 * main():
 * catch block return statement BEFORE printStackTrace()
 * <p>
 * Process finished with exit code 0
 */
