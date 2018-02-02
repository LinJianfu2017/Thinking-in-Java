package com.linjianfu.chapter17;

import java.util.ArrayList;
import java.util.List;
//Ex26,27.
public class CountedString26 {
    private static List<String> created = new ArrayList<>();
    private String s;
    private int id = 0;
    private char c;

    public CountedString26(String str, char c) {
        s = str;
        created.add(s);
        this.c = c;
        for (String s2 : created)
            if (s2.equals(s))
                id++;
    }

    @Override
    public String toString() {
        String sb = "String: " + s + " id: " + id +
                " char: " + c + " hashCode(): " + hashCode();
        return sb;
    }

    @Override
    public int hashCode() {
        int result = 17;
        /**对调下方2、3行的顺序，从这个角度看，说明每次迭代37*result或许是有必要的，
         * 放大了差异性？只要能错开，似乎也没必要追求这种放大效果。另有其因？
         */
        result = 37 * result + s.hashCode();
        result = 37 * result + id;
        result = 37 * result + c;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CountedString26 &&
                s.equals(((CountedString26) obj).s)
                && id == ((CountedString26) obj).id
                && c == ((CountedString26) obj).c;
    }
}
