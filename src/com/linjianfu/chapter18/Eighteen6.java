package com.linjianfu.chapter18;

import net.mindview.util.ProcessFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Eighteen6 {
    public static void main(String[] args) throws Exception {
        String[] s = new BufferedReader(
                new InputStreamReader(System.in)).readLine().split("\\s+");
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        new ProcessFiles(new ProcessFiles.Strategy() {
            @Override
            public void process(File file) {
                Date modDate = new Date(file.lastModified());
                try {
                    if (modDate.after(sdf.parse(s[0])))
                        System.out.println(file);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        }, "java").start(args);
//        for (File file : Directory.walk("src", ".*22.java"))
//            System.out.println(new Date(file.lastModified()));
    }
}
