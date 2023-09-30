package ru.academits.yasudis.hashTable;

import java.util.*;

public class MyHashTable<E1> implements Collection<E1> {
    private int size;
    private ArrayList<E1>[] hashArray;
    private int modCount;

    public MyHashTable() {
        hashArray = new ArrayList[10];
    }

    public MyHashTable(int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException("Размер должен быть больше 0");
        }

        hashArray = new ArrayList[arraySize];
    }

    private int getIndex(Object object) {
        if (object == null) {
            return 0;
        }

        return Math.abs(object.hashCode() % hashArray.length);
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

        if (hashArray[index] == null) {
            return false;
        }

        return hashArray[index].contains(object);
    }

    @Override
    public Iterator<E1> iterator() {
        return new MyHashTableIterator();
    }

    private class MyHashTableIterator implements Iterator<E1> {
        private int currentItem = -1;
        private int currentIndex = 0;
        private int currentIndexItem = -1;
        private int currentModCount = modCount;

        public boolean hasNext() {
            return currentItem + 1 < size;
        }

        public E1 next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Конец таблицы.");
            }

            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("HashTable был изменен во время итерации.");
            }

            while (hasNext()) {
                if (hashArray[currentIndex] == null) {
                    currentIndex++;
                } else {
                    currentIndexItem++;

                    if (currentIndexItem == hashArray[currentIndex].size()) {
                        currentIndex++;
                        currentIndexItem = -1;
                    } else {
                        currentItem++;
                        return hashArray[currentIndex].get(currentIndexItem);
                    }
                }
            }

            return null;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;

        for (E1 item : this) {
            array[i] = item;
            i++;
        }

        return array;
    }

    @Override
    public <E2> E2[] toArray(E2[] array) {
        if (array.length < size) {
            return (E2[]) Arrays.copyOf(toArray(), size, array.getClass());
        }

        int index = 0;

        for (E1 element : this) {
            array[index] = (E2) element;
            index++;
        }

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public boolean add(E1 object) {
        int index = getIndex(object);

        if (hashArray[index] == null) {
            hashArray[index] = new ArrayList<>();
        }

        hashArray[index].add(object);

        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object object) {
        int index = getIndex(object);

        if (hashArray[index] == null) {
            return false;
        }

        if (hashArray[index].remove(object)) {
            size--;
            modCount++;

            return true;
        }

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E1> collection) {
        int currentSize = size;

        for (E1 item : collection) {
            add(item);
        }

        return currentSize != size;
    }

    @Override
    public void clear() {
        if (size > 0) {
            modCount++;
        }

        Arrays.fill(hashArray, null);

        size = 0;
    }

    @Override
    public boolean retainAll(Collection collection) {
        int currentSize = size;

        for (ArrayList<E1> indexList : hashArray) {
            if (indexList != null) {
                size -= indexList.size();
                indexList.retainAll(collection);
                size += indexList.size();
            }
        }

        if (currentSize != size) {
            modCount++;
        }

        return currentSize != size;
    }

    @Override
    public boolean removeAll(Collection collection) {
        int currentSize = size;

        for (ArrayList<E1> indexList : hashArray) {
            if (indexList != null) {
                size -= indexList.size();
                indexList.removeAll(collection);
                size += indexList.size();
            }
        }

        if (currentSize != size) {
            modCount++;
        }

        return currentSize != size;
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
        StringBuilder line = new StringBuilder();

        for (int i = 0; i < hashArray.length; i++) {
            line.append(i).append(": ");
            line.append(hashArray[i]);

            if (i != hashArray.length - 1) {
                line.append(System.lineSeparator());
            }
        }

        return line.toString();
    }
}