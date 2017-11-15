package com.linjianfu.chapter5;

public class Five16 {
    public static void main(String[] args) {
        /**
         * 最后的逗号是可选的，这一特性使维护长列表变得更容易。？
         * */
        String[] s = new String[]{"I", "love", "you", ",", "baby",};
        for(int i=0;i<s.length;)
            System.out.println(s[i++]);

    }
}
