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

    public static Vector getSumVectors(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.sumVectors(vector2);

        return resultVector;
    }

    public static double getScalarMultiply(Vector vector1, Vector vector2) {
        double resultMultiply = 0;

        int minVectorLength = Math.min(vector1.coordinates.length, vector2.coordinates.length);

        for (int i = 0; i < minVectorLength; i++) {
            resultMultiply += vector1.coordinates[i] * vector2.coordinates[i];
        }

        return resultMultiply;
    }

    public static Vector getDifferenceVectors(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);
        resultVector.differenceVectors(vector2);

        return resultVector;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Vector vector = (Vector) object;

        if (this.coordinates.length != vector.coordinates.length) {
            return false;
        }

        for (int i = 0; i < this.coordinates.length; i++) {
            if (this.coordinates[i] != vector.coordinates[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.coordinates);
    }

    public void sumVectors(Vector vector) {
        if (this.coordinates.length < vector.coordinates.length) {
            this.coordinates = Arrays.copyOf(this.coordinates, vector.coordinates.length);
        }

        for (int i = 0; i < vector.coordinates.length; i++) {
            this.coordinates[i] += vector.coordinates[i];
        }
    }

    public void differenceVectors(Vector vector) {
        if (this.coordinates.length < vector.coordinates.length) {
            this.coordinates = Arrays.copyOf(this.coordinates, vector.coordinates.length);
        }

        for (int i = 0; i < vector.coordinates.length; i++) {
            this.coordinates[i] -= vector.coordinates[i];
        }
    }

    public void multiplyVectorOnNumber(double number) {
        for (int i = 0; i < this.coordinates.length; i++) {
            this.coordinates[i] *= number;
        }
    }

    public void rotateVector() {
        this.multiplyVectorOnNumber(-1);
    }

    public double getVectorLength() {
        double lengthVector = 0;

        for (double coordinate : this.coordinates) {
            lengthVector += Math.pow(coordinate, 2);
        }

        return Math.sqrt(lengthVector);
    }

    public double getCoordinateByIndex(int index) {
        if (index < 0 || index >= this.coordinates.length) {
            throw new ArrayIndexOutOfBoundsException("неверный индекс");
        }
        return this.coordinates[index];
    }

    public void setCoordinateByIndex(int index, double value) {
        if (index < 0 || index >= this.coordinates.length) {
            throw new ArrayIndexOutOfBoundsException("неверный индекс");
        }

        this.coordinates[index] = value;
    }
}
