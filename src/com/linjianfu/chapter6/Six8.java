package com.linjianfu.chapter6;

public class Six8 extends ConnectionManager {
    public static void main(String[] args) {
        System.out.println("public class Six8 extends ConnectionManager");
        ConnectionManager cm = new ConnectionManager();
        System.out.println(cm.howManyleft);
        cm.getConnection();
        System.out.println(howManyleft);
        cm.getConnection();
        System.out.println(howManyleft);
        cm.getConnection();
        System.out.println(cm.getConnection());
        System.out.println(howManyleft);

    }

}

class ConnectionManager {
    static int howManyleft = 3;
    static Connection[] ca = new Connection[3];

    {
        for (Connection x : ca)
            x = Connection.makeConnection();
    }

    public static Connection getConnection() {
        if (howManyleft > 0)
            return ca[--howManyleft];
        else {
            System.out.println("No more connections");
            return null;
        }
    }

    ConnectionManager() {
        System.out.println("ConnectionManager");
    }


}

class Connection {
    private static int count = 0;
    private int i = 0;

    private Connection() {
        System.out.println("Connection");
    }

    static Connection makeConnection() {
        count++;
        return new Connection();
    }

    public static int howMany() {
        return count;
    }

    public String toString() {
        return ("Connection" + count);
    }
}