package com.linjianfu.chapter5;
//Exercise 13,14.

/**
 * 显式的？静态初始化：
 * 当首次生成这个类的一个对象时，或者
 * 首次访问属于那个类的静态数据成员时（即使从未生成过那个类的对象），
 * 该类的所有静态初始化都会被执行，并且静态初始化动作只进行一次。
 * （非静态则不然,存在被调用才会进行初始化，并且似乎每次调用都会相应再次进行初始化）
 * <p>
 * * 初始化顺序：先静态对象（如果它们尚未因前面的对象创建过程或<静态方法调用>而被初始化），后非静态对象。
 */
class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

/**
 * 在类的内部，变量定义的先后顺序决定了初始化顺序。
 * 即使变量定义散布于方法定义之间，
 * 它们仍会在任何方法（包括构造器）被调用之前得到初始化。
 * <p>
 * <p>
 * 需要牢记：
 * 对于所有基本类型和对象引用，在构造器被调用之前，它们早已进行了“自动初始化”，
 * 包括在定义时已经指定初值的那些变量，这种情况都是成立的。
 */
class Cups {
    Cup cup4 = new Cup(4);
    static Cup cup1;
    static Cup cup2;
    static Cup cup3 = new Cup(3);

    static {
//        cup1 = new Cup(1);
        cup2 = new Cup(2);
        cup1 = new Cup(1);
    }

    Cups() {
        System.out.println("Cups()");
    }

    static Cup cup5 = new Cup(5);

    static void cupStatic() {
        System.out.println("static method");
    }

    void cupNonstatic() {
        System.out.println("nonstatic method");
    }
}

public class Five13 {
    public static void main(String[] args) {
        System.out.println("inside main()");
//        Cups.cup1.f(1);
        Cups.cup2.f(2);
        new Cups();
        new Cups();
        System.out.println("-----------Cutting line-------------");
        Five14.whatIs();
        new Five14().printss();
    }

    static Cups cups1 = new Cups();
    static Cups cups2 = new Cups();
//    static Five14 f4=new Five14();
//    static Five14 f5=new Five14();
}

class Five14 {
    private static String s1;
    private static String s2 = "doubi";
    private static String s3;

    static {
        s1 = "baby";
        System.out.println("s1&s2 initialized,s3 uninitialized:");
        s3 = printss();
        System.out.println("s2,s3&s4 initialized");
    }

    Five14() {
        System.out.println("Five14()");
    }

    static void whatIs() {
        System.out.println(s1 + " or " + s2 + " or " + s3);
    }

    static String printss() {
        System.out.print("s1=" + s1);
        System.out.print(",s2=" + s2);
        System.out.println(",s3=" + s3);
        return "nishiwodaye";
    }

}