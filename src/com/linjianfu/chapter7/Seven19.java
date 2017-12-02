package com.linjianfu.chapter7;
class Sev19{
    private int i;
    Sev19(int k){
        i=k;
    }

    @Override
    public String toString() {
        return "Sev19-"+i;
    }
}
public class Seven19 {
    private final Sev19 s;
    Seven19(){
        s=new Sev19(1);
    }
    Seven19(int i){
        s=new Sev19(i);
    }

    public static void main(String[] args) {
        Seven19 s1=new Seven19();
        Seven19 s2=new Seven19(2);
//        s1.s=new Sev19(3);//cannot assign values
//        s2.s=new Sev19(4);//to final variable 's'.
        System.out.println("s1.s=" + s1.s);
        System.out.println("s2.s=" + s2.s);
    }



}
