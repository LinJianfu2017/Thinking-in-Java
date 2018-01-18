package com.linjianfu.chapter14;

import java.util.Arrays;
import java.util.List;

//Exercise 3,4,5,6.
abstract class Shape {
    boolean flag = false;

    void draw() {
        System.out.println(this + ".draw()");
    }

    void rotate() {
        if (this instanceof Circle) {
            System.out.println(this + " rotated");
        }
    }

    abstract public String toString();
}

class Circle extends Shape {
    @Override
    public String toString() {
        return (this.flag ? "marked " : "unmarked: ") + "Circle ";
    }
}

class ACircle extends Circle {
    int i = 0;

    @Override
    public String toString() {
        return "ACircle";
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return (this.flag ? "marked " : "unmarked: ") + "Square ";
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return (this.flag ? "marked " : "unmarked: ") + "Triangle ";
    }
}

class Rhomboid extends Shape {
    @Override
    public String toString() {
        return (this.flag ? "marked " : "unmarked: ") + "Rhomboid ";
    }
}

public class Fourteen4 {
    public static void setFlag(Shape s) {
        if (s instanceof Rhomboid)
            ((Rhomboid) s).flag = true;
    }

    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(),
                new Square(), new Triangle(), new Rhomboid());
        for (Shape shape : shapeList) {
            setFlag(shape);
            shape.draw();
            shape.rotate();
        }
        Shape s = shapeList.get(3);
        System.out.println(s.getClass().getSimpleName());
        Rhomboid r = (Rhomboid) s;
        if (s instanceof Circle) {
            ((Circle) s).draw();//RTTI:Class cast exception.
        } else if (!(s instanceof Circle))
            System.out.println("(Circle)s is not a Circle!");
    }
}
