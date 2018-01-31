package com.linjianfu.chapter18;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Eighteen26 {

    public static class JGrep {
        public static void main(String[] args, int flag) throws Exception {
            long start = System.nanoTime();
            if (args.length < 2) {
                System.out.println("Usage: java JGrep file regex");
                System.exit(0);
            }
            FileChannel fc = new FileInputStream(args[0]).getChannel();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                    new File(args[0]).length());
            String[] strings = Charset.forName(System.getProperty("file.encoding"))
                    .decode(mbb).toString().split("\n");
            Pattern p = Pattern.compile(args[1], flag);
            int index = 0;
            Matcher m = p.matcher("");
            for (String line : strings) {
                m.reset(line);
                while (m.find())
//                    System.out.println(index++ + ": " + m.group() + ": " + m.start())
                    ;
            }
//            System.out.println("---------------------------------------------------");
            long duration = System.nanoTime() - start;
            System.out.println("mapped: " + duration);
        }
    }

}
