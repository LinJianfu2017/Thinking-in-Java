package com.linjianfu.chapter5;
//Exercise 17,18.
class Test17{
    Test17(String s){
        System.out.println("Test17()");
        System.out.println("test17s["+s+"]="+s);
    }
}
public class Five17 {
    public static void main(String[] args) {
        Test17[] test17s=new Test17[7];
//        System.out.println(test17s+"   "+test17s[0]);
    for(int i=0;i<test17s.length;)
        test17s[i]=new Test17(Integer.toString(i++));
    }
}
