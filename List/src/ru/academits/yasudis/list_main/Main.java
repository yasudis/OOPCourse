package ru.academits.yasudis.list_main;

import ru.academits.yasudis.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.insertFirst(10);
        list.insertFirst(1);
        list.insertFirst(23);
        list.insertFirst(111);
        list.insertFirst(56);
        list.insertFirst(28);

        System.out.println("Первоначальный список:\n" + list);

        System.out.println("getCount() = " + list.getCount());

        SinglyLinkedList<Integer> listCopy = list.getCopy();
        System.out.println("Копированный список равен: " + listCopy);

        list.reverse();
        System.out.println("reverse() = " + list);

        System.out.println("getFirst() = " + list.getFirst());

        System.out.println("removeByIndex(3) = " + list.removeByIndex(3));
        System.out.println(list);

        System.out.println("removeByData(1) = " + list.removeByData(1));
        System.out.println(list);

        System.out.println("get(2) = " + list.get(2));

        System.out.println("set(3, 1) = " + list.set(3, 1));
        System.out.println(list);
    }
}