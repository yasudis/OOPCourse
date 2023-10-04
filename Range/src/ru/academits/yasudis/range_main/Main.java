package ru.academits.yasudis.range_main;

import ru.academits.yasudis.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range1 = new Range(10, 25.5);
        Range range2 = new Range(50, 20);

        System.out.println("Диапазон начинается: от " + range1.getFrom() + " до " + range1.getTo());
        System.out.println("Длина диапазона равна: " + range1.getLength());

        range1.setFrom(30.5);
        range1.setTo(80.5);

        System.out.println("Диапазон начинается: от " + range1.getFrom() + " до " + range1.getTo());
        System.out.println("Длина диапазона равна: " + range1.getLength());

        System.out.println("Введите число:");
        double number = scanner.nextDouble();

        if (range1.isInside(number)) {
            System.out.println("Число " + number + " в диапазоне.");
        } else {
            System.out.println("Число " + number + " не в диапазоне");
        }

        Range intersection = range1.getIntersection(range2);
        System.out.println("Пересечение двух диапазонов равно: " + Arrays.toString(new Range[]{intersection}));

        Range[] union = range1.getUnion(range2);
        System.out.println("Объединения двух диапазонов равно: " + Arrays.toString(union));

        Range[] difference = range1.getDifference(range2);
        System.out.println("Разность двух диапазонов равно: " + Arrays.toString(difference));
    }
}