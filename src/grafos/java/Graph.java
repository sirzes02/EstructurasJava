package grafos.java;

import kotlin.Pair;

import java.util.*;

public class Graph {
    private Vertex first;

    public Graph() {
        first = null;
    }

    public void initialize() {
        first = null;
    }

    public boolean empty() {
        return first == null;
    }

    public int size() {
        int cont = 0;
        Vertex aux = first;

        while (aux != null) {
            cont++;
            aux = aux.getNext();
        }

        return cont;
    }

    public Vertex getVertex(String name) {
        Vertex aux = first;

        while (aux != null) {
            if (aux.getName().equals(name)) {
                return aux;
            }

            aux = aux.getNext();
        }

        return null;
    }

    public void insertVertex(String name) {
        Vertex newVertex = new Vertex(name);

        if (empty()) {
            first = newVertex;
        } else {
            Vertex aux = first;

            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            aux.setNext(newVertex);
        }
    }

    public void insertEdge(Vertex origin, Vertex destiny, int weight) {
        Edge newEdge = new Edge(weight);
        Edge aux = origin.getAdjacent();

        if (aux == null) {
            origin.setAdjacent(newEdge);
        } else {
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }

            aux.setNext(newEdge);
        }
        newEdge.setAdjacent(destiny);
    }

    public void adjacentList() {
        Vertex vertexAux = first;
        Edge edgeAux;

        while (vertexAux != null) {
            System.out.print(vertexAux.getName() + "->");
            edgeAux = vertexAux.getAdjacent();

            while (edgeAux != null) {
                if (edgeAux.getAdjacent() != null) {
                    System.out.print(edgeAux.getAdjacent().getName() + "->");
                }

                edgeAux = edgeAux.getNext();
            }

            vertexAux = vertexAux.getNext();

            System.out.println();
        }
    }

    public void cancel() {
        first = null;
    }

    public void removeEdge(Vertex origin, Vertex destiny) {
        Edge current = origin.getAdjacent();
        boolean flag = false;

        if (current == null) {
            System.out.println("The origin vertex have no edges.");
        } else if (current.getAdjacent() == destiny) {
            origin.setAdjacent(current.getNext());
        } else {
            Edge before = null;

            while (current != null) {
                if (current.getAdjacent() == destiny) {
                    flag = true;
                    assert before != null;
                    before.setNext(current.getNext());
                    break;
                }

                before = current;
                current = current.getNext();
            }

            if (!flag) {
                System.out.println("Those two vertices aren't connected.");
            }
        }
    }

    public void removeVertex(Vertex vert) {
        Vertex current = first;
        Edge aux;

        while (current != null) {
            aux = current.getAdjacent();

            while (aux != null) {
                if (aux.getAdjacent() == vert) {
                    removeEdge(current, aux.getAdjacent());
                    break;
                }

                aux = aux.getNext();
            }

            current = current.getNext();
        }

        current = first;

        if (vert == first) {
            first = first.getNext();
        } else {
            Vertex before = null;

            while (current != vert) {
                before = current;
                current = current.getNext();
            }

            before.setNext(current.getNext());
        }
    }

    public void widthTravel(Vertex origin) {
        Vertex current;
        Queue<Vertex> currentQueue = new LinkedList<>();
        List<Vertex> currentList = new LinkedList<>();
        boolean flag;
        boolean flag2;

        currentQueue.add(origin);

        while (!currentQueue.isEmpty()) {
            flag = false;
            current = currentQueue.poll();

            for (Vertex vertex : currentList) {
                if (vertex == current) {
                    flag = true;
                    break;
                }
            }

            if (!flag && current != null) {
                System.out.print(current.getName() + ", ");
                currentList.add(current);

                Edge aux = current.getAdjacent();

                while (aux != null) {
                    flag2 = false;

                    for (Vertex vertex : currentList) {
                        if (aux.getAdjacent() == vertex) {
                            flag2 = true;
                            break;
                        }
                    }

                    if (!flag2) {
                        currentQueue.add(aux.getAdjacent());
                    }

                    aux = aux.getNext();
                }
            }
        }
    }

    public void depthTravel(Vertex origin) {
        Vertex current;
        Stack<Vertex> currentStack = new Stack<>();
        List<Vertex> currentList = new LinkedList<>();
        boolean flag;
        boolean flag2;

        currentStack.push(origin);

        while (!currentStack.empty()) {
            flag = false;
            current = currentStack.pop();

            for (Vertex vertex : currentList) {
                if (vertex == current) {
                    flag = true;
                    break;
                }
            }

            if (!flag && current != null) {
                System.out.print(current.getName() + ", ");
                currentList.add(current);

                Edge aux = current.getAdjacent();

                while (aux != null) {
                    flag2 = false;

                    for (Vertex vertex : currentList) {
                        if (aux.getAdjacent() == vertex) {
                            flag2 = true;
                            break;
                        }
                    }

                    if (!flag2) {
                        currentStack.push(aux.getAdjacent());
                    }

                    aux = aux.getNext();
                }
            }
        }
    }

    public void firstWidth(Vertex origin, Vertex destiny) {
        Queue<Vertex> currentQueue = new LinkedList<>();
        Stack<Pair<Vertex, Vertex>> currentStack = new Stack<>();
        List<Vertex> currentList = new LinkedList<>();
        Vertex current;
        Vertex currentDestiny;
        Edge aux;
        boolean flag;
        boolean flag2;
        boolean flag3 = false;

        currentQueue.add(origin);

        while (!currentQueue.isEmpty()) {
            flag = false;
            current = currentQueue.poll();

            for (Vertex vertex : currentList) {
                if (current == vertex) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                if (current == destiny) {
                    flag3 = true;
                    currentDestiny = destiny;

                    while (!currentStack.isEmpty()) {
                        System.out.print(currentDestiny.getName() + "<-");

                        while (!currentStack.empty() && currentStack.peek().component2() != currentDestiny) {
                            currentStack.pop();
                        }

                        if (!currentStack.empty()) {
                            currentDestiny = currentStack.peek().component1();
                        }
                    }

                    break;
                }

                currentList.add(current);

                aux = current.getAdjacent();

                while (aux != null) {
                    flag2 = false;

                    for (Vertex vertex : currentList) {
                        if (aux.getAdjacent() == vertex) {
                            flag2 = true;
                            break;
                        }
                    }

                    if (!flag2) {
                        currentQueue.add(aux.getAdjacent());
                        currentStack.push(new Pair<>(current, aux.getAdjacent()));
                    }

                    aux = aux.getNext();
                }
            }
        }

        if (!flag3) {
            System.out.println("There is no path between these two vertices.");
        }
    }

    public void firstDepth(Vertex origin, Vertex destiny) {
        Vertex currentVertex;
        Vertex currentDestiny;
        Stack<Vertex> currentStack = new Stack<>();
        List<Vertex> currentList = new LinkedList<>();
        Stack<Pair<Vertex, Vertex>> currentStackPair = new Stack<>();
        Edge aux;
        boolean flag;
        boolean flag2;
        boolean flag3 = false;

        currentStack.push(origin);

        while (!currentStack.empty()) {
            flag = false;
            currentVertex = currentStack.pop();

            for (Vertex vertex : currentList) {
                if (currentVertex == vertex) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                if (currentVertex == destiny) {
                    flag3 = true;
                    currentDestiny = destiny;

                    while (!currentStackPair.empty()) {
                        System.out.print(currentDestiny.getName() + "<-");

                        while (!currentStackPair.empty() && currentStackPair.peek().component2() != currentDestiny) {
                            currentStackPair.pop();
                        }

                        if (!currentStackPair.empty()) {
                            currentDestiny = currentStackPair.peek().component1();
                        }
                    }

                    break;
                }

                currentList.add(currentVertex);

                aux = currentVertex.getAdjacent();

                while (aux != null) {
                    flag2 = false;

                    for (Vertex vertex : currentList) {
                        if (aux.getAdjacent() == vertex) {
                            flag2 = true;
                            break;
                        }
                    }

                    if (!flag2) {
                        currentStack.push(aux.getAdjacent());
                        currentStackPair.push(new Pair<>(currentVertex, aux.getAdjacent()));
                    }

                    aux = aux.getNext();
                }
            }
        }

        if (!flag3) {
            System.out.println("There is no path between these two vertices.");
        }
    }

    public void firstBest(Vertex origin, Vertex destiny) {
        List<PairVertexWeight> costsList = new LinkedList<>();
        List<PairVertexWeight> orderList = new LinkedList<>();
        Stack<Pair<Vertex, Vertex>> currentStack = new Stack<>();
        Vertex currentVertex;
        Vertex currentDestiny;
        Edge aux;
        int currentCost;
        boolean flag;
        boolean flag2 = false;

        costsList.add(new PairVertexWeight(origin, 0));
        orderList.add(new PairVertexWeight(origin, 0));

        while (!orderList.isEmpty()) {
            currentVertex = orderList.get(orderList.size() - 1).getOrigin();
            currentCost = orderList.get(orderList.size() - 1).getWeight();

            orderList.remove(orderList.size() - 1);

            if (currentVertex == destiny) {
                System.out.println("Cost: " + currentCost);

                flag2 = true;
                currentDestiny = destiny;

                while (!currentStack.empty()) {
                    System.out.println(currentDestiny.getName() + "<-");

                    while (!currentStack.empty() && currentStack.peek().component2() != currentDestiny) {
                        currentStack.pop();
                    }

                    if (!currentStack.empty()) {
                        currentDestiny = currentStack.peek().component1();
                    }
                }

                break;
            }

            aux = currentVertex.getAdjacent();

            while (aux != null) {
                flag = false;
                currentCost += aux.getWeight();

                for (PairVertexWeight vertexWeight : costsList) {
                    if (aux.getAdjacent() == vertexWeight.getOrigin()) {
                        flag = true;

                        if (currentCost < vertexWeight.getWeight()) {
                            vertexWeight.setWeight(currentCost);

                            for (PairVertexWeight pairVertexWeight : orderList) {
                                if (pairVertexWeight.getOrigin() == aux.getAdjacent()) {
                                    pairVertexWeight.setWeight(currentCost);
                                }
                            }

                            orderList.sort(Comparator.comparingInt(PairVertexWeight::getWeight));
                            currentStack.push(new Pair<>(currentVertex, aux.getAdjacent()));
                            currentCost -= aux.getWeight();
                        }
                    }
                }

                if (!flag) {
                    costsList.add(new PairVertexWeight(aux.getAdjacent(), currentCost));
                    orderList.add(new PairVertexWeight(aux.getAdjacent(), currentCost));
                    orderList.sort(Comparator.comparingInt(PairVertexWeight::getWeight));

                    currentStack.push(new Pair<>(currentVertex, aux.getAdjacent()));
                    currentCost -= aux.getWeight();
                }

                aux = aux.getNext();
            }
        }

        if (!flag2) {
            System.out.println("There is no path between these two vertices.");
        }
    }
}
