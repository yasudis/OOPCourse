package vector_main;

import vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {34.3, 22.2, 1.0, 1.25};

        Vector vector1 = new Vector(array1);
        System.out.println("vector1 " + vector1);

        System.out.println("размерность vector1 равно " + vector1.getSize());

        Vector vector2 = new Vector(5);
        System.out.println("vector2 " + vector2);

        Vector vector3 = new Vector(vector1);
        System.out.println("vector3 " + vector3);

        Vector vector4 = new Vector(6, array1);
        System.out.println("vector4 " + vector4);

        vector1.sumVectors(vector4);
        System.out.println("сумма vector1 и vector4: " + vector1);

        vector4.differenceVectors(vector1);
        System.out.println("разность vector4 и vector1: " + vector4);

        vector4.multiplyVectorOnNumber(4);
        System.out.println("скалярное произведение vector4: " + vector4);

        vector4.rotateVector();
        System.out.println("инверсия вектора vector4: " + vector4);

        System.out.println("Длина вектора vector1: " + vector1.getVectorLength());

        vector1.setCoordinateByIndex(1, 12);
        System.out.println("задание значения  в индексе 1 в vector1 на 12: " + vector1);

        System.out.println("vector4 имеет координату под индексом 1 = " + vector4.getCoordinateByIndex(1));

        Vector vector5 = Vector.getSumVectors(vector3, vector4);
        System.out.println("получение vector5 суммированием : " + vector5);

        double[] array2 = {2, 2, 2, 2};
        double[] array3 = {1, 2, 3, 4, 0, 0, 0};

        Vector vector6 = new Vector(array2);
        Vector vector7 = new Vector(array3);

        Vector vector8 = Vector.getDifferenceVectors(vector6, vector7);
        System.out.println("получение vector8 вычитанием: " + vector8);

        double scalarMultiply = Vector.getScalarMultiply(vector6, vector7);
        System.out.println("скалярное произведение vector6 и vector7 равно: " + scalarMultiply);
    }
}