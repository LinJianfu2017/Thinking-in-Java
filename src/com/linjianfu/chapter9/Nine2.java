package com.linjianfu.chapter9;

//Exercise 2,验证：不能为抽象类创建任何实例(Validation: no instances can be created for an abstract class.)。
abstract class N2one {
}

abstract class N2dad {
    N2dad() {
        System.out.println("N2dad()");
    }
}

class N2son extends N2dad {
    N2son() {
        System.out.println("N2son()");
    }
}

public class Nine2 {
    public static void main(String[] args) {
        //Error:N2one and N2dad cannot be instantiated:
//        N2one a1 = new N2one();
//        N2dad a2 = new N2dad();
        //But N2dad constructor called during instantiate of child:
        //(但是N2dad的构造器在实例化过程中被调用:)
        N2son a3 = new N2son();
    }
}
