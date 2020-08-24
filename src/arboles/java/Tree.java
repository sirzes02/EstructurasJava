package arboles.java;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        } else if (value < current.getValue()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(addRecursive(current.getRight(), value));
        }

        return current;
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        } else if (value == current.getValue()) {
            return true;
        }

        return value < current.getValue() ?
                containsNodeRecursive(current.getLeft(), value) :
                containsNodeRecursive(current.getRight(), value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        } else if (value == current.getValue()) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            } else if (current.getRight() == null) {
                return current.getLeft();
            } else if (current.getLeft() == null) {
                return current.getRight();
            } else {
                int smallestValue = findSmallestValue(current.getRight());
                current.setValue(smallestValue);
                current.setRight(deleteRecursive(current.getRight(), smallestValue));
            }
        } else if (value < current.getValue()) {
            current.setLeft(deleteRecursive(current.getLeft(), value));
        } else {
            current.setRight(deleteRecursive(current.getRight(), value));
        }
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.getLeft() == null ?
                root.getValue() :
                findSmallestValue(root.getLeft());
    }

    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.getLeft());
            System.out.print(" " + node.getValue());
            traverseInOrder(node.getRight());
        }
    }

    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.getValue());
            traversePreOrder(node.getLeft());
            traversePreOrder(node.getRight());
        }
    }

    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.getLeft());
            traversePostOrder(node.getRight());
            System.out.print(" " + node.getValue());
        }
    }

    public void traverseLeverOrder() {
        if (root == null){
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {
            Node node = nodes.remove();

            System.out.print(" " + node.getValue());

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
            } else if (node.getRight() != null) {
                nodes.add(node.getRight());
            }
        }
    }

    public Node getRoot() {
        return root;
    }
}
