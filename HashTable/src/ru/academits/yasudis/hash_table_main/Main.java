package ru.academits.yasudis.hash_table_main;

import ru.academits.yasudis.hash_table.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer> hashTable1 = new HashTable<>(15);

        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(7, 0, 1, 33, 15, 4, 5, 18, 7, 11, 53, 91));

        System.out.println("addAll() = " + hashTable1.addAll(list1));
        System.out.println(hashTable1);
        System.out.println("size() = " + hashTable1.size());

        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        System.out.println("removeAll() = " + hashTable1.removeAll(list3));
        System.out.println(hashTable1);
        System.out.println("size() = " + hashTable1.size());

        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(11, 22, 33, 44, 55));

        System.out.println("retainAll() = " + hashTable1.retainAll(list2));
        System.out.println(hashTable1);
        System.out.println("size() = " + hashTable1.size());

        System.out.println("add() = " + hashTable1.add(65));
        System.out.println(hashTable1);
        System.out.println("size() = " + hashTable1.size());

        System.out.println("remove() = " + hashTable1.remove(76));
        System.out.println(hashTable1);
        System.out.println("size() = " + hashTable1.size());

        ArrayList<Integer> list4 = new ArrayList<>(Arrays.asList(5555, 6666, 7777, 8888));

        System.out.println("containsAll() = " + hashTable1.containsAll(list4));

        System.out.println("contains() = " + hashTable1.contains(78));

        System.out.println("toArray() = " + Arrays.toString(hashTable1.toArray()));

        Integer[] array = hashTable1.toArray(new Integer[10]);
        System.out.println("toArray(T[] toString) = " + Arrays.toString(array));

        System.out.println("clear():");
        hashTable1.clear();
        System.out.println(hashTable1);

        HashTable<Integer> hashTable2 = new HashTable<>();

        System.out.println();
        hashTable2.addAll(list2);
        System.out.println(hashTable2);
        System.out.println("size() = " + hashTable2.size());

        for (Integer value : hashTable2) {
            System.out.print(value + " ");
        }
    }
}