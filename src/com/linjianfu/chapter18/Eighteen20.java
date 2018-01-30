package com.linjianfu.chapter18;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;

import java.io.File;
import java.io.IOException;

public class Eighteen20 {
    public static void main(String[] args) throws IOException {
        int fileCount = 0;
        for (File file : Directory.walk(
                "out\\production\\test1\\com\\linjianfu\\chapter18",
                ".*\\.class").files) {
            byte[] bytes = BinaryFile.read(file);
            for (int i = 0; i < 4; i++)
                System.out.print(Integer.toHexString(bytes[i] & 0xff).toUpperCase() + " ");
            fileCount++;
            System.out.println(bytes.length);
        }
        System.out.println();
        System.out.println("Total files: " + fileCount);
    }
}
