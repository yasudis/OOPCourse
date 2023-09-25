import arrayList.MyArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new MyArrayList<>();

        list1.add(0, 3);
        list1.add(1, 2);
        list1.add(2, 8);
        list1.add(3, 5);
        list1.add(4, 1);

        System.out.println(list1);
        System.out.println("list1.size = " + list1.size());

        List<Integer> list2 = new ArrayList<>(Arrays.asList(9, 2, 2, 4));

        System.out.println("list1.lastIndexOf = " + list1.lastIndexOf(8));

        System.out.println("list1.get = " + list1.get(3));

        System.out.println("list1.set = " + list1.set(4, 9));
        System.out.println(list1);

        System.out.println("list1.remove(index) = " + list1.remove(3));
        System.out.println(list1);
        System.out.println("list1.size = " + list1.size());

        System.out.println("list1.remove(item) = " + list1.remove((Integer) 12));
        System.out.println(list1);
        System.out.println("list1.size = " + list1.size());

        System.out.println("list1.addAll = " + list1.addAll(list2));
        System.out.println("list1.addAll = " + list1);
        System.out.println("list1.size = " + list1.size());

        System.out.println("list1.removeAll = " + list1.removeAll(list2));
        System.out.println("list1.removeAll = " + list1);
        System.out.println("list1.size = " + list1.size());

        list1.add(22);
        System.out.println("list1.add(item) = " + list1);
        System.out.println("list1.size = " + list1.size());

        list1.add(7);
        System.out.println("list1.add(item) = " + list1);
        System.out.println("list1.size = " + list1.size());

        System.out.println("list2.retainAll = " + list1.retainAll(list2));
        System.out.println("list2.retainAll = " + list1);
        System.out.println("list1.size = " + list1.size());

        list1.clear();
        System.out.println(list1);

        MyArrayList<Integer> list3 = new MyArrayList<>(8);
        System.out.println(list3);
        list3.add(3);
        list3.add(8);
        list3.add(1);
        System.out.println(list3);

        System.out.println("list1.contains = " + list3.contains(1));

        System.out.println("list1.isEmpty = " + list3.isEmpty());

        System.out.println("list1.toArray() = " + Arrays.toString(list2.toArray()));

        System.out.println("list1.indexOf = " + list2.indexOf(6));

        list3.trimToSize();
        list3.ensureCapacity(10);
    }
}