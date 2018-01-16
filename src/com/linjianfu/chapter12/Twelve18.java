package com.linjianfu.chapter12;
//Exercise 18,19.
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception";
    }
}

class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}

class LostMessage {
    public void h() throws VeryImportantException {
        throw new VeryImportantException();
    }

    public void dispose() throws HoHumException {
        throw new HoHumException();
    }

}

public class Twelve18 {
    static void main18() {
//        try {
            LostMessage lm = new LostMessage();
            try {
                try {
                    lm.h();
                    lm.dispose();
                } finally {
                    Twelve10.g(1);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public static void main(String[] args) {
        try {
            try {
                LostMessage lostMessage = new LostMessage();
                try {
                    lostMessage.h();
                } catch (VeryImportantException e) {
                    System.out.println("Caught VeryImportantException");
                } finally {
                    lostMessage.dispose();
                }
            } catch (HoHumException e) {
                System.out.println("Caught a trivial exception");
            } finally {
                Twelve10.g(1);
            }
        } catch (Exception e) {
            System.out.println("Caught MyException");
        }
        System.out.println("-------------------------------------------------");
        main18();
    }
}
