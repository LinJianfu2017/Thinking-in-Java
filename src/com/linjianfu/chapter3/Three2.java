package com.linjianfu.chapter3;

public class Three2 {
    class VelocityParameter {
        float time, distance;
    }

    void velocity(VelocityParameter y) {
        y.time = 41.31f;
        y.distance = 188.3f;
        System.out.println("Distance is:" + y.distance + ",  Used time is:" + y.time + ",  Average velocity is:" + y.distance / y.time);
    }

    public static void main(String[] args) {
        Three2 t = new Three2();
        VelocityParameter t1 = t.new VelocityParameter(), t2 = t.new VelocityParameter();
        t1.time = 9.9f;
        t2.time = 47.47f;
        System.out.println("1:t1.time=" + t1.time + ",t2.time=" + t2.time);
        t1 = t2;
        System.out.println("2:t1.time=" + t1.time + ",t2.time=" + t2.time);
        t1.time = 66.66f;
        System.out.println("3:t1.time=" + t1.time + ",t2.time=" + t2.time);
        t.velocity(t1);
        System.out.println("4:t1.time=" + t1.time + ",t2.time=" + t2.time);
    }
}
