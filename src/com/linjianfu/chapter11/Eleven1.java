package com.linjianfu.chapter11;


import java.util.ArrayList;
import java.util.Iterator;

class Gerbil {
    private static int id = 0;
    private final int gerbilNumber;

    Gerbil() {
        gerbilNumber = id++;
    }

    @Override
    public String toString() {
        return "Gerbil " + gerbilNumber;
    }

    public void hop() {
        System.out.println("Gerbil " + gerbilNumber + " is hopping.");
    }
}

public class Eleven1 {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        for (int i = 0; i < 3; i++)
            gerbils.add(new Gerbil());
        for (int i = 0; i < gerbils.size(); i++)
            gerbils.get(i).hop();
        //or alternatively(或者、作为一种选择) using foreach syntax(语法、句法)
        for (Gerbil g : gerbils)
            g.hop();
        //Exercise 8:利用无视容器类型的iterator访问，
        // Iterator真正的威力：将遍历序列的操作与序列底层的结构分离。
        Iterator<Gerbil> iterator = gerbils.iterator();
        while (iterator.hasNext())
            iterator.next().hop();
    }
}
