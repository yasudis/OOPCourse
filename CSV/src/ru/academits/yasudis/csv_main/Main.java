package ru.academits.yasudis.csv_main;

import ru.academits.yasudis.csv.CSV;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        String fileCsvToRead = "CSV/inputCSV.csv";
        String fileHtmlToWrite = "CSV/outputCSV.html";

        CSV csv = new CSV();
        try {
            csv.convertCsvToHtml(fileCsvToRead, fileHtmlToWrite);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден или пути содержат ошибки");
        }
    }
}