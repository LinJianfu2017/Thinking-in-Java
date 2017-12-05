package com.linjianfu.chapter8;

class Base10{
    protected void f1(){
        f2();
    }
     void f2(){
        System.out.println("Base10.f2()");
    }
}
class Derived extends Base10{
    /**
     * 发现protected权限反而比default的宽、、、这不明摆着的。。
     * */
    @Override
    protected void f2(){
        System.out.println("Derived.f2()");
    }
}
public class Eight10 {
    public static void main(String[] args) {
        Base10 bd = new Derived();
        bd.f1();
    }

}
