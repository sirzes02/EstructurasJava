package grafos.java;

public class PairVertexWeight {
    private Vertex origin;
    private int weight;

    public PairVertexWeight(Vertex origin, int weight) {
        this.origin = origin;
        this.weight = weight;
    }

    public Vertex getOrigin() {
        return origin;
    }

    public void setOrigin(Vertex origin) {
        this.origin = origin;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}