package com.linjianfu.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//Exercise 7,8,9,10.
public class Eighteen7 {
    private static String readAndReverse(String fileName, String[] words)
            throws IOException, NullPointerException {
        List<String> wordFind = new ArrayList<>();
        Collections.addAll(wordFind, words);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String s;
        LinkedList<String> linkedList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null)
            if (!Collections.disjoint(Arrays.asList(s.split("\\W+")), wordFind))//Exercise 10
                linkedList.add(s);
//            linkedList.add(s.toUpperCase());//Exercise 9
        while (linkedList.peekLast() != null)
            sb.append(linkedList.pollLast()).append("\n");
        br.close();
        return sb.toString();

    }

    public static void main(String[] args) throws Exception {
        String fileName;
        if (args.length != 0) fileName = args[0];
        else fileName = "src/com/linjianfu/chapter18/Eighteen7.java";
        String[] words = new String[]{"while", "return", "static"};
        System.out.println(readAndReverse(fileName, words));
    }
}
