package ru.academits.yasudis.shapes_main;

import ru.academits.yasudis.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public abstract class Main implements Comparator<Shape>, Comparable<Shape> {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];

        shapes[0] = new Square(10);
        shapes[1] = new Rectangle(5.0, 20.0);
        shapes[2] = new Circle(5.5);
        shapes[3] = new Triangle(0, 10, 15, 1, 4, 22);
        shapes[4] = new Square(8);
        shapes[5] = new Rectangle(1.0, 27.0);
        shapes[6] = new Circle(9.5);
        shapes[7] = new Triangle(-10, 10, -15, -1, 4, 22);
        shapes[8] = new Rectangle(3.0, 9.0);
        shapes[9] = new Circle(10.5);

        System.out.println(Arrays.toString(shapes));

        Arrays.sort(shapes);
        System.out.println(shapes[shapes.length - 1] + " с периметром - " + shapes[shapes.length - 1].getPerimeter() +
                ", с высотой - " + shapes[shapes.length - 1].getHeight() + ", с шириной - " + shapes[shapes.length - 1].getWidth());

        System.out.println(Arrays.toString(shapes));
    }
}