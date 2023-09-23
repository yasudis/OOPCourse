package list;

import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public int getCount() {
        return count;
    }

    public T getFirstData() {
        return head.getData();
    }

    public void insertFirstItem(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public ListItem<T> getItemByIndex(int index) {
        ListItem<T> result = head;
        int i = 0;

        while (i < index) {
            result = result.getNext();
            i++;
        }

        return result;
    }

    public T setValueByIndex(T data, int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("индекс неверный");
        }

        ListItem<T> foundItemByIndex = getItemByIndex(index);
        T oldValue = foundItemByIndex.getData();
        foundItemByIndex.setData(data);
        return oldValue;
    }

    public T removeItemByIndex(int index) {
        if (index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("индекс неверный");
        }

        if (index == 0) {
            return removeFistItem();
        }

        ListItem<T> prevItem = getItemByIndex(index - 1);
        ListItem<T> nextData = prevItem.getNext();

        prevItem.setNext(nextData.getNext());
        count--;
        return nextData.getData();
    }

    public void reverseList() {
        if (count > 1) {
            ListItem<T> prev = null;
            ListItem<T> current = head;

            while (current != null) {
                ListItem<T> temp = current.getNext();
                current.setNext(prev);
                prev = current;
                head = current;
                current = temp;
            }
        }
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> result = new SinglyLinkedList<>();
        result.count = count;

        if (count == 0) {
            return result;
        }

        result.head = new ListItem<>(head.getData());
        ListItem<T> data = result.head;

        for (ListItem<T> nextData = head.getNext(); nextData != null; nextData = nextData.getNext()) {
            data.setNext(new ListItem<>(nextData.getData()));
            data = data.getNext();
        }

        return result;
    }

    public boolean removeItemByValue(T data) {
        ListItem<T> prev = null;
        ListItem<T> nextData = head;
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

    public T removeFistItem() {
        if (count == 0) {
            throw new ArrayIndexOutOfBoundsException("коллекция пуста");
        }

        if (count == 1) {
            T savedOldData = head.getData();
            head = null;
            count--;
            return savedOldData;
        }

        T oldData = head.getData();
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

        for (ListItem<T> data = head; data != null; data = data.getNext()) {
            sb.append(data.getData());
            if (data.getNext() != null) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}