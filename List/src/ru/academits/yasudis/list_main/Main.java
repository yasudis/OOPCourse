package ru.academits.yasudis.list_main;

import ru.academits.yasudis.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.insertFirstData(10);
        list.insertFirstData(1);
        list.insertFirstData(23);
        list.insertFirstData(111);
        list.insertFirstData(56);
        list.insertFirstData(28);

        System.out.println(list);

        System.out.println("getCount() = " + list.getCount());

        list.set(2, 2);
        System.out.println(list);

        SinglyLinkedList<Integer> listCopy = list.getCopy();
        System.out.println("копированный список равен: " + listCopy);

        list.reverse();
        System.out.println("reverse() = " + list);

        System.out.println("getFirst() = " + list.getFirst());

        System.out.println("removeByIndex() = " + list.removeByIndex(3));
        System.out.println(list);

        System.out.println("removeByData() = " + list.removeByData(1));
        System.out.println(list);

        list.set(2, 9);
        System.out.println(list);

        System.out.println("getDataByIndex() = " + list.getDataByIndex(2));

        System.out.println("set() = " + list.set(3, 1));
        System.out.println(list);
    }
}