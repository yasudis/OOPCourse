package ru.academits.yasudis.shapes;

public class Circle implements Shape, Comparable<Shape> {
    private final double radius;
    private final double diameter;
    private final double area;
    private final double perimeter;

    public Circle(double radius) {
        this.radius = radius;
        diameter = 2 * radius;
        area = setArea(radius);
        perimeter = setPerimeter(radius);
    }

    private double setArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    private double setPerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getWidth() {
        return diameter;
    }

    @Override
    public double getHeight() {
        return radius;
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
    public int compareTo(Shape shape) {
        double result = area - shape.getArea();

        double epsilon = 1e-10;
        if (result > epsilon) {
            return 1;
        }

        if (result < -epsilon) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "круг площадью " + area;
    }

    @Override
    public int hashCode() {
        return (int) radius;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (!(object instanceof Shape shape)) {
            return false;
        }

        return shape.getArea() == this.getArea();
    }
}