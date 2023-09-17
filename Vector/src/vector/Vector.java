package vector;

import java.util.Arrays;

public class Vector {
    private double[] coordinates;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("не верная размерность");
        }

        coordinates = new double[n];
    }

    public Vector(Vector vector) {
        coordinates = Arrays.copyOf(vector.coordinates, vector.coordinates.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Передан пустой вектор");
        }

        coordinates = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("не верно задано количество");
        }

        coordinates = Arrays.copyOf(array, n);
    }

    public int getSize() {
        return this.coordinates.length;
    }

    @Override
    public String toString() {
        if (this.coordinates.length == 1) {
            return "{" + coordinates[0] + "}";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < this.coordinates.length - 1; i++) {
            sb.append(coordinates[i]).append(", ");
        }

        sb.append(coordinates[coordinates.length - 1]);
        sb.append("}");

        return sb.toString();
    }
}
