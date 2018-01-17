package com.linjianfu.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Thirteen13 {
    private static class Display {
        private boolean regexPrinted = false;
        private String regex;

        Display(String regex) {
            this.regex = regex;
        }

        void display(String message) {
            if (!regexPrinted) {
                System.out.println(regex);
                regexPrinted = true;
            }
            System.out.println(message);
        }
    }

    public static void examine(String s, String regex) {
        Display d = new Display(regex);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
//        while (m.find())//无尽循环display同一个字符串，为啥此时m.find()不去search下一个匹配串？find()定义里就是这样啊。。。
        if (m.find()) {
            d.display("find() '" + m.group() + "' start = " + m.start() + " end = " + m.end());
            if (m.lookingAt())
                d.display("lookingAt() start = " + m.start() + " end = " + m.end());
            if (m.matches())
                d.display("matches() start = " + m.start() + " end = " + m.end());
        }
    }

    public static void main(String[] args) {
        for (String in : Thirteen10.POEM.split("\n")) {
            System.out.println("input: " + in);
            for (String regex : new String[]{"\\w*ere\\w*", "A\\w*", "T\\w+", "B\\w+.*,"})
                examine(in, regex);
        }
    }
}
