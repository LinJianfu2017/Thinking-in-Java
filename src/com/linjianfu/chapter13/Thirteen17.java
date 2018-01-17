package com.linjianfu.chapter13;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Exercise 17,18,19.
public class Thirteen17 {
    public static void main(String[] args) {
        String regex = "(/*\\*+.+)|(//\\s*.+)";
        String[] filename = new String[]{".\\src\\com\\linjianfu\\chapter13\\Thirteen16.java"};
//        printFileCommentAndSoOn(filename, regex);//17
        String regex1 = "\".*\"";
//        printFileCommentAndSoOn(filename,regex1);//18
        String regex2 = "\\s+[A-Z]\\w+";
        printFileCommentAndSoOn(filename, regex2);//19，怎么搞进Set里面，除去重复的结果。？？？
//        ArrayList<String> arrayList = printFileCommentAndSoOn(filename, regex2);
//        System.out.println(cn);

    }

//    static ArrayList<String> stringArrayList = new ArrayList<>();
//    static StringBuilder sb = new StringBuilder();

    public static void printFileCommentAndSoOn(String[] ss, String regex) {
//        if (ss.length < 1) {
//            System.out.println("Usage:fileName");
//            System.exit(0);
//        }
        Pattern p = Pattern.compile(regex);
        int index = 0;
        Matcher m = p.matcher("");
        Set<String> set = new TreeSet<>();
//        String copy;
        System.out.println(ss[0] + "  what you want: ");
        for (String line : new TextFile(ss[0])) {
            m.reset(line);
            while (m.find())
                System.out.println(index++ + ": " + m.group().replaceAll("\\s*", ""));
/**
 * 匹配过程中，死活不让调用：“IllegalStateException: No match found”：
 * */
//            if (i>2) {
//                set.add(m.group().replaceAll("\\s*", ""));
//            }
//            stringArrayList.add(index++ + ": " + m.group() + "\n");
//            copy = m.group() + "\n";
//            sb.append(copy);
        }
    }
}
