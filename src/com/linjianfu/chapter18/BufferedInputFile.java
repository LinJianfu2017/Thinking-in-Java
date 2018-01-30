package com.linjianfu.chapter18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {

    public static String read(String fileName) throws IOException {
        fileName = Eighteen12.dirPath + fileName;
        BufferedReader br = new BufferedReader(
                new FileReader(fileName));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null)
            sb.append(s).append("\n");
        br.close();
        return sb.toString();
    }
}
