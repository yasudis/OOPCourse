package ru.academits.yasudis.list;

import java.util.Objects;

public class SinglyLinkedList<E> {
    private ListItem<E> head;
    private int count;

    public int getCount() {
        return count;
    }

    public E getFirstData() {
        return head.getData();
    }

    public void insertFirstItem(E data) {
        head = new ListItem<>(data, head);
        count++;
    }

    private ListItem<E> getItemByIndex(int index) {
        ListItem<E> result = head;
        int i = 0;

        while (i < index) {
            result = result.getNext();
            i++;
        }

        return result;
    }

    public E setValueByIndex(E data, int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("индекс неверный");
        }

        ListItem<E> foundItemByIndex = getItemByIndex(index);
        E oldValue = foundItemByIndex.getData();
        foundItemByIndex.setData(data);
        return oldValue;
    }

    public E removeItemByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("индекс неверный");
        }

        if (index == 0) {
            return removeFistItem();
        }

        ListItem<E> prevItem = getItemByIndex(index - 1);
        ListItem<E> nextData = prevItem.getNext();

        prevItem.setNext(nextData.getNext());
        count--;
        return nextData.getData();
    }

    public void reverseList() {
        if (count > 1) {
            ListItem<E> prev = null;
            ListItem<E> current = head;

            while (current != null) {
                ListItem<E> temp = current.getNext();
                current.setNext(prev);
                prev = current;
                head = current;
                current = temp;
            }
        }
    }

    public SinglyLinkedList<E> copy() {
        SinglyLinkedList<E> result = new SinglyLinkedList<>();
        result.count = count;

        if (count == 0) {
            return result;
        }

        result.head = new ListItem<>(head.getData());
        ListItem<E> data = result.head;

        for (ListItem<E> nextData = head.getNext(); nextData != null; nextData = nextData.getNext()) {
            data.setNext(new ListItem<>(nextData.getData()));
            data = data.getNext();
        }

        return result;
    }

    public boolean removeItemByValue(E data) {
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

    public E removeFistItem() {
        if (count == 0) {
            throw new ArrayIndexOutOfBoundsException("коллекция пуста");
        }

        if (count == 1) {
            E savedOldData = head.getData();
            head = null;
            count--;
            return savedOldData;
        }

        E oldData = head.getData();
        head = head.getNext();
        count--;
        return oldData;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "список пуст.";
        }

        StringBuilder sb = new StringBuilder("[");

        for (ListItem<E> data = head; data != null; data = data.getNext()) {
            sb.append(data.getData());
            if (data.getNext() != null) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}