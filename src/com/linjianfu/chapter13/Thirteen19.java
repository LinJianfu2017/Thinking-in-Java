package com.linjianfu.chapter13;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Thirteen19 {
    public static void main(String[] args) {
        String[] filename = new String[]{".\\src\\com\\linjianfu\\chapter13\\Thirteen16.java"};
        m(filename);
/**
 result:

 classes in .\src\com\linjianfu\chapter13\Thirteen16.java:
 0: class Thirteen16

 Process finished with exit code 0
 * */
    }

    public static void m(String[] args) {
//        if (args.length < 1) {
//            System.out.println("Usage: fileName");
//            System.exit(0);
//        }
        // we want all class names:
        Pattern p = Pattern.compile("class \\w+\\s+");
        // not including those in comment lines:
        Pattern q = Pattern.compile("^(//|/\\*|\\*)");
        System.out.println("classes in " + args[0] + ":");
        // Iterate through the lines of the input file:
        int index = 0;
        Matcher m = p.matcher(""); // creates emtpy Matcher object
        Matcher n = q.matcher("");
        for (String line : new TextFile(args[0])) {
            m.reset(line);
            n.reset(line);
            while (m.find() && !n.find())
                System.out.println(index++ + ": " + m.group());
        }
    }
}
