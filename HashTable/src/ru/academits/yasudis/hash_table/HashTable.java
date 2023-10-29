package ru.academits.yasudis.hash_table;

import java.util.*;

public class HashTable<E> implements Collection<E> {
    private final static int DEFAULT_CAPACITY = 10;
    private final ArrayList<E>[] lists;
    private int size;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        lists = new ArrayList[DEFAULT_CAPACITY];
    }

    public HashTable(int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException("Размер должен быть больше 0, Размер = " + arraySize);
        }

        //noinspection unchecked
        lists = new ArrayList[arraySize];
    }

    private int getIndex(Object object) {
        if (object == null) {
            return 0;
        }

        return Math.abs(object.hashCode() % lists.length);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object object) {
        int index = getIndex(object);

        return lists[index] != null && lists[index].contains(object);
    }

    @Override
    public Iterator<E> iterator() {
        return new HashTableIterator();
    }

    private class HashTableIterator implements Iterator<E> {
        private int listIndex;
        private int itemIndex = -1;
        private int passedItemsCount;
        private final int initialModCount = modCount;

        public boolean hasNext() {
            return passedItemsCount < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Конец таблицы.");
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("HashTable был изменен во время итерации.");
            }

            while (lists[listIndex] == null || lists[listIndex].size() - 1 == itemIndex) {
                listIndex++;
                itemIndex = -1;
            }

            itemIndex++;
            passedItemsCount++;

            return lists[listIndex].get(itemIndex);
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;

        for (E item : this) {
            array[i] = item;
            i++;
        }

        return array;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(toArray(), size, array.getClass());
        }

        int i = 0;

        for (E item : this) {
            //noinspection unchecked
            array[i] = (T) item;
            i++;
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public boolean add(E item) {
        int index = getIndex(item);

        if (lists[index] == null) {
            lists[index] = new ArrayList<>();
        }

        lists[index].add(item);

        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object object) {
        int index = getIndex(object);

        if (lists[index] != null && lists[index].remove(object)) {
            size--;
            modCount++;
            return true;
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> collection) {
        int initialSize = size;

        for (E item : collection) {
            add(item);
        }

        return initialSize != size;
    }

    @Override
    public void clear() {
        if (size > 0) {
            modCount++;
            Arrays.fill(lists, null);

            size = 0;
        }
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int initialSize = size;

        for (ArrayList<E> list : lists) {
            if (list != null) {
                size -= list.size();
                list.retainAll(collection);
                size += list.size();
            }
        }

        if (initialSize != size) {
            modCount++;
        }

        return initialSize != size;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int initialSize = size;

        for (ArrayList<E> list : lists) {
            if (list != null) {
                size -= list.size();
                list.removeAll(collection);
                size += list.size();
            }
        }

        if (initialSize != size) {
            modCount++;
        }

        return initialSize != size;
    }

    @Override
    public boolean containsAll(Collection collection) {
        for (Object item : collection) {
            if (!contains(item)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");

        int i = 0;

        for (ArrayList<E> list : lists) {
            stringBuilder.append(i).append(' ').append(list).append(System.lineSeparator());

            i++;
        }

        stringBuilder.append(']');

        return stringBuilder.toString();
    }
}