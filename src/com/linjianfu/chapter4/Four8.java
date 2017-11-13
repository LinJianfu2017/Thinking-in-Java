package com.linjianfu.chapter4;

import java.util.Random;

public class Four8 {
    static void existbreak(char c) {
        switch (c) {
            case 'a':
                System.out.println("alimama");
                break;
            case 'c':
                System.out.println("woca");
                break;
            case 'n':
                System.out.println("fibonacci");
                return;
//                break;
            case 'j':
                System.out.println("Fujian Province");
                break;
            case 'q':
                System.out.println("QQ~~");
                break;
            case 'h':
                System.out.println("HelloWorld");
                break;
            case 'w':
                System.out.println("Weapon Lin");
                break;
            case 'l':
                System.out.println("Lin Jianfu");
                break;
            default:
                System.out.println("请重新输入");
        }
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        outer:
        for (int i = 0; i++ < 5; ) {
            inner:
            for (int j = 0; j++ < 3; ) {
                int c = rand.nextInt(26) + 'a';
                System.out.println((char) c + "," + c + ":");
                switch (c) {
                    case 'b':
                        System.out.println("continue outer");
//                        continue outer;
//                        return;
                        break outer;
                    case 'd':
                        System.out.println("break inner");
                        break inner;
                    case 'e':
                        System.out.println("continue inner");
                        continue inner;
                    case 't':
                        System.out.println("return");
                        return;
                    case 'w':
                        existbreak('w');
                        continue outer;
                    default:
                        existbreak((char) c);
                        System.out.println("0000");
                }
                System.out.println("1111");

            }
            System.out.println("2222");
        }
        System.out.println("3333");
    }

}
