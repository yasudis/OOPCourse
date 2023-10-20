package ru.academits.yasudis.shapes;

public class Triangle implements Shape {
    private final double height;
    private final double width;
    private final double area;
    private final double perimeter;

    private final double x1;
    private final double x2;
    private final double x3;
    private final double y1;
    private final double y2;
    private final double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;

        height = calculateHeight();
        width = calculateWidth();
        area = calculateArea();
        perimeter = calculatePerimeter();
    }

    private double calculateHeight() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    private double calculateWidth() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    private double calculateArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    private double calculatePerimeter() {
        double side1Length = getSideLength(x1, y1, x2, y2);
        double side2Length = getSideLength(x2, y2, x3, y3);
        double side3Length = getSideLength(x1, y1, x3, y3);

        return side1Length + side2Length + side3Length;
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
        return "Треугольник c вершинами: (" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + "), (" + x3 + ", " + y3 + ")";
    }

    @Override
    public int hashCode() {
        final int prime = 29;
        int hashCode = 1;

        hashCode = prime * hashCode + Double.hashCode(x1);
        hashCode = prime * hashCode + Double.hashCode(x2);
        hashCode = prime * hashCode + Double.hashCode(x3);
        hashCode = prime * hashCode + Double.hashCode(y1);
        hashCode = prime * hashCode + Double.hashCode(y2);
        hashCode = prime * hashCode + Double.hashCode(y3);

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

        Triangle triangle = (Triangle) object;

        return triangle.x1 == x1 && triangle.x2 == x2 && triangle.x3 == x3
                && triangle.y1 == y1 && triangle.y2 == y2 && triangle.y3 == y3;
    }
}
