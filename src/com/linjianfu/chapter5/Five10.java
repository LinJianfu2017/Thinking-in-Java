package com.linjianfu.chapter5;

/**
 * Exercise 10,11
 */
class SecurityCheck {
    private boolean checkStatus = false;

    SecurityCheck(boolean status) {
        checkStatus = status;
    }

    void checkIn() {
        checkStatus = true;
    }

    void checkOut() {
        checkStatus = false;
    }

    protected void finalize() {
        if (checkStatus)
            System.out.println("Error:checked out");
//        super.finalize();//什么作用???
    }
}

public class Five10 {
    public static void main(String[] args) {
        SecurityCheck lan = new SecurityCheck(true);
        SecurityCheck lin = new SecurityCheck(true);
        new SecurityCheck(true);
        lan.checkOut();
        lan.checkIn();
        lan.finalize();
        System.out.println("Try1:");
        /**"System.runFinalization()"强制调用已经失去引用的对象的finalize方法
         * 等效于"Runtime.getRuntime.runFinalization()"
         * */
        System.runFinalization();
        System.out.println("Try2:");
        Runtime.getRuntime().runFinalization();
        System.out.println("Try3：");
        /**"System.gc()"告诉垃圾收集器打算进行垃圾收集，而垃圾收集器最终进不进行收集是不确定的。
         * 等效于"Runtime.getRuntime.gc()"
         * */
        System.gc();
        System.out.println("Try4:");
        System.runFinalizersOnExit(true);
//        System.gc();
//        lan.finalize();
    }

}
