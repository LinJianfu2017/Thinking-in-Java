package com.linjianfu.chapter13;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//正则表达式之基础（exercise 7,8,9）
public class Thirteen7 {
    public static String readFileLine(String name) {
//        List<String> results = new ArrayList<>();
        StringBuilder results = new StringBuilder();
        int count = 0;
        String s;
        try {
            BufferedReader br = new BufferedReader(new FileReader(name));
            while (br.readLine() != null) {
                s = br.readLine() + "\n";
//                results.add(s);
                results.append(s);
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + name);
        } catch (IOException e) {
            System.out.println("read failed in line: " + count);
        }

        return results.toString();
    }

    /**
     * A test.
     */
    public static void main(String[] args) {
        //为啥不能工作啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
        String regex = "^[A-Z].*[\\.]$";
//        List<String> list = readFileLine("./src/com/linjianfu/chapter13/Thirteen7.java");
        String list = readFileLine("./src/com/linjianfu/chapter13/Thirteen7.java");
        Pattern p = Pattern.compile(regex);
        Matcher m;
//        System.out.println(list.toString());
        System.out.println(list);
//        for (String s : list) {
        m = p.matcher(list);
        if (m.find()) {
            System.out.println(m.group());
        }
//        }
        System.out.println(m.groupCount());

    }
}
