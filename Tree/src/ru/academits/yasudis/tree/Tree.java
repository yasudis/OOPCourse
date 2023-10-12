package ru.academits.yasudis.tree;

import java.util.*;
import java.util.function.Consumer;

public class Tree<E> {
    private TreeNode<E> root;
    private int size;
    private Comparator<E> comparator;

    public Tree() {
    }

    public Tree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int getSize() {
        return size;
    }

    public void add(E data) {
        if (size == 0) {
            root = new TreeNode<>(data);

            size++;

            return;
        }

        TreeNode<E> current = root;

        while (true) {
            int comparisonResult = compare(data, current.getData());

            if (comparisonResult < 0) {
                if (current.getLeft() == null) {
                    current.setLeft(new TreeNode<>(data));

                    break;
                }

                current = current.getLeft();

                continue;
            }

            if (current.getRight() == null) {
                current.setRight(new TreeNode<>(data));

                break;
            }

            current = current.getRight();
        }

        size++;
    }

    private ArrayList<TreeNode<E>> findNode(E data) {
        TreeNode<E> previousNode = null;
        TreeNode<E> current = root;

        while (current != null) {
            int comparisonResult = compare(data, current.getData());

            if (comparisonResult == 0) {
                ArrayList<TreeNode<E>> nodes = new ArrayList<>();

                nodes.add(previousNode);
                nodes.add(current);

                return nodes;
            }

            if (comparisonResult < 0) {
                if (current.getLeft() == null) {
                    return null;
                }

                previousNode = current;
                current = current.getLeft();

                continue;
            }

            if (current.getRight() == null) {
                return null;
            }

            previousNode = current;
            current = current.getRight();
        }

        return null;
    }

    public boolean contains(E data) {
        return findNode(data) != null;
    }

    public boolean remove(E data) {
        ArrayList<TreeNode<E>> nodes = findNode(data);

        if (nodes == null) {
            return false;
        }

        TreeNode<E> previousNode = nodes.get(0);
        TreeNode<E> removingNode = nodes.get(1);

        if (removingNode == root) {
            removeRoot(removingNode, previousNode);

            size--;

            return true;
        }

        if (removingNode.getLeft() == null && removingNode.getRight() == null) {
            if (previousNode.getRight() == removingNode) {
                previousNode.setRight(null);

                size--;

                return true;
            }

            previousNode.setLeft(null);

            size--;

            return true;
        }

        if (removingNode.getLeft() != null && removingNode.getRight() != null) {
            removeNodeWithTwoChildren(removingNode, previousNode);

            size--;

            return true;
        }

        if (previousNode.getLeft() == removingNode) {
            previousNode.setLeft(determineChild(removingNode));
        } else {
            previousNode.setRight(determineChild(removingNode));
        }

        size--;

        return true;
    }

    private void removeRoot(TreeNode<E> removingNode, TreeNode<E> previousNode) {
        if (removingNode.getLeft() == null && removingNode.getRight() == null) {
            root = null;

            return;
        }

        if (removingNode.getRight() == null) {
            root = removingNode.getLeft();

            return;
        }

        removeNodeWithTwoChildren(removingNode, previousNode);
    }

    private void removeNodeWithTwoChildren(TreeNode<E> removingNode, TreeNode<E> previousNode) {
        TreeNode<E> parent = null;
        TreeNode<E> leftmost = removingNode.getRight();

        while (leftmost.getLeft() != null) {
            parent = leftmost;

            leftmost = leftmost.getLeft();
        }

        if (parent != null) {
            if (leftmost.getRight() != null) {
                parent.setLeft(leftmost.getRight());
            } else {
                parent.setLeft(null);
            }
        }

        if (previousNode != null) {
            if (previousNode.getLeft() == removingNode) {
                previousNode.setLeft(leftmost);
            } else {
                previousNode.setRight(leftmost);
            }
        }

        leftmost.setLeft(removingNode.getLeft());

        if (removingNode.getRight() == leftmost) {
            leftmost.setRight(leftmost.getRight());
        } else {
            leftmost.setRight(removingNode.getRight());
        }

        if (removingNode == root) {
            root = leftmost;
        }
    }

    private TreeNode<E> determineChild(TreeNode<E> removingNode) {
        if (removingNode.getLeft() != null) {
            return removingNode.getLeft();
        }

        return removingNode.getRight();
    }

    public void visitInWidth(Consumer<E> consumer) {
        if (size == 0) {
            return;
        }

        Queue<TreeNode<E>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<E> current = queue.remove();

            consumer.accept(current.getData());

            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }

            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    }

    public void visitInDepthRecursion(Consumer<E> consumer) {
        if (size == 0) {
            return;
        }

        visit(root, consumer);
    }

    private void visit(TreeNode<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }

        consumer.accept(node.getData());

        if (node.getLeft() != null) {
            visit(node.getLeft(), consumer);
        }

        if (node.getRight() != null) {
            visit(node.getRight(), consumer);
        }
    }

    public void visitInDepth(Consumer<E> consumer) {
        if (size == 0) {
            return;
        }

        Deque<TreeNode<E>> stack = new LinkedList<>();

        stack.addLast(root);

        while (!stack.isEmpty()) {
            TreeNode<E> current = stack.removeLast();

            consumer.accept(current.getData());

            if (current.getRight() != null) {
                stack.addLast(current.getRight());
            }

            if (current.getLeft() != null) {
                stack.addLast(current.getLeft());
            }
        }
    }

    private int compare(E data1, E data2) {
        if (comparator != null) {
            return comparator.compare(data1, data2);
        }

        if (data1 == null && data2 == null) {
            return 0;
        }

        if (data1 == null) {
            return -1;
        }

        if (data2 == null) {
            return 1;
        }

        Comparable<E> value = (Comparable<E>) data1;

        return value.compareTo(data2);
    }
}