package com.linjianfu.chapter18;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 书里的是过时了？从运行结果看，不必调用，Serializable类甚至也不必定义保存和恢复成员变量的方法，
 * 且与成员变量static与否似乎并没什么关系，同样保存和恢复。
 */
public class Eighteen30 {
    public static void main(String[] args) throws Exception {
        StoreCADState30.main(args);
        recoverCDState30();
    }

    @SuppressWarnings("unchecked")
    private static void recoverCDState30() throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Eighteen30.out"));
        // Read in the same order they were written:
//        System.out.println(in.readInt() + " " + in.readInt() + " " + in.readInt());
//        Circle.deserializeStaticState(in);
//        Square.deserializeStaticState(in);
//        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }

}

abstract class Shape implements Serializable {
    public static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    public String toString() {
        return getClass() +
                " color[" + getColor() + "] xPos[" + xPos +
                "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }
}

class Circle extends Shape {
    private static int color = RED;

//    public static void serializeStaticState(ObjectOutputStream os)
//            throws IOException {
//        os.writeInt(color);
//    }
//
//    public static void deserializeStaticState(ObjectInputStream os)
//            throws IOException {
//        color = os.readInt();
//    }

    public Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

//    public static void serializeStaticState(ObjectOutputStream os)
//            throws IOException {
//        os.writeInt(color);
//    }
//
//    public static void deserializeStaticState(ObjectInputStream os)
//            throws IOException {
//        color = os.readInt();
//    }

    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class Line extends Shape {
    private int color = RED;

//    public static void serializeStaticState(ObjectOutputStream os)
//            throws IOException {
//        os.writeInt(color);
//    }
//
//    public static void deserializeStaticState(ObjectInputStream os)
//            throws IOException {
//        color = os.readInt();
//    }

    public Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class StoreCADState30 {
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<Shape>();
        // Make some shapes:
        for (int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());
        // Set all the static colors to GREEN
        for (int i = 0; i < 10; i++)
            ((Shape) shapes.get(i)).setColor(Shape.GREEN);
        // Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("Eighteen30.out"));
//        out.writeInt(Circle.RED);
//        out.writeInt(Square.GREEN);
//        out.writeInt(Line.BLUE);
//        Circle.serializeStaticState(out);
//        Square.serializeStaticState(out);
//        Line.serializeStaticState(out);
        out.writeObject(shapes);
        // Display the shapes:
        System.out.println(shapes);
    }
}
