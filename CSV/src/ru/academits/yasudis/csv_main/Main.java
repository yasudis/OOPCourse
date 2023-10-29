package ru.academits.yasudis.csv_main;

import ru.academits.yasudis.csv.Csv;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                Csv.convertCsvToHtml(args[0], args[1]);
            } else {
                System.out.println("Укажите два параметра:");
                System.out.println("Первый параметр - исходный файл,");
                System.out.println("Второй параметр - результирующий файл.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка: Не удалось выполнить операцию с файлом.");
        }
    }
}