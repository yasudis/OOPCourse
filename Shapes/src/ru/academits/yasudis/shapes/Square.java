package ru.academits.yasudis.shapes;

public class Square implements Shape {
    private final double height;
    private final double width;
    private final double area;
    private final double perimeter;

    public Square(double sideLength) {
        this.height = sideLength;
        width = sideLength;
        area = calculateArea();
        perimeter = calculatePerimeter();
    }

    private double calculateArea() {
        return height * width;
    }

    private double calculatePerimeter() {
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
    public String toString() {
        return "квадрат со стороной " + height;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(height);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) object;

        return width == square.width;
    }
}