package com.linjianfu.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Exercise 10,11,12.
public class Thirteen10 {
    public static String regexArray[] = new String[]{
            "^java", "\\Berg.*", "n.w\\s+h(a|i)s", "s?", "s*", "s+", "s{4}", "s{1}.", "s{0,3}"
    };
    public static String regex = "(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b";


    public static final String POEM = "Twas brillig, and the slithy toves\n" +
            "Did gyre and gimble in the wabe.\n" + "All mimsy were the borogoves,\n" +
            "And the mome raths outgrabe.\n\n" + "Beware the Jabberwock, my son,\n" +
            "The jaws that bite, the claws that catch,\n" + "Beware the Jubjub bird, and shun\n" +
            "The frumious Bandersnatch.";

    public static void main(String[] args) {
        String word = "Java now has regular expressions";//regular expressions:正则表达式
        for (String s1 : regexArray) {
            Pattern p = Pattern.compile(s1);
            Matcher m = p.matcher(word);
            while (m.find()) {
                if (s1 == "s{1}.") {
                    System.out.println("Match \"" + m.group() + "\"at position " + m.start() +
                            ((m.end() - m.start() < 2) ? "" : "-" + (m.end() - 1)));
                    System.out.println(s1);
                }
            }
        }
        String word2 = "Arline ate eight apples and one orange while anita hadn't any";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(word2);
        System.out.println(m.groupCount());
        while (m.find()) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
            System.out.println("-------");
        }

        //Exercise 12:
        String name = "./src/com/linjianfu/chapter13/Thirteen7.java";
        String afile = Thirteen7.readFileLine(name);
        Matcher matcher = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+").matcher(afile);
        while (matcher.find())
            System.out.print(matcher.group());
//        Matcher m12 = Pattern.compile("(^[a-z]|\\s+[a-z])\\w+").matcher(POEM);
//        Set<String> words = new TreeSet<String>();
//        while (m12.find()) {
//            words.add(m12.group());
//        }
//        System.out.println("Number of unique non-cap words = " + words.size());
//        System.out.println(words);
    }
}
