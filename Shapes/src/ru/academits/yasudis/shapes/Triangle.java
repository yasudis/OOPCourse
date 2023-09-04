package ru.academits.yasudis.shapes;

public class Triangle implements Shape {
    private double height;
    private double width;
    private double area;
    private double perimeter;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {

        height = setHeight(x1, x2, x3);
        width = setWidth(y1, y2, y3);
        area = setArea(x1, x2, x3, y1, y2, y3);
        perimeter = setPerimeter(x1, x2, x3, y1, y2, y3);
    }

    private double setHeight(double x1, double x2, double x3) {
        double xMax = x1;
        xMax = Math.max(xMax, x2);
        xMax = Math.max(xMax, x3);

        double xMin = x1;
        xMin = Math.min(xMin, x2);
        xMin = Math.min(xMin, x3);

        return xMax - xMin;
    }

    private double setWidth(double y1, double y2, double y3) {
        double yMax = y1;
        yMax = Math.max(yMax, y2);
        yMax = Math.max(yMax, y3);

        double yMin = y1;
        yMin = Math.min(yMin, y2);
        yMin = Math.min(yMin, y3);

        return yMax - yMin;
    }

    private double setArea(double x1, double x2, double x3, double y1, double y2, double y3) {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    private double setPerimeter(double x1, double x2, double x3, double y1, double y2, double y3) {
        double side1Length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double side2Length = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double side3Length = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

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
}
