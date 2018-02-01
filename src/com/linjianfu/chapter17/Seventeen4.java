package com.linjianfu.chapter17;

import net.mindview.util.TextFile;

import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Seventeen4 {
    public static Collection<String> collectFromText(String fileName) {
        String[] sw = TextFile.read(fileName).split("\\W+");
        return Arrays.asList(sw);
    }

    public static Collection<String> collectFromText2(String fileName) {
        return new TreeSet<>(new TextFile(fileName, "\\W+"));
    }

    public static void main(String[] args) {
        String fileName = DirPath17.PATH.concat("Seventeen4.java");
        System.out.println(collectFromText(fileName));
        System.out.println(collectFromText2(fileName));
    }
}
