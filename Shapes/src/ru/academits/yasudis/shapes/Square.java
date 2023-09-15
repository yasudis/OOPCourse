package ru.academits.yasudis.shapes;

public class Square implements Shape, Comparable<Shape> {
    private final double height;
    private final double width;
    private final double area;
    private final double perimeter;


    public Square(double sideLength) {
        this.height = sideLength;
        width = sideLength;
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
        return "квадрат площадью " + area;
    }

    @Override
    public int hashCode() {
        return (int) height;
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