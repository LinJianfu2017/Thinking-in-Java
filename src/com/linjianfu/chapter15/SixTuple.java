package com.linjianfu.chapter15;

import net.mindview.util.FiveTuple;

//Exercise 3.And chapter17 ex28.
public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E>
        implements Comparable {
    public final F sixth;

    public SixTuple(A a, B b, C c, D d, E e, F f) {
        super(a, b, c, d, e);
        sixth = f;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 37 + first.hashCode();
        result = result * 37 + second.hashCode();
        result = result * 37 + third.hashCode();
        result = result * 37 + fourth.hashCode();
        result = result * 37 + fifth.hashCode();
        result = result * 37 + sixth.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof SixTuple)) return false;
        SixTuple st =
                (SixTuple) obj;
        return st.first.equals(first) && st.second.equals(
                second) && st.third.equals(third) && st.fourth.
                equals(fourth) && st.fifth.equals(fifth) && st.sixth
                .equals(sixth);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof SixTuple))
            throw new ClassCastException();
        SixTuple st = (SixTuple) o;
        return Integer.compare(hashCode(), st.hashCode());
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }
}

