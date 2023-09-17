package vector_main;

import vector.Vector;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        double[] array = {1, 1, 1, 1};

        Vector vector1 = new Vector(array);

        System.out.print(vector1);
    }
}