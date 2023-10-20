package ru.academits.yasudis.shapes;

public class Square implements Shape {
    private final double sideLength;
    private final double area;
    private final double perimeter;

    public Square(double sideLength) {
        this.sideLength = sideLength;
        area = calculateArea();
        perimeter = calculatePerimeter();
    }

    private double calculateArea() {
        return sideLength * sideLength;
    }

    private double calculatePerimeter() {
        return 4 * sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
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
        return "Квадрат с шириной " + sideLength + " и высотой " + sideLength;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(sideLength);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) object;

        return sideLength == square.sideLength;
    }
}