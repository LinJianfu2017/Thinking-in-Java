package com.linjianfu.chapter5;

/**
 * Exercise 8,9.
 */
public class Five8 {
    private static int i = 0;
    private static char c = 'a';

    private void f1() {
        System.out.println("f1");
        /***   方法内部调用同一个类的另一个方法，不必使用this，可直接调用即可。
         *     this引用会自动应用于同一类中的其他方法。（编译器帮你自动添加）
         *     所以这里只是为了验证它是起作用的，你不应该在实践中使用这种方式。
         */
        this.f2();
        f2();

    }

    private void f2() {
        System.out.println("f2");
//        f1();
    }

    public static void main(String[] args) {
        new Five8().f1();
        new Constructor().f();

    }
}

class Constructor {
    private int i1 = 0;

    Constructor() {
        /***  构造器必须放在字段段首，否则编译器将出错。why?
         *    尽管可以用this调用一个构造器，但却不能调用两个，
         *    下面的注释部分“this(8);”即第二个调用，编译器将会报错。
         *    如此似乎也佐证了构造器必须放在段首的要求。
         **/
        this(88);
//        this(8);
        this.i1 = 666;
//        Constructor(8);
        System.out.println("1111");

    }

    Constructor(int i) {
        System.out.println("2222");
        i1 = i;
    }

    void f() {
        /**
         * 除构造器外，编译器禁止在其他任何方法中调用构造器。
         */
//        this(11);
        System.out.println("constructor");
    }
}