package com.linjianfu.chapter12;

/**
 * 导出类构造器不能捕获基类构造器抛出的异常，原因：
 * 其一、异常捕获必须形成try-catch语句块？
 * 其二、基类构造器的调用"must be first statement in constructor."
 * 两者相矛盾，故......
 */
public class Twelve21 {
    public static void main(String[] args) {
        try {
            Derived d = new Derived();
        } catch (MyException e) {
            System.out.println(e);
        }
    }
}

class Base {
    Base() throws MyException {
        throw new MyException();
    }
}

class Derived extends Base {
    Derived() throws MyException {
        super();
        //not this way,'catch' without 'try' not allowed:
//        catch(MyException e){}
        //not this way either,because call to super must be
        //first statement in constructor:
//        try {
//            super();
//        } catch (MyException e) {
//        }
    }
}
