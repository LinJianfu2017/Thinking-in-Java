package com.linjianfu.chapter18;

import java.io.*;
import java.util.LinkedList;

public class Eighteen12 {
    public static String dirPath = "src\\com\\linjianfu\\chapter18\\";

    private static String readAndReverse(String fileName)
            throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dirPath + fileName));
        String s;
        LinkedList<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        String[] temp = fileName.split("\\.");
        String file = temp[0] + "Reversed." + temp[1];
        PrintWriter out = new PrintWriter(file);
        int lineCount = 1;
        while ((s = br.readLine()) != null)
            list.add(lineCount++ + " " + s);
        while (list.peekLast() != null) {
            String t = list.pollLast();
            out.println(t);
            sb.append(t).append("\n");
        }
        br.close();
        out.close();
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(readAndReverse(new BufferedReader(
                new InputStreamReader(System.in)).readLine()));
    }
}
