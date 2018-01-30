package com.linjianfu.chapter18;

import net.mindview.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;

//Eightteen1
public class DirList {
    public static void main(final String[] args) {
        File path = new File("src/com/linjianfu/chapter16");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else list = path.list(new FilenameFilter() {
//            Pattern pattern = Pattern.compile(args[0]);

            @Override
            public boolean accept(File dir, String name) {
//                return pattern.matcher(name).matches();
                name = path + "\\" + name;
//                System.out.println(name);
                return !Collections.disjoint(
                        new TextFile(name, "\\W+"), Arrays.asList(args));
            }
        });
        if (list != null)
            Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
