package ru.academits.yasudis.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<E> {
    private ListItem<E> head;
    private int count;

    public int getCount() {
        return count;
    }

    public E getFirst() {
        checkListIsEmpty();

        return head.getData();
    }

    private void checkListIsEmpty() {
        if (count == 0) {
            throw new NoSuchElementException("Коллекция пуста");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс должен быть от 0 до " + (count - 1) + ". Индекс= " + index);
        }
    }

    public void insertFirst(E data) {
        head = new ListItem<>(data, head);
        count++;
    }

    private ListItem<E> getItem(int index) {
        ListItem<E> resultItem = null;
        int i = 0;

        for (ListItem<E> currentItem = head; currentItem != null; currentItem = currentItem.getNext()) {
            if (index == i) {
                resultItem = currentItem;

                break;
            }

            i++;
        }

        return resultItem;
    }

    public E get(int index) {
        checkIndex(index);

        return getItem(index).getData();
    }

    public E set(int index, E data) {
        checkIndex(index);

        ListItem<E> item = getItem(index);
        E currentData = item.getData();
        item.setData(data);
        return currentData;
    }

    public E removeByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<E> previousItem = getItem(index - 1);
        ListItem<E> currentItem = previousItem.getNext();

        previousItem.setNext(currentItem.getNext());
        count--;

        return currentItem.getData();
    }

    public void reverse() {
        ListItem<E> previousItem = null;
        ListItem<E> currentItem = head;

        while (currentItem != null) {
            ListItem<E> nextItem = currentItem.getNext();

            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    public SinglyLinkedList<E> getCopy() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<E> copySinglyLinkedList = new SinglyLinkedList<>();

        copySinglyLinkedList.head = new ListItem<>(head.getData());

        for (ListItem<E> currentItem = head.getNext(), copyItem = copySinglyLinkedList.head;
             currentItem != null;
             currentItem = currentItem.getNext(), copyItem = copyItem.getNext()) {
            copyItem.setNext(new ListItem<>(currentItem.getData()));
        }

        copySinglyLinkedList.count = count;

        return copySinglyLinkedList;
    }

    public boolean removeByData(E data) {
        if (count == 0) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            removeFirst();

            return true;
        }

        for (ListItem<E> currenItem = head.getNext(), previousItem = head; currenItem != null;
             previousItem = currenItem, currenItem = currenItem.getNext()) {
            if (Objects.equals(data, currenItem.getData())) {
                assert previousItem != null;
                previousItem.setNext(currenItem.getNext());

                count--;

                return true;
            }
        }

        return false;
    }

    public E removeFirst() {
        checkListIsEmpty();

        E removedData = head.getData();

        head = head.getNext();
        count--;

        return removedData;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");

        for (ListItem<E> item = head; item != null; item = item.getNext()) {
            sb.append(item.getData()).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append(']');

        return sb.toString();
    }
}