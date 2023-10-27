package ru.academits.yasudis.array_list;

import java.util.*;

public class ArrayList<E> implements List<E> {
    private final static int DEFAULT_CAPACITY = 10;
    private E[] items;
    private int size;
    private int modCount;

    public ArrayList() {
        //noinspection unchecked
        items = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Невозможно создать ArrayList.Вместимость должна быть больше или равное 0." +
                    "Введённая вместимость: " + capacity);
        }

        //noinspection unchecked
        items = (E[]) new Object[capacity];
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
        return indexOf(object) >= 0;
    }

    private class ListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private final int initialModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Следующего элемента нет");
            }

            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("Список изменен во время прохода итератора");
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, size, array.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, array, 0, size);

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public boolean add(E item) {
        add(size, item);

        return true;
    }

    @Override
    public boolean remove(Object object) {
        int index = indexOf(object);

        if (index != -1) {
            remove(index);

            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object object : collection) {
            if (!contains(object)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> collection) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Переданный индекс " + index + " вне допустимого диапазона от 0 до " + size);
        }

        if (collection.isEmpty()) {
            return false;
        }

        ensureCapacity(size + collection.size());

        System.arraycopy(items, index, items, index + collection.size(), size - index);


        int i = index;

        for (E e : collection) {
            items[i] = e;
            i++;
        }

        modCount++;

        size += collection.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.isEmpty()) {
            return false;
        }

        final int initialSize = size;

        for (int i = size - 1; i >= 0; i--) {
            if (collection.contains(items[i])) {
                remove(i);
            }
        }

        return initialSize != size;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        final int initialSize = size;

        for (int i = size - 1; i >= 0; i--) {
            if (!collection.contains(items[i])) {
                remove(i);
            }
        }

        return initialSize != size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        modCount++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);

        return items[index];
    }

    @Override
    public E set(int index, E item) {
        checkIndex(index);

        E oldElement = items[index];
        items[index] = item;

        return oldElement;
    }

    @Override
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Переданный индекс " + index + " вне допустимого диапазона от 0 до" + size);
        }

        if (size == 0) {
            ensureCapacity(DEFAULT_CAPACITY);
        } else if (items.length <= size) {
            ensureCapacity(items.length * 2);
        }

        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;

        size++;
        modCount++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E removedItem = items[index];

        System.arraycopy(items, index + 1, items, index, size - 1 - index);
        items[size - 1] = null;

        size--;
        modCount++;

        return removedItem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }

        return -1;
    }

    public void ensureCapacity(int capacity) {
        if (items.length < capacity) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс должен быть от 0 до " + (size - 1) + ". Индекс = " + index);
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        result.append('[');

        for (int i = 0; i < size; i++) {
            result.append(items[i]).append(", ");
        }

        result.delete(result.length() - 2, result.length());

        result.append(']');
        return result.toString();
    }

    // ниже этого комментария методы не нужно делать
    @Override
    public java.util.ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public java.util.ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}