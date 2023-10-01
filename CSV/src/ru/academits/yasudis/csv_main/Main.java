package ru.academits.yasudis.csv_main;

import ru.academits.yasudis.csv.CSV;

public class Main {
    public static void main(String[] args) {
        String fileToRead = "inputCSV.csv";
        String fileToWrite = "outputCSV.html";

        CSV csv = new CSV();
        csv.convertCSVtoHTML(fileToRead, fileToWrite);
    }
}