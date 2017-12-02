package com.linjianfu.chapter7;

//Exercise 16,17.
class Amphibian {
    void a() {
        System.out.println("Amphibian.a()");
    }

    void b() {
        System.out.println("Amphibian.b()");
    }

    void c() {
        System.out.println("Amphibian.c()");
    }
    public void play(){
        System.out.println("Amphibian class.play()");
    }
    static void tune(Amphibian i){
        i.play();
    }
}

class Frog extends Amphibian {
    void d() {
        System.out.println("Frog.d()");
    }

    @Override
    void a() {
        System.out.println("Frog.a()");
    }

    @Override
    void b() {
        System.out.println("Frog.b()");
    }

    @Override
    void c() {
        System.out.println("Frog.c()");
    }

    public static void main(String[] args) {
        Amphibian frog = new Frog();//Upcasting
        /**
         * RTTI,ClassCastException.Why???
         */
//        Frog amphibian= (Frog)new Amphibian();
        frog.a();
        frog.b();
        frog.c();
        ((Frog) frog).d();//Downcast
        Frog f=new Frog();
        Amphibian.tune(f);//Upcasting
        frog.tune(frog);
    }
}

public class Seven16 {
    public static void main(String[] args) {
        Frog.main(args);
    }

}
