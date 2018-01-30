package com.linjianfu.chapter18;

import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class ProcessFiles5 {
    public static void main(String[] args) {
        String[] strings = new String[]{"src\\com\\linjianfu\\chapter16", "."};
        new ProcessFiles5(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, ".*22.java").start(strings);
    }

    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String regex;

    public ProcessFiles5(Strategy strategy, String regex) {
        this.strategy = strategy;
        this.regex = regex;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else for (String arg : args) {
                File fileArg = new File(arg);
                if (fileArg.isDirectory())
                    processDirectoryTree(fileArg);
                else {
                    Pattern p = Pattern.compile(regex);
                    if (p.matcher(arg).matches())
                        strategy.process(fileArg.getCanonicalFile());
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void processDirectoryTree(File root) throws IOException {
        for (File file : Directory.walk(root.getAbsolutePath(), regex))
            strategy.process(file.getCanonicalFile());
    }
}
