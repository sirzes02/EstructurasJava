package listas.java;

public class Node {
    private String id;
    private Node next;

    public Node(String id) {
        this.id = id;
        next = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
