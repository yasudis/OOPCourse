package list_main;

import list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.insertFirstItem(10);
        list.insertFirstItem(1);
        list.insertFirstItem(23);
        list.insertFirstItem(111);
        list.insertFirstItem(56);
        list.insertFirstItem(28);

        System.out.println(list);

        System.out.println("getCount() = " + list.getCount());

        list.setValueByIndex(2, 2);
        System.out.println(list);

        SinglyLinkedList<Integer> listCopy = list.copy();
        System.out.println("копированный список равен: " + listCopy);

        list.reverseList();
        System.out.println("reverseList() = " + list);

        System.out.println("getFirstData() = " + list.getFirstData());

        System.out.println("removeItemByIndex() = " + list.removeItemByIndex(3));
        System.out.println(list);

        System.out.println("removeItemByValue() = " + list.removeItemByValue(1));
        System.out.println(list);

        list.setValueByIndex(9, 2);
        System.out.println(list);

        System.out.println("getItemByIndex() = " + list.getItemByIndex(2));

        System.out.println("setValueByIndex() = " + list.setValueByIndex(3, 1));
        System.out.println(list);
    }
}