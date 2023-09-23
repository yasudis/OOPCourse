package arrayListHome_main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome/src/input.txt"))) {
            ArrayList<String> array = new ArrayList<>();

            while (scanner.hasNext()) {
                array.add(scanner.next());
            }

            System.out.println(array);
        } catch (FileNotFoundException e) {
            System.out.println("файл не найден");
        }

        ArrayList<Integer> arrayInteger = new ArrayList<>(Arrays.asList(2, 1, 6, 5, 8, 34, 9, 8, 92, 5, 7, 99));
        System.out.println(arrayInteger);

        for (int i = arrayInteger.size() - 1; i >= 0; i--) {
            if (arrayInteger.get(i) % 2 == 0) {
                arrayInteger.remove(i);
            }
        }

        System.out.println("отфильтрованный список: " + arrayInteger);

        ArrayList<Integer> arrayListWithRepetitions = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));
        System.out.println("Список c повторениями: " + arrayListWithRepetitions);

        ArrayList<Integer> arrayListWithoutRepetitions = new ArrayList<>();

        for (Integer arrayListWithRepetition : arrayListWithRepetitions) {
            if (!arrayListWithoutRepetitions.contains(arrayListWithRepetition)) {
                arrayListWithoutRepetitions.add(arrayListWithRepetition);
            }
        }

        System.out.println("Список без повторений: " + arrayListWithoutRepetitions);
    }
}