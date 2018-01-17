package com.linjianfu.chapter13;

import net.mindview.util.TextFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 构建失败：
 * 写一个可以遍历任意（多级）目录下包含的所有个体文件，让指定的正则表达式逐个匹配这些 文件包含的信息并按要求输出。
 */
//Exercise 15,16.
public class Thirteen15 {

    public static class JGrep {
        public static void main(String[] args, int flag) throws Exception {

            if (args.length < 2) {
                System.out.println("Usage: java JGrep file regex");
                System.exit(0);
            }
            Pattern p = Pattern.compile(args[1], flag);
            //Iterate through the lines of the input file:遍历输入文件的行
            int index = 0;
            Matcher m = p.matcher("");
//            String file=args[0];
//            String[] files;
//            if (file.matches("^[./].+[.]\\w+$")){
//                files=new File(file).listFiles();
//            }

            for (String line : new TextFile(args[0])) {
                m.reset(line);
                while (m.find())
                    System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }

    public static void main(String[] args) {
        int[] flags = new int[]{Pattern.CANON_EQ, Pattern.CASE_INSENSITIVE, Pattern.COMMENTS, Pattern.MULTILINE,
                Pattern.LITERAL, Pattern.UNIX_LINES, Pattern.DOTALL, Pattern.UNICODE_CASE, Pattern.UNICODE_CHARACTER_CLASS};
        String[] s = new String[]{"./src/com/linjianfu/chapter13/Thirteen15.java", "\\b[Ssct]\\w+"};
        for (int flag : flags) {
            try {
                JGrep.main(s, flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        System.out.println("^\\.{1}$");
//        File[] files = new File("./src/com/linjianfu/chapter13").listFiles();
//        System.out.println(Arrays.toString(files));
    }
}
