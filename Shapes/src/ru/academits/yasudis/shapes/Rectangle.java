package ru.academits.yasudis.shapes;

public class Rectangle implements Shape {
    private double height;
    private double width;
    private double area;
    private double perimeter;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        area = setArea();
        perimeter = setPerimeter();
    }

    private double setArea() {
        return height * width;
    }

    private double setPerimeter() {
        return height + width;
    }

    @Override
    public double getWidth() {
        return width;
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