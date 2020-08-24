package grafos.java;

public class Vertex {
    private Vertex next;
    private Edge adjacent;
    private String name;

    public Vertex(String name) {
        next = null;
        adjacent = null;
        this.name = name;
    }

    public Vertex getNext() {
        return next;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

    public Edge getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(Edge adjacent) {
        this.adjacent = adjacent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
