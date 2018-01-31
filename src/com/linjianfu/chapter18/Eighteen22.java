package com.linjianfu.chapter18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Eighteen22 {
    private static class OSExecute {
        public static List<String> command(String command) {
            System.out.println(Arrays.toString(command.split(" ")));
            boolean err = false;
            List<String> list = new ArrayList<>();
            try {
                Process process = new ProcessBuilder(command.split(" ")).start();
                BufferedReader results = new BufferedReader(
                        new InputStreamReader(process.getInputStream()));
                String s;
                while ((s = results.readLine()) != null)
                    list.add(s);
                BufferedReader errors = new BufferedReader(
                        new InputStreamReader(process.getErrorStream()));
                while ((s = errors.readLine()) != null) {
                    System.err.println(s);
                    err = true;
                }
            } catch (Exception e) {
                if (!command.startsWith("CMD /C"))
                    command("CMD /C " + command);
                else throw new RuntimeException(e);
            }
//            if (err)
//                throw new OSExecuteException("Errors executing "
//                        + command);
            return list;
        }
    }

    public static void main(String[] args) {
        for (String s : OSExecute.command(
                "javap out/production/test1/com/linjianfu/chapter18/Eighteen22"))//找不到主类
            System.out.println(s);
    }
}
