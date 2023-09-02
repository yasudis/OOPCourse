package ru.academits.yasudis.range_main;

import ru.academits.yasudis.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range rangeA = new Range(10, 25.5);
        Range rangeB = new Range(50, 20);

        System.out.println("Диапазон начинается: от " + rangeA.getFrom() + " до " + rangeA.getTo());
        System.out.println("Длина диапазона равна: " + rangeA.getLength());

        rangeA.setFrom(30.5);
        rangeA.setTo(80.5);

        System.out.println("Диапазон начинается: от " + rangeA.getFrom() + " до " + rangeA.getTo());
        System.out.println("Длина диапазона равна: " + rangeA.getLength());

        System.out.println("Введите число:");
        double number = scanner.nextDouble();

        if (rangeA.isRange(number)) {
            System.out.println("Число " + number + " в диапазоне.");
        } else {
            System.out.println("Число " + number + " не в диапазоне");
        }

        Double[] intersectionTwoIntervals = rangeA.getIntersectionTwoIntervals(rangeB);

        if (intersectionTwoIntervals != null) {
            System.out.println("Пересечение двух диапазонов равно: " + Arrays.toString(intersectionTwoIntervals));
        } else {
            System.out.println("Пересечения нет.");
        }

        Range[] combinedIntervals = rangeA.combiningIntervals(rangeB);

        if (combinedIntervals[1] == null) {
            System.out.println("Объединения двух диапазонов равно: " + combinedIntervals[0].showIntervals());
        } else {
            System.out.println("Объединения двух диапазонов равно: " + combinedIntervals[0].showIntervals() + " и " +
                    combinedIntervals[1].showIntervals());
        }

        Range[] subtractingIntervals = rangeA.subtractingIntervals(rangeB);

        if (subtractingIntervals[0] == null) {
            if (subtractingIntervals[1] == null) {
                System.out.println("Разность двух диапазонов равно нулю.");
            } else {
                System.out.println("Разность двух диапазонов равно: " + subtractingIntervals[1].showIntervals());
            }
        } else {
            if (subtractingIntervals[1] == null) {
                System.out.println("Разность двух диапазонов равно: " + subtractingIntervals[0].showIntervals());
            } else {
                System.out.println("Разность двух диапазонов равно: " + subtractingIntervals[0].showIntervals() + "и" +
                        subtractingIntervals[1].showIntervals());
            }
        }

    }
}
