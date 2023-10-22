package ru.academits.yasudis.tree_main;

import ru.academits.yasudis.tree.Tree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> numbers1 = new Tree<>();

        numbers1.add(8);
        numbers1.add(3);
        numbers1.add(10);
        numbers1.add(1);
        numbers1.add(6);
        numbers1.add(14);
        numbers1.add(4);
        numbers1.add(7);
        numbers1.add(13);

        System.out.println("Наличие числа в дереве: " + numbers1.contains(55));

        System.out.println("Количество элементов в дереве: " + numbers1.getSize());

        System.out.println("Удаление числа в дереве: " + numbers1.remove(11));

        System.out.println("Количество элементов в дереве: " + numbers1.getSize());

        System.out.println("Обход дерева в глубину с рекурсией:");
        numbers1.visitInDepthRecursive(value -> System.out.print(value + " "));
        System.out.println();

        System.out.println("Обход дерева в глубину:");
        numbers1.visitInDepth(value -> System.out.print(value + " "));
        System.out.println();

        System.out.println("Обход дерева в ширину:");
        numbers1.visitInWidth(value -> System.out.print(value + " "));
        System.out.println();
    }
}