package com.linjianfu.chapter7;
//Exercise 9,10，12.
class Component1{
    Component1(char c){
        System.out.println("Component1()");
    }
    void dispose(){
        System.out.println("Component1 dispose");
    }
}
class Component2{
    Component2(int i){
        System.out.println("Component2()");
    }
    void dispose(){
        System.out.println("Component2 dispose");
    }
}
class Component3{
    Component3(float f){
        System.out.println("Component3()");
    }
    void dispose(){
        System.out.println("Component3 dispose");
    }
}
class Root{
    Root(String s){
        System.out.println("Root()");
    }
    Component1 c1root=new Component1('1');
    Component2 c2root=new Component2(2);
    Component3 c3root=new Component3(3f);
    void dispose(){
        System.out.println("Root dispose");
        c3root.dispose();
        c2root.dispose();
        c1root.dispose();
    }
}
public class Seven9 extends Root{
    Seven9(double d){
        /**
         * 此处虽然调用基类构造器，但从结果来看，语句并没有实际的输出，似乎仅是一个声明，而并非执行语句。
         * 从清理动作来看，反向结果也符合猜想，子类调用基类构造器的真正时机是发生于extends动作。
         * */
        super("Root");
        c2seven9=new Component2(0);
        System.out.println("Seven9()");
    }
    Component1 c1seven9;
    Component2 c2seven9;
    Component3 c3seven9=new Component3(3f);
    void dispose(){
        System.out.println("Seven9 dispose");
        c2seven9.dispose();
//        super.dispose();
        c3seven9.dispose();
        super.dispose();

    }
    public static void main(String[] args) {
        Seven9 s12=new Seven9(9.0);
        s12.dispose();
    }

}
