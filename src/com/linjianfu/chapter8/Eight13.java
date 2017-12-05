package com.linjianfu.chapter8;

class Shared {
    private int refcount = 0;
    //    int refcount=0;
//    static int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    Shared() {
        System.out.println("Creating " + this);
    }

    void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0)
            System.out.println("Disposing " + this);
    }

    protected void finalize() {
        if (refcount > 0)
            System.out.println("Error: " + refcount + " Shared " + id + " objects in use.");
    }

    @Override
    public String toString() {
        return "Shared " + id/**+ ", Shared.counter=" + counter*/;
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("Disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id/** + ", Composing.counter=" + counter*/;
    }
}

public class Eight13 {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] c = {
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)
        };
        System.out.println(shared);
        /**
         * 测试id/counter/refcount.
         *结果表明：shared是一个共享的对象引用，Shared.dispose()追踪每一个Shared对象引用的共享次数，
         * 当对应的一个引用的共享次数为零，则抛出指明可释放该引用的消息。
         * id表示引用编号，counter为引用编号计数，refcount则表示对应编号的引用被共享的次数。
         * */
//        Shared s2 = new Shared();
//        System.out.println(s2);
//        new Composing(s2);
//        System.out.println(s2.refcount);
        for (Composing cc : c) {
            cc.dispose();
//            System.out.println(shared.refcount);
        }
        Composing compTest1 = new Composing(shared);
        Composing compTest2 = new Composing(shared);
        //Test finalize():
        shared.finalize();
        Shared sharedTest = new Shared();
        Composing compTest3 = new Composing(sharedTest);
        //Test sharedTest finalize():
        sharedTest.finalize();

    }
}
