package ru.academits.yasudis.range_main;

import ru.academits.yasudis.range.Range;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Range range = new Range(10, 25.5);

        System.out.println("Диапазон начинается: от " + range.getFrom() + " до " + range.getTo());
        System.out.println("Длина диапазона равна: " + range.getLength());

        range.setFrom(30.5);
        range.setTo(80.5);

        System.out.println("Диапазон начинается: от " + range.getFrom() + " до " + range.getTo());
        System.out.println("Длина диапазона равна: " + range.getLength());

        System.out.println("Введите число:");
        double number = scanner.nextDouble();

        if (range.isRange(number)) {
            System.out.println("Число " + number + " в диапазоне.");
        } else {
            System.out.println("Число " + number + " не в диапазоне");
        }
    }
}
