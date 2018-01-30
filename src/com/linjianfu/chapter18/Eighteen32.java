package com.linjianfu.chapter18;

import net.mindview.util.TextFile;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.*;
import java.util.*;

public class Eighteen32 {
    public static void format(OutputStream os, Document doc)
            throws Exception {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(64);
        serializer.write(doc);
        serializer.flush();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        String fileName = "src\\com\\linjianfu\\chapter18\\Eighteen32.java";
//                new BufferedReader(new InputStreamReader(System.in)).readLine();
        ArrayList<String> allWords = new TextFile(fileName, "\\W+");
        Set<String> uniqueWords = new TreeSet<String>(allWords);
        Map<String, Integer> wordCount = new TreeMap<>();
        for (String s : uniqueWords) {
            int count = 0;
            for (String t : allWords)
                if (t.equals(s)) count++;
            wordCount.put(s, count);
        }
        Element root = new Element("words");
        Iterator it = wordCount.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> me = (Map.Entry<String, Integer>) it.next();
            Element word = new Element("word");
            word.appendChild(me.getKey() + ": ");
            word.appendChild(Integer.toString(me.getValue()));
            root.appendChild(word);
        }
        Document doc = new Document(root);
        try {
            format(System.out, doc);
            format(new BufferedOutputStream(new FileOutputStream("WordCount.xml")), doc);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
