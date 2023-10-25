package ru.academits.yasudis.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ArrayListHome/src/input.txt"))) {
            String line;

            ArrayList<String> fileLines = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                fileLines.add(line);
            }

            System.out.println("Список строк из файла: " + fileLines);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при открытии файла");
        }

        ArrayList<Integer> numbersList1 = new ArrayList<>(Arrays.asList(2, 1, 6, 5, 8, 34, 9, 8, 92, 5, 7, 99));
        System.out.println(numbersList1);

        for (int i = numbersList1.size() - 1; i >= 0; i--) {
            if (numbersList1.get(i) % 2 == 0) {
                numbersList1.remove(i);
            }
        }

        System.out.println("Список целых чисел после удаления четных чисел: " + numbersList1);

        ArrayList<Integer> numbersList2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 23, 3, 3, 2, 11, 2, 444, 44, 56, 6, 6));
        System.out.println("Список c повторениями: " + numbersList2);

        ArrayList<Integer> listWithoutRepetitions = new ArrayList<>(numbersList2.size());

        for (Integer number : numbersList2) {
            if (!listWithoutRepetitions.contains(number)) {
                listWithoutRepetitions.add(number);
            }
        }

        System.out.println("Список без повторений: " + listWithoutRepetitions);
    }
}