package grafos.java;

public class Edge {
    private Edge next;
    private Vertex adjacent;
    private int weight;

    public Edge(int weight) {
        next = null;
        adjacent = null;
        this.weight = weight;
    }

    public Edge getNext() {
        return next;
    }

    public void setNext(Edge next) {
        this.next = next;
    }

    public Vertex getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(Vertex adjacent) {
        this.adjacent = adjacent;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
