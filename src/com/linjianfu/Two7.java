package com.linjianfu;

class StaticTest{
    static int i=47;
}
class Increments{
    static void increment(){
        StaticTest.i++;
    }
}
public class Two7 {
    public static void main(String args[]){
        System.out.println("StaticTest.i="+ StaticTest.i);
        StaticTest st1=new StaticTest();
        StaticTest st2=new StaticTest();
        System.out.println("st1.i=" + st1.i);
        System.out.println("st2.i=" + st2.i);
        Increments sf=new Increments();
        sf.increment();
        System.out.println("After sf.increment called: ");
        System.out.println("st1.i=" + st1.i);
        System.out.println("st2.i=" + st2.i);
        Increments.increment();
        System.out.println("After Increments.increment called:");
        System.out.println("st1.i=" + st1.i);
        System.out.println("st2.i=" + st2.i);
        st1.i=3;
        System.out.println("After st1.i=3:");
        System.out.println("st1.i=" + st1.i);
        System.out.println("st2.i=" + st2.i);
        System.out.println("Create another StaticTest,st3:");
        StaticTest st3=new StaticTest();
        System.out.println("st3.i="+st3.i);


    }
}
