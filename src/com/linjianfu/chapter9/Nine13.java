package com.linjianfu.chapter9;

interface Grandfather {
    void grandfather();
}

interface Father extends Grandfather {
    void father();
}

interface Mother extends Grandfather {
    void mother();
}

interface Son extends Father {
    void son();
}

class Omg implements Son {
    @Override
    public void grandfather() {

    }

    @Override
    public void father() {

    }

    public void mother() {
    }

    @Override
    public void son() {

    }
}

public class Nine13 {


    public static void main(String[] args) {
        Omg omg=new Omg();
        omg.grandfather();
        omg.father();
        omg.mother();
        omg.son();
    }
}
