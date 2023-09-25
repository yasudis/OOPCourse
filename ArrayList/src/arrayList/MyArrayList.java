package arrayList;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount = 0;

    public MyArrayList() {
        items = (T[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("не верный параметр");
        }

        items = (T[]) new Object[capacity];
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
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

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int currentModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("следующего элемента нет");
            }

            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("список изменен во время прохода итератора");
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <E> E[] toArray(E[] array) {
        if (array.length < items.length) {
            return (E[]) Arrays.copyOf(items, size, array.getClass());
        }

        System.arraycopy(items, 0, array, 0, size);

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    @Override
    public boolean add(T item) {
        if (size >= items.length) {
            increaseCapacity();
        }

        items[size] = item;
        size++;
        modCount++;

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
    public boolean addAll(Collection<? extends T> collection) {
        ensureCapacity(size + collection.size());

        int currentSize = size;

        for (T item : collection) {
            items[size] = item;
            size++;
            modCount++;
        }

        return currentSize != size;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("не верный параметр");
        }

        if (collection.size() == 0) {
            return false;
        }

        ensureCapacity(size + collection.size());
        System.arraycopy(items, index, items, index + collection.size(), size - index);

        modCount++;
        int i = index;

        for (T e : collection) {
            items[i] = e;
            i += 1;
            modCount++;
        }

        size += collection.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.size() == 0) {
            return false;
        }

        boolean isModified = false;

        for (int i = 0; i < size; i++) {
            if (collection.contains(items[i])) {
                remove(i);
                isModified = true;
            }
        }

        return isModified;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int currentSize = size;

        for (int i = 0; i < size; i++) {
            if (!collection.contains(items[i])) {
                remove(i);
                i--;
            }
        }

        return currentSize != size;
    }

    @Override
    public void clear() {
        items = (T[]) new Object[10];
        size = 0;
        modCount++;
    }

    @Override
    public T get(int index) {
        return items[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("не верный индекс");
        }

        modCount++;
        return items[index] = element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("не верный индекс");
        }

        if (items.length == size) {
            increaseCapacity();
        }

        System.arraycopy(items, index, items, index + 1, size - index);
        set(index, element);

        size++;
        modCount++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("не верный индекс");
        }

        T item = items[index];

        System.arraycopy(items, index + 1, items, index, size - 1 - index);
        items[size - 1] = null;

        size--;
        modCount++;

        return item;
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
        if (capacity <= 0) {
            throw new IllegalArgumentException("не верный параметр");
        }

        if (items.length < capacity) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    public void trimToSize() {
        if (items.length > size) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");

        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result.append(", ");
            }

            result.append(items[i]);
        }

        result.append("]");
        return result.toString();
    }

    // ниже этого коментария методы не нужно делать
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}