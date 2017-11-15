package com.linjianfu.chapter5;

enum Rmb {
    ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
}

public class Five22 {
    public static void main(String[] args) {
        System.out.println("The six minimum face value of RMB is");
        for (Rmb s : Rmb.values())
            System.out.println(s + ", ordinal " + s.ordinal());
        new Five22(Rmb.ONE).describe();
        new Five22(Rmb.TEN).describe();
        new Five22(Rmb.HUNDRED).describe();
        /**
         *如下为作者的写法
         **/
        for (Rmb b : Rmb.values()) {
            System.out.println("Worth:");
            switch (b) {
                case ONE:
                    System.out.println("¥1");
                    break;
                case FIVE:
                    System.out.println("¥5");
                    break;
                case TEN:
                    System.out.println("¥10");
                    break;
                case TWENTY:
                    System.out.println("¥20");
                    break;
                case FIFTY:
                    System.out.println("¥50");
                    break;
                case HUNDRED:
                    System.out.println("¥100");
                    break;
                default:
                    break;
            }
        }

    }

    Rmb facevalue;

    Five22(Rmb facevalue) {
        this.facevalue = facevalue;
    }

    void describe() {
        System.out.println("This RMB is");
        switch (facevalue) {
            case ONE:
                System.out.println("one yuan");
                break;
            case FIVE:
                System.out.println("five yuan");
                break;
            case TEN:
                System.out.println("ten yuan");
                break;
            case TWENTY:
                System.out.println("twenty yuan");
                break;
            case FIFTY:
                System.out.println("fifty yuan");
                break;
            case HUNDRED:
                System.out.println("one hundred yuan");
                break;
            default:
                break;
        }

    }
}
