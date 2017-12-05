package com.linjianfu.chapter8;

class AlertStatus {
    void xx() {
    }
}

class On extends AlertStatus {
    @Override
    void xx() {
        System.out.println("On.xx()");
    }
}

class Tw extends AlertStatus {
    @Override
    void xx() {
        System.out.println("Tw.xx()");
    }
}

class Th extends AlertStatus {
    @Override
    void xx() {
        System.out.println("Th.xx()");
    }
}

class Starship {
    private AlertStatus alertStatus = new On();

    public void on() {
        alertStatus = new On();
    }

    public void tw() {
        alertStatus = new Tw();
    }

    public void th() {
        alertStatus = new Th();
    }

    public void checkStatus() {
        alertStatus.xx();
    }

}

public class Eight16 {
    public static void main(String[] args) {
        Starship s = new Starship();
        s.checkStatus();
        s.on();
        s.checkStatus();
        s.tw();
        s.checkStatus();
        s.th();
        s.checkStatus();
    }
}
