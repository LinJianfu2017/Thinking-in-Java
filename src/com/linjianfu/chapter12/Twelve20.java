package com.linjianfu.chapter12;

/**
 * 一、异常说明：
 * 构造器：
 * 导出类构造器可以抛出任何异常，但异常说明必须包含基类构造器的异常说明（包括重载构造器），
 * 异常替换成基类异常的派生类也不行，即：相同的部分必须保持完全一致（与common方法不同）；
 * 若基类构造器不抛出异常，导出类构造器依旧可自由抉择（与common方法相反）。
 * <p>
 * common方法《重写》：
 * a,你可以选择不抛出任何异常，即使基类或接口的方法有异常说明；反之，则不然；
 * （即：若基类方法没有异常说明，则导出类亦不能有）
 * b,假如选择抛出异常，则异常说明必须与基类或接口一致（可以是相应的派生类异常）且不能有多出；
 * c,基类与接口冲突时，以基类为准；
 * d,对于基类和接口均没有定义的新方法，异常说明可自由抉择。
 * e,方法若是《重载了》，则视同d。
 * <p>
 * 二、异常捕获设置：
 * 不论向上或向下转型，构造器异常捕获以实际创建的对象实例类型为准，common方法以调用它的
 * 引用的类型为准，否则编译器将报错。
 * 然而实际的异常捕获可由实例方法抛出的异常及其各级超类捕获到。
 */

public class Twelve20 {
    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("PopFoul");
        } catch (RainedOut e) {
            System.out.println("RainedOut");
        } catch (BaseballException e) {
            System.out.println("BaseballException");
        }
        try {
            Inning i = new StormyInning();
            i.atBat();
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (BaseballException e) {
            System.out.println("BaseballException");
        } catch (RainedOut e) {
            System.out.println("RainedOut");
        }
//        try {
//            StormyInning si = (StormyInning) new Inning();
//            si.atBat();
//        } catch (PopFoul e) {
//        } catch (BaseballException e) {
//        }
        try {
            StormyInning.testStaticMethod();
        } finally {
        }
        try {
            Inning.testStaticMethod();
        } catch (RainedOut2 e) {
        }

    }

}

class StormyInning extends Inning implements Storm {
    public StormyInning() throws BaseballException, RainedOut {
    }

    public StormyInning(String s) throws BaseballException, Foul {

    }

    public void rainHard() throws RainedOut2 {

    }


    @Override
    public void atBat() throws PopFoul {

    }

    @Override
//    public void event() throws RainedOut {}
    public void event() {
    }

    @Override
//    public void walk() throws PopFoul{}
    public void walk() {
    }

    static void testStaticMethod() {

    }

}

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
    }

    public abstract void atBat() throws Strike, Foul;//at bat:轮到击球，上场击球

    public void walk() {
    }

    static void testStaticMethod() throws RainedOut2 {
    }
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

class RainedOut2 extends RainedOut {
}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}

