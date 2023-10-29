package ru.academits.yasudis.shapes;

public class Rectangle implements Shape {
    private final double height;
    private final double width;
    private final double area;
    private final double perimeter;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        area = calculateArea();
        perimeter = calculatePerimeter();
    }

    private double calculateArea() {
        return height * width;
    }

    private double calculatePerimeter() {
        return 2 * height + 2 * width;
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

    @Override
    public String toString() {
        return "Прямоугольник с шириной " + width + " и высотой " + height;
    }

    @Override
    public int hashCode() {
        final int prime = 29;
        int hashCode = 1;

        hashCode = prime * hashCode + Double.hashCode(width);
        hashCode = prime * hashCode + Double.hashCode(height);

        return hashCode;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;

        return width == rectangle.width && height == rectangle.height;
    }
}