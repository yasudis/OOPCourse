package ru.academits.yasudis.vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Неверная размерность, должно быть больше 0. Ведённая размерность " + size);
        }

        coordinates = new double[size];
    }

    public Vector(Vector vector) {
        coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Передан пустой массив.");
        }

        coordinates = Arrays.copyOf(array, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("Неверно задано количество, должно быть больше 0. Ведённое количество " + size);
        }

        coordinates = Arrays.copyOf(array, size);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.add(vector2);

        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.subtract(vector2);

        return resultVector;
    }

    public static double getMultiplicationScalar(Vector vector1, Vector vector2) {
        double product = 0;

        int minVectorSize = Math.min(vector1.coordinates.length, vector2.coordinates.length);

        for (int i = 0; i < minVectorSize; i++) {
            product += vector1.coordinates[i] * vector2.coordinates[i];
        }

        return product;
    }

    public int getSize() {
        return coordinates.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');

        int maxIndex = coordinates.length - 1;

        for (int i = 0; i < maxIndex; i++) {
            sb.append(coordinates[i]).append(", ");
        }

        sb.append(coordinates[maxIndex]);
        sb.append('}');

        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Vector vector = (Vector) object;

        return Arrays.equals(coordinates, vector.coordinates);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(coordinates);
    }

    public void add(Vector vector) {
        if (coordinates.length < vector.coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector.coordinates.length);
        }

        for (int i = 0; i < vector.coordinates.length; i++) {
            coordinates[i] += vector.coordinates[i];
        }
    }

    public void subtract(Vector vector) {
        if (coordinates.length < vector.coordinates.length) {
            coordinates = Arrays.copyOf(coordinates, vector.coordinates.length);
        }

        for (int i = 0; i < vector.coordinates.length; i++) {
            coordinates[i] -= vector.coordinates[i];
        }
    }

    public void multiplyByNumber(double number) {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] *= number;
        }
    }

    public void reverse() {
        multiplyByNumber(-1);
    }

    public double getLength() {
        double sum = 0;

        for (double coordinate : coordinates) {
            sum += coordinate * coordinate;
        }

        return Math.sqrt(sum);
    }

    public double getCoordinateByIndex(int index) {
        if (index < 0 || index >= coordinates.length) {
            throw new IndexOutOfBoundsException("Неверный индекс, индекс не должен выходить за границы от 0 до"
                    + (coordinates.length - 1) + ". Индекс равен " + index + ".");
        }

        return coordinates[index];
    }

    public void setCoordinateByIndex(int index, double value) {
        if (index < 0 || index >= coordinates.length) {
            throw new IndexOutOfBoundsException("Неверный индекс, индекс не должен выходить за границы от 0 до "
                    + (coordinates.length - 1) + ". Индекс равен " + index + ".");
        }

        coordinates[index] = value;
    }
}