package com.linjianfu.chapter2;

public class OuterClass {

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        System.out.println("i1="+innerClass.shit().shit().shit().i+"j1=" +innerClass.shit().shit().shit().j);
        System.out.println("j2="+innerClass.shit().shit().shit().j+ "i2="+innerClass.shit().shit().shit().i);


    }

    public void foo() {
        InnerClass innerClass = new InnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass( );
    }

    public class InnerClass {
        int i=0,j=0;
        InnerClass shit(){
            i++;j++;
            return this;
        }

    }

    public static class StaticInnerClass {

    }
}
