package listasDobles.java;

public class Node {
    private String id;
    private Node next;
    private Node before;

    public Node(String id) {
        this.id = id;
        next = null;
        before = null;
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

    public Node getBefore() {
        return before;
    }

    public void setBefore(Node before) {
        this.before = before;
    }
}
