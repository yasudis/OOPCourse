package ru.academits.yasudis.shapes;

public class Square implements Shape {
    private double height;
    private double area;
    private double perimeter;

    public Square(double height) {
        this.height = height;
        area = setArea();
        perimeter = setPerimeter();
    }

    private double setArea() {
        return height * height;
    }

    private double setPerimeter() {
        return height + height;
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
