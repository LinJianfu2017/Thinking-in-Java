package com.linjianfu.chapter6;

public class Six8 extends ConnectionManager {
    public static void main(String[] args) {
        System.out.println("public class Six8 extends ConnectionManager");
        ConnectionManager cm = new ConnectionManager();
        System.out.println(cm.howManyleft);
        System.out.println(cm.getConnection());
        System.out.println(howManyleft);
        System.out.println(cm.getConnection());
        System.out.println(howManyleft);
        cm.getConnection();
        System.out.println(cm.getConnection());
        System.out.println(howManyleft);

    }

}

class ConnectionManager {
    static int howManyleft = 3;
    static Connection[] ca = new Connection[3];

    /**"我觉得可以把代码块理解为无返回值,无方法名的一个方法, 并在对象初始化的时候执行代码块--->
     *  同样的也有静态代码块, static{}
     *  也就是说一个类只允许存在成员变量和成员方法, 这里代码块也是属于成员方法, 只是特殊的成员方法."
     */
      {
        for (Connection x : ca)
            x = Connection.makeConnection();
    }

    public static Connection getConnection() {
        if (howManyleft > 0)
            return ca[--howManyleft];/**----------------标记--------此处返回啥？----一个空引用罢了
         -相当于分配存储空间？--*/
        else {
            System.out.println("No more connections");
            return null;
        }
    }
//
//    {
//        System.out.println("nimei");
//    }

    /**
     * ---------上下两个注释，试验“代码块”用的，都得加大括号才能编译通过----
     ****/
//    {
//        if (howManyleft == 0) System.out.println("哪些字段没写在方法里的要用大括号括起来？");
//    }

    ConnectionManager() {
        System.out.println("ConnectionManager");
    }


}

class Connection {
    private static int count = 0;
//    private int i = 0;

    private Connection() {
        System.out.println("Connection");
    }

    static Connection makeConnection() {
//        count++;
        return new Connection();
    }
/**
 * 此处howMany()啥用？
 * */
//    public static int howMany() {
//        return count;
//    }
//
//    public String toString() {
//        return ("Connection" + count);
//    }
}