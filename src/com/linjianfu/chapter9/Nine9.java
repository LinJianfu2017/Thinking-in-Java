package com.linjianfu.chapter9;

//Exercise 9,10.
enum Note {
    MIDDLE_C, C_SHARP, B_FLAT;
}

interface Playble {
    void play(Note note);

    //    static int k;
    int i = 0, j = i;//interface域定义必须同时赋初值,且初值为编译期常量。

//    static {       //不允许代码块存在。
//        k = 5;
//    }
}

abstract class Instrument {
    private int i;  //abstract类 允许域定义不带赋初值。

    {
        i = 0;
    }          //允许代码块存在。
//    protected abstract void play(Note note);

    protected abstract void adjust();

    public abstract String toString();
}

class Wind extends Instrument implements Playble {//管乐器

    public void play(Note note) {
        System.out.println(this + ".play()" + note);
    }

    protected void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Wind";
    }
}

class Percussion extends Instrument implements Playble {//打击乐器

    public void play(Note note) {
        System.out.println(this + ".play()" + note);
    }

    protected void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed extends Instrument implements Playble {//弦乐器

    public void play(Note note) {
        System.out.println(this + ".play()" + note);
    }

    protected void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {//铜管乐器

    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {//木管乐器

    @Override
    public String toString() {
        return "Woodwind";
    }
}

public class Nine9 {
    static void tune(Playble i) {
        i.play(Note.MIDDLE_C);
    }

    static void tuneAll(Playble[] instruments) {
        for (Playble j : instruments)
            tune(j);
    }

    public static void main(String[] args) {
        Playble[] instruments = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(instruments);
    }

}
