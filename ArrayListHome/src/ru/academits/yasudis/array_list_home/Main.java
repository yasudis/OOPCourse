package ru.academits.yasudis.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> fileList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ArrayListHome/src/input.txt"))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                fileList.add(line);
            }

            System.out.println("Список из файла: " + fileList);
        } catch (IOException e) {
            System.out.println("Файл не найден");
        }

        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(2, 1, 6, 5, 8, 34, 9, 8, 92, 5, 7, 99));
        System.out.println(numbersList);

        for (int i = numbersList.size() - 1; i >= 0; i--) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
            }
        }

        System.out.println("Список целых чисел после удаления четных чисел: " + numbersList);

        ArrayList<Integer> numbersList2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 23, 3, 3, 2, 11, 2, 444, 44, 56, 6, 6));
        System.out.println("Список c повторениями: " + numbersList2);

        ArrayList<Integer> arrayListWithoutRepetitions = new ArrayList<>(numbersList2.size());

        for (Integer number : numbersList2) {
            if (!arrayListWithoutRepetitions.contains(number)) {
                arrayListWithoutRepetitions.add(number);
            }
        }

        System.out.println("Список без повторений: " + arrayListWithoutRepetitions);
    }
}