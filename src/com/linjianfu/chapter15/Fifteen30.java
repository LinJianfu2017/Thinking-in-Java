package com.linjianfu.chapter15;

import static com.linjianfu.chapter15.Fifteen29.Holder;

public class Fifteen30 {
//    public void f(Holder<? super Number> holder) {
//    }

    public static void main(String[] args) {
        Holder<Boolean> b = new Holder<>();
        Holder<Character> c = new Holder<>();
        Holder<Byte> bt = new Holder<>();
        Holder<Short> s = new Holder<>();
        Holder<Integer> i = new Holder<>();
        Holder<Long> l = new Holder<>();
        Holder<Float> f = new Holder<>();
        Holder<Double> d = new Holder<>();
        b.set(true);
        b.get();
        c.set('a');
        c.get();
        bt.set((byte) 2);
        bt.get();
        s.set((short) 3);
        s.get();
        i.set(4);
        i.get();
        l.set((long) 5);
        l.get();
        f.set(6f);
        f.get();
        d.set(7.0);
        d.get();

    }
}
