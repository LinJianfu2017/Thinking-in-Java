package com.linjianfu.chapter18;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

//Eighteen2
public class SortedDirList {
    private String[] list;
    private Map<String, Long> map = new TreeMap<>();

    public SortedDirList(String dir) {
        list = new File(dir).list();
        if (list != null)
            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    }

    public String[] list() {
        return list;
    }

    public String[] list(String regex) {
        Pattern pattern = Pattern.compile(regex);
        ArrayList<String> result = new ArrayList<>();

        for (String s : list) {
            if (pattern.matcher(s).matches()) {
                result.add(s);
                map.put(s.replace(".java", ""),
                        new File("src\\com\\linjianfu\\chapter16\\" + s).length());
                System.out.println(s);
            }

        }
        System.out.println(map);
        long sum = 0;
        for (long count : map.values())
            sum += count;
        System.out.println("Sum: " + sum);

        if (result.isEmpty()) System.out.println("None");
        return result.toArray(new String[result.size()]);
    }

}
