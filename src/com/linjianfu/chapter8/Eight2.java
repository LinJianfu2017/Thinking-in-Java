package com.linjianfu.chapter8;

import java.util.Random;
//Exercise 2,3,4.
class Shape {
    void draw() {
    }

    void erase() {
    }

    void prt() {
        System.out.println("Shape.prt()");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    void prt() {
        System.out.println("Circle.prt()");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    void erase() {
        System.out.println("Square..erase()");
    }

    @Override
    void prt() {
        System.out.println("Square.prt()");
    }
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    void erase() {
        System.out.println("Triangle.erase()");
    }

    @Override
    void prt() {
        System.out.println("Triangle.prt()");
    }
}

class RandomShapeGenerator {
    private Random rand = new Random(47);

    public Shape next() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();

        }
    }
}

public class Eight2 {
    private static RandomShapeGenerator rs = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] s = new Shape[9];
        for (int i = 0; i < s.length; i++)
            s[i] = rs.next();
        for (Shape shape : s) {
            shape.draw();
            shape.prt();
        }
        for (Shape shp : s)
            shp.erase();

    }
}

