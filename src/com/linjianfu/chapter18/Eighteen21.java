package com.linjianfu.chapter18;

import java.io.*;

public class Eighteen21 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/com/linjianfu/chapter18/Eighteen21.java");
        BufferedInputStream inFile = new BufferedInputStream(
                new FileInputStream(file));
        System.setIn(inFile);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null)
            System.out.println(s.toUpperCase());
    }
}
