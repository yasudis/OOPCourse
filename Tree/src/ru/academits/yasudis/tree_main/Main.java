package ru.academits.yasudis.tree_main;

import ru.academits.yasudis.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> numbers1 = new Tree<>();

        numbers1.add(45);
        numbers1.add(1);
        numbers1.add(2);
        numbers1.add(5);
        numbers1.add(11);
        numbers1.add(16);
        numbers1.add(5);
        numbers1.add(6);
        numbers1.add(8);
        numbers1.add(15);
        numbers1.add(29);
        numbers1.add(54);
        numbers1.add(22);
        numbers1.add(31);
        numbers1.add(22);

        boolean contains = numbers1.contains(55);
        System.out.println("Наличие числа в дереве: " + contains);

        System.out.println("Количество элементов в дереве: " + numbers1.getSize());

        boolean remove = numbers1.remove(11);
        System.out.println("Удаление числа в дереве: " + remove);

        System.out.println("Количество элементов в дереве: " + numbers1.getSize());

        System.out.println("Обход дерева в глубину с рекурсией:");
        numbers1.visitInDepthRecursion(System.out::println);
        System.out.println();

        System.out.println("Обход дерева в глубину:");
        numbers1.visitInDepth(System.out::println);
        System.out.println();

        System.out.println("Обход дерева в ширину:");
        numbers1.visitInWidth(System.out::println);
        System.out.println();
    }
}