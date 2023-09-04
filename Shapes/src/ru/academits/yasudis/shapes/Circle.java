package ru.academits.yasudis.shapes;

public class Circle implements Shape {
    private double height;
    private double area;
    private double perimeter;

    public Circle(double height) {
        this.height = 2 * height;
        area = setArea(height);
        perimeter = setPerimeter(height);
    }

    private double setArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private double setPerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getWidth() {
        return height;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }
}