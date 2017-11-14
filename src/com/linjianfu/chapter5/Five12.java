package com.linjianfu.chapter5;

//Exercise 12
class Tank {
    private int howfull = 0;

    Tank() {
        this(0);
    }

    Tank(int tankStatus) {
        howfull = tankStatus;
    }

    void sayHowFull() {
        if (howfull == 0) System.out.println("Tank is empty");
        else System.out.println("Tank filling status =" + howfull);
    }

    void empty() {
        howfull = 0;
    }

    protected void finalize() {
        if (howfull != 0) System.out.println("error: Tank not empty");
//        super.finalize();
    }
}

public class Five12 {
    public static void main(String[] args) {
        Tank tank1 = new Tank();
        Tank tank2 = new Tank(2);
        Tank tank3 = new Tank(3);
        tank2.empty();
        new Tank(4);
        new Tank(5);
        /**
         * 经验证得，System.runFinalizersOnExit()收集无名实例的finalize(),
         * 而System.gc()相应地收集的是有名实例的finalize(),事实如此否？
         */
        System.out.println("check tanks:");
        System.out.println("tank1:");
        tank1.sayHowFull();
        System.out.println("tank2:");
        tank2.sayHowFull();
        System.out.println("tank3:");
        tank3.sayHowFull();
        System.out.println("first forced gc():");
        System.gc();
        System.out.println("try deprecated runFinalizersOnExit(true):");
        System.runFinalizersOnExit(true);
        System.out.println("last forced gc():");
        System.gc();
    }

}
