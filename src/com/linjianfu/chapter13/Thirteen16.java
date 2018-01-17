package com.linjianfu.chapter13;

import net.mindview.util.TextFile;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Thirteen16 {
    public static void main(String[] args) {
        int i=2*3;
        String[] s = new String[]{"./src/com/linjianfu/chapter13/Thirteen16.java", "\\b[Ssct]\\w+"};
        fr(s);
        /**
         * Exception:... java.io.FileNotFoundException: C:\test\test\Sixteen1.java (系统找不到指定的文件。)
         * */
//        String[] s1=new String[]{"C:\\test\\test\\Sixteen1.java", "\\b[Ssct]\\w+"};
//        fr(s1);
    }

    public static void fr(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java JGrep (file or directory) regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1]);
        Matcher d = Pattern.compile("\\w+\\.{1}\\w+").matcher(args[0]);
        if (d.find()) {
            System.out.println("File: " + args[0]);
            // Iterate through the lines of the input file:
            int index = 0;
            Matcher m = p.matcher(""); // creates emtpy Matcher object
            for (String line : new TextFile(args[0])) {
                m.reset(line);
                while (m.find())
                    System.out.println(index++ + ": " +
                            m.group() + ": " + m.start());
            }
        }
        Matcher e = Pattern.compile("^\\.{1}$").matcher(args[0]);
        if (e.find()) {
            File[] files = new File(args[0]).listFiles();
            System.out.println("root dir of files: " + Arrays.asList(files));
            // Iterate through the lines of each file in directory:
            for (File f : files) {
                if (f.getName().matches("\\w+\\.{1}\\w+")) {
                    System.out.println(f.getName() + ":");
                    int index = 0;
                    Matcher m = p.matcher(""); // creates emtpy Matcher object
                    for (String line : new TextFile(f.getName())) {
                        m.reset(line);
                        while (m.find())
                            System.out.println(index++ + ": " +
                                    m.group() + ": " + m.start());
                    }
                }
                System.out.println();
            }
        }
        d.reset();
        e.reset();
        if (!(d.find() || e.find())) {
            if (new File(args[0]).listFiles() == null) {
                System.out.println("no such directory: " + args[0]);
                System.exit(0);
            }
            File[] files = new File(args[0]).listFiles();
            System.out.println(args[0] + ": subdir of files: " + Arrays.asList(files));
            // Iterate through the lines of each file in directory:
            int counter = 0;
            for (File f : files) {
                int index = 0;
                Matcher m = p.matcher(""); // creates emtpy Matcher object
                for (String line : new TextFile(args[0] + "\\" + f.getName())) {
                    m.reset(line);
                    while (m.find())
                        System.out.println(index++ + ": " +
                                m.group() + ": " + m.start());
                }
                counter++;
                System.out.println();
            }
            System.out.println("Total " + counter + " files");
        }
    }
}
