package com.linjianfu.chapter10;

class ExSeven {
    private int i;

    private void fs() {
        System.out.println("AAAAAAAAAAAAAA");
    }

    class Inner {
        void ifs() {
            i += 6;
            fs();
        }
    }

    protected void iprint() {
        System.out.println(i);
    }

    protected void getInner() {
        Inner inner = new Inner();
        inner.ifs();
    }


}

public class Ten7 {
    public static void main(String[] args) {
        ExSeven exSeven=new ExSeven();
//        ExSeven.Inner inner=exSeven.new Inner();
        exSeven.iprint();
        exSeven.getInner();
        exSeven.iprint();
    }
}
