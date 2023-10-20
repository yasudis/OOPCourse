package ru.academits.yasudis.shapes;

public class Circle implements Shape {
    private final double radius;
    private final double diameter;
    private final double area;
    private final double perimeter;

    public Circle(double radius) {
        this.radius = radius;
        diameter = 2 * radius;
        area = calculateArea(radius);
        perimeter = calculatePerimeter(radius);
    }

    private static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    private static double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getWidth() {
        return diameter;
    }

    @Override
    public double getHeight() {
        return diameter;
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
        return "Круг радиусом " + radius;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(radius);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Circle circle = (Circle) object;

        return radius == circle.radius;
    }
}