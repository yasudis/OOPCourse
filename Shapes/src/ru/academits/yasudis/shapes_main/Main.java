package ru.academits.yasudis.shapes_main;

import ru.academits.yasudis.comporator.AreaComparator;
import ru.academits.yasudis.comporator.PerimeterComparator;
import ru.academits.yasudis.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(10),
                new Rectangle(5.0, 20.0),
                new Circle(5.5),
                new Triangle(0, 10, 15, 1, 4, 22),
                new Square(8),
                new Rectangle(1.0, 27.0),
                new Circle(9.5),
                new Triangle(-10, 10, -15, -1, 4, 22),
                new Rectangle(3.0, 9.0),
                new Circle(10.5),
        };

        System.out.println(Arrays.toString(shapes));
        Arrays.sort(shapes, new AreaComparator());

        System.out.println("Максимальная площадь среди массива фигур это:");
        System.out.println(shapes[shapes.length - 1] + " с площадью - " + shapes[shapes.length - 1].getArea());

        Arrays.sort(shapes, new PerimeterComparator());

        System.out.println("Максимальный периметр среди массива фигур это:");
        System.out.println(shapes[shapes.length - 2] + " с периметром - " + shapes[shapes.length - 2].getPerimeter());
    }
}