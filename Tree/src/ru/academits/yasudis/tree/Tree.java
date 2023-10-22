package ru.academits.yasudis.tree;

import java.util.*;
import java.util.function.Consumer;

public class Tree<E> {
    private TreeNode<E> root;
    private int size;
    private final Comparator<E> comparator;

    public Tree() {
        this.comparator = null;
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

        TreeNode<E> currentNode = root;

        while (true) {
            int comparisonResult = compare(data, currentNode.getData());

            if (comparisonResult < 0) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new TreeNode<>(data));

                    break;
                }

                currentNode = currentNode.getLeft();

                continue;
            }

            if (currentNode.getRight() == null) {
                currentNode.setRight(new TreeNode<>(data));

                break;
            }

            currentNode = currentNode.getRight();
        }

        size++;
    }

    private ArrayList<TreeNode<E>> findNodeAndParent(E data) {
        TreeNode<E> parentNode = null;
        TreeNode<E> current = root;

        while (current != null) {
            int comparisonResult = compare(data, current.getData());

            if (comparisonResult == 0) {
                ArrayList<TreeNode<E>> nodes = new ArrayList<>();

                nodes.add(parentNode);
                nodes.add(current);

                return nodes;
            }

            if (comparisonResult < 0) {
                if (current.getLeft() == null) {
                    return null;
                }

                parentNode = current;
                current = current.getLeft();

                continue;
            }

            if (current.getRight() == null) {
                return null;
            }

            parentNode = current;
            current = current.getRight();
        }

        return null;
    }

    public boolean contains(E data) {
        return findNodeAndParent(data) != null;
    }

    public boolean remove(E data) {
        ArrayList<TreeNode<E>> nodes = findNodeAndParent(data);

        if (nodes == null) {
            return false;
        }

        TreeNode<E> parentNode = nodes.get(0);
        TreeNode<E> removingNode = nodes.get(1);

        if (removingNode == root) {
            removeRoot(removingNode);

            size--;

            return true;
        }

        if (removingNode.getLeft() == null && removingNode.getRight() == null) {
            if (parentNode.getRight() == removingNode) {
                parentNode.setRight(null);

                size--;

                return true;
            }

            parentNode.setLeft(null);

            size--;

            return true;
        }

        if (removingNode.getLeft() != null && removingNode.getRight() != null) {
            removeNodeWithTwoChildren(removingNode, parentNode);

            size--;

            return true;
        }

        if (parentNode.getLeft() == removingNode) {
            parentNode.setLeft(getChild(removingNode));
        } else {
            parentNode.setRight(getChild(removingNode));
        }

        size--;

        return true;
    }

    private void removeRoot(TreeNode<E> removingNode) {
        if (removingNode.getLeft() == null && removingNode.getRight() == null) {
            root = null;

            return;
        }

        if (removingNode.getRight() == null) {
            root = removingNode.getLeft();

            return;
        }

        if (removingNode.getLeft() == null) {
            root = removingNode.getRight();

            return;
        }

        removeNodeWithTwoChildren(removingNode,null);
    }

    private void removeNodeWithTwoChildren(TreeNode<E> removingNode, TreeNode<E> previousNode) {
        TreeNode<E> parentNode = null;
        TreeNode<E> leftmostNode = removingNode.getRight();

        while (leftmostNode.getLeft() != null) {
            parentNode = leftmostNode;
            leftmostNode = leftmostNode.getLeft();
        }

        if (parentNode != null) {
                parentNode.setLeft(leftmostNode.getRight());
        }

        if (previousNode != null) {
            if (previousNode.getLeft() == removingNode) {
                previousNode.setLeft(leftmostNode);
            } else {
                previousNode.setRight(leftmostNode);
            }
        }

        leftmostNode.setLeft(removingNode.getLeft());

        if (removingNode.getRight() != leftmostNode) {
            leftmostNode.setRight(leftmostNode.getRight());
        }

        if (removingNode == root) {
            root = leftmostNode;
        }
    }

    private TreeNode<E> getChild(TreeNode<E> removingNode) {
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

    public void visitInDepthRecursive(Consumer<E> consumer) {
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

        //noinspection unchecked
        return ((Comparable<E>) data1).compareTo(data2);
    }
}