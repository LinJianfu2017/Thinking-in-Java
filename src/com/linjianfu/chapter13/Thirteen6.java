package com.linjianfu.chapter13;

//格式化输出之String.format()
public class Thirteen6 {
    private int i;
    private long l;
    private float f;
    private double d;

    Thirteen6(int ii, long ll, float ff, double dd) {
        i = ii;
        l = ll;
        f = ff;
        d = dd;
    }

    @Override
    public String toString() {
        return String.format("(i=%d),(l=%d),(f=%.3f),(d=%.9f)\n", i, l, f, d);
    }

    public static void main(String[] args) {
        System.out.println(new Thirteen6(1, 233l, 3.3f, 4.45678910));
    }
}
/**
 * public String toString() {
 * return String.format("(i=%d),(l=%d),(f=%%.3f),(d=%.9f)\n", i, l, f, d);
 * }
 * 运行结果：
 * (i=1),(l=233),(f=%.3f),(d=3.299999952)
 */