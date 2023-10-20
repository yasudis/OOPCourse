package ru.academits.yasudis.vector_main;

import ru.academits.yasudis.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {34.3, 22.2, 1.0, 1.25};

        Vector vector1 = new Vector(array1);
        System.out.println("Vector1 " + vector1);

        System.out.println("Размерность vector1 равно " + vector1.getSize());

        Vector vector2 = new Vector(5);
        System.out.println("Vector2 " + vector2);

        Vector vector3 = new Vector(vector1);
        System.out.println("Vector3 " + vector3);

        Vector vector4 = new Vector(6, array1);
        System.out.println("Vector4 " + vector4);

        vector1.add(vector4);
        System.out.println("Сумма vector1 и vector4: " + vector1);

        vector4.subtract(vector1);
        System.out.println("Разность vector4 и vector1: " + vector4);

        vector4.multiplyByNumber(4);
        System.out.println("Скалярное произведение vector4: " + vector4);

        vector4.reverse();
        System.out.println("Инверсия вектора vector4: " + vector4);

        System.out.println("Длина вектора vector1: " + vector1.getLength());

        vector1.setCoordinateByIndex(1, 12);
        System.out.println("Задание значения  в индексе 1 в vector1 на 12: " + vector1);

        System.out.println("Vector4 имеет координату под индексом 1 = " + vector4.getCoordinateByIndex(1));

        Vector vector5 = Vector.getSum(vector3, vector4);
        System.out.println("Получение vector5 суммированием : " + vector5);

        double[] array2 = {2, 2, 2, 2};
        double[] array3 = {1, 2, 3, 4, 0, 0, 0};

        Vector vector6 = new Vector(array2);
        Vector vector7 = new Vector(array3);

        Vector vector8 = Vector.getDifference(vector6, vector7);
        System.out.println("Получение vector8 вычитанием: " + vector8);

        double scalarMultiply = Vector.getMultiplicationScalar(vector6, vector7);
        System.out.println("Скалярное произведение vector6 и vector7 равно: " + scalarMultiply);
    }
}