package com.linjianfu;

public class Two5 {



        public void getName() {
            String name = "Command line input parameters:";
            System.out.println(name);
        }

        public static void main(String[] args) {
            new Two5().getName();
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }

}
