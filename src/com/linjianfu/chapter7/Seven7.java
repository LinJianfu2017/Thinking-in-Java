package com.linjianfu.chapter7;

class AA {
    AA(int i, char c) {
        System.out.println("AA(int,char)");
    }
}

class BB extends AA {
    BB(float f, String s) {
        super(0, ' ');
        System.out.println("BB(float,String)");
    }
}

public class Seven7 extends AA {
    private int i;
    private char c;

    Seven7(char c, int i) {
        super(i, c);
        this.c = c;
        this.i = i;
    }

    @Override
    public String toString() {
        return "Seven7("+c+","+i+")";
    }

    BB b=new BB(0.0f,"new BB()");

    public static void main(String[] args) {
        Seven7 s7=new Seven7('c',0);
        System.out.println(s7);
    }

}
