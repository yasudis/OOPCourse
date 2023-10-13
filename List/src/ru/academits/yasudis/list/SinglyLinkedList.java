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
        checkListSize();

        return head.getData();
    }

    private void checkListSize() {
        if (count == 0) {
            throw new NoSuchElementException("Коллекция пуста");
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Индекс должен быть от 0 до " + (count - 1) + ". Индекс= " + index);
        }
    }

    public void insertFirstData(E data) {
        head = new ListItem<>(data, head);
        count++;
    }

    private ListItem<E> getByIndex(int index) {
        ListItem<E> node = null;
        int i = 0;

        for (ListItem<E> current = head; current != null; current = current.getNext()) {
            if (index == i) {
                node = current;

                break;
            }

            i++;
        }

        return node;
    }

    public E getDataByIndex(int index) {
        return getByIndex(index).getData();
    }

    public E set(int index, E data) {
        checkIndex(index);

        ListItem<E> node = getByIndex(index);
        E oldValue = node.getData();
        node.setData(data);
        return oldValue;
    }

    public E removeByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<E> previousNode = getByIndex(index - 1);
        ListItem<E> currentNode = previousNode.getNext();

        previousNode.setNext(currentNode.getNext());
        count--;

        return currentNode.getData();
    }

    public void reverse() {
        ListItem<E> previousNode = null;
        ListItem<E> currentNode = head;

        while (currentNode != null) {
            ListItem<E> nextNode = currentNode.getNext();

            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        head = previousNode;
    }

    public SinglyLinkedList<E> getCopy() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<E> newSinglyLinkedList = new SinglyLinkedList<>();

        newSinglyLinkedList.head = new ListItem<>(head.getData());

        for (ListItem<E> oldNode = head.getNext(), newNode = newSinglyLinkedList.head; oldNode != null;
             oldNode = oldNode.getNext(), newNode = newNode.getNext()) {
            newNode.setNext(new ListItem<>(oldNode.getData(), oldNode.getNext()));
        }

        newSinglyLinkedList.count = count;

        return newSinglyLinkedList;
    }

    public boolean removeByData(E data) {
        ListItem<E> prev = null;
        ListItem<E> nextData = head;
        int i = 0;

        while (i < count) {
            if (!Objects.equals(nextData.getData(), data)) {
                prev = nextData;
                nextData = nextData.getNext();
                i++;
            } else {
                if (i == 0) {
                    head = nextData.getNext();
                } else {
                    prev.setNext(nextData.getNext());
                }

                count--;
                return true;
            }
        }

        return false;
    }

    public E removeFirst() {
        checkListSize();

        E deletedData = head.getData();

        head = head.getNext();
        count--;

        return deletedData;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");

        for (ListItem<E> node = head; node != null; node = node.getNext()) {
            sb.append(node.getData()).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());

        sb.append(']');
        return sb.toString();
    }
}