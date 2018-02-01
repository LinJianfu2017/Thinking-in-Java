package com.linjianfu.chapter17;

import net.mindview.util.Countries;

//Ex 20,22.
public class Seventeen20 {
    public static void main(String[] args) {
        SimpleHashMap<String, String> sm = new SimpleHashMap<>();
        sm.putAll(Countries.capitals(6));
        System.out.println(sm);
        sm.put("ANGOLA", "xxxx");
        System.out.println(sm);
        //22:
        System.out.println(sm.get("BENIN"));
        sm.remove("BENIN");
        System.out.println(sm);
    }
}
