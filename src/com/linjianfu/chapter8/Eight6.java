package com.linjianfu.chapter8;

import java.util.Random;

//Exercise 6,7,8.
enum Note {
    MIDDLE_C, C_SHARP, B_FLAT;
}

class Instrument {
    String name = "Instrument";

    void play(Note n) {
        System.out.println(name + ".play()" + n);
    }

    //    String what(){
//        return "Instrument";
//    }
    @Override
    public String toString() {
        return name;
    }

    void adjust() {
        System.out.println("Adjusting " + name);
    }
}

class Wind extends Instrument {

    {
        super.name = "Wind";
    }
}

class Percussion extends Instrument {
    {
        super.name = "Percussion";
    }
}

class Stringed extends Instrument {
    {
        super.name = "Stringed";
    }
}

class Brass extends Wind {
    {
        super.name = "Brass";
    }
}

class Woodwind extends Wind {
    {
        super.name = "Woodwind";
    }
}

public class Eight6 {
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void tuneall(Instrument[] j) {
        for (Instrument i : j)
            tune(i);
    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind(),
        };
        tuneall(orchestra);
        for (Instrument k : orchestra)
            System.out.println(k);
        Eight8.main(args);

    }

}

class Eight8 {
    private static Random rand = new Random(47);

    private Instrument next() {
        switch (rand.nextInt(5)) {
            default:
            case 0:
                return new Wind();
            case 1:
                return new Percussion();
            case 2:
                return new Stringed();
            case 3:
                return new Brass();
            case 4:
                return new Woodwind();
        }
    }

    public static void main(String[] args) {
        Eight8 e = new Eight8();
        Instrument[] instruments = new Instrument[9];
        for (int i = 0; i < instruments.length; i++)
            instruments[i] = e.next();
        Eight6.tuneall(instruments);
        for (Instrument s : instruments)
            System.out.println(s);

    }
}