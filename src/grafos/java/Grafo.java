package grafos.java;

import java.util.Scanner;

public class Grafo {
    public static void main(String[] args) {
        Graph miGraph = new Graph();
        miGraph.initialize();
        int option;
        String name;
        String origin;
        String destiny;
        int weight;
        Scanner sc = new Scanner(System.in);

        miGraph.insertVertex("afghanistan");
        miGraph.insertVertex("albania");
        miGraph.insertVertex("algeria");
        miGraph.insertVertex("andorra");
        miGraph.insertVertex("angola");
        miGraph.insertVertex("argentina");
        miGraph.insertVertex("armenia");
        miGraph.insertVertex("australia");
        miGraph.insertVertex("austria");
        miGraph.insertVertex("azerbaijan");

        miGraph.insertEdge(miGraph.getVertex("afghanistan"), miGraph.getVertex("albania"), 800);
        miGraph.insertEdge(miGraph.getVertex("algeria"), miGraph.getVertex("afghanistan"), 400);
        miGraph.insertEdge(miGraph.getVertex("algeria"), miGraph.getVertex("andorra"), 300);
        miGraph.insertEdge(miGraph.getVertex("albania"), miGraph.getVertex("andorra"), 700);
        miGraph.insertEdge(miGraph.getVertex("andorra"), miGraph.getVertex("argentina"), 900);
        miGraph.insertEdge(miGraph.getVertex("andorra"), miGraph.getVertex("armenia"), 400);
        miGraph.insertEdge(miGraph.getVertex("andorra"), miGraph.getVertex("australia"), 350);
        miGraph.insertEdge(miGraph.getVertex("angola"), miGraph.getVertex("algeria"), 500);
        miGraph.insertEdge(miGraph.getVertex("angola"), miGraph.getVertex("albania"), 450);
        miGraph.insertEdge(miGraph.getVertex("angola"), miGraph.getVertex("BJX"), 250);
        miGraph.insertEdge(miGraph.getVertex("angola"), miGraph.getVertex("australia"), 500);
        miGraph.insertEdge(miGraph.getVertex("argentina"), miGraph.getVertex("azerbaijan"), 1200);
        miGraph.insertEdge(miGraph.getVertex("armenia"), miGraph.getVertex("azerbaijan"), 450);
        miGraph.insertEdge(miGraph.getVertex("australia"), miGraph.getVertex("azerbaijan"), 450);
        miGraph.insertEdge(miGraph.getVertex("australia"), miGraph.getVertex("austria"), 650);
        miGraph.insertEdge(miGraph.getVertex("austria"), miGraph.getVertex("angola"), 650);

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Vertex");
            System.out.println("2. Insert Edge");
            System.out.println("3. Adjacent list");
            System.out.println("4. Size");
            System.out.println("5. Remove vertex");
            System.out.println("6. remove Edge");
            System.out.println("7. Cancel");
            System.out.println("8. Width travel");
            System.out.println("9. Depth travel");
            System.out.println("10. First width");
            System.out.println("11. First depth");
            System.out.println("12. First better");
            System.out.println("13. Exit");
            System.out.println("Choose one:");
            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Insert the vertex name:");
                    name = sc.next();

                    miGraph.insertVertex(name);
                }
                case 2 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the origin vertex name: ");
                        origin = sc.next();
                        System.out.println("Insert the destiny vertex name: ");
                        destiny = sc.next();
                        System.out.println("Insert the weight ");
                        weight = sc.nextInt();

                        if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                            System.out.println("One of the vertex is invalid.");
                        } else {
                            miGraph.insertEdge(miGraph.getVertex(origin), miGraph.getVertex(destiny), weight);
                        }
                    }
                }
                case 3 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        miGraph.adjacentList();
                    }
                }
                case 4 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Size: " + miGraph.size());
                    }
                }
                case 5 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the vertex name to remove: ");
                        name = sc.next();

                        if (miGraph.getVertex(name) == null) {
                            System.out.println("Invalid vertex.");
                        } else {
                            miGraph.removeVertex(miGraph.getVertex(name));
                        }
                    }
                }
                case 6 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the origin vertex name: ");
                        origin = sc.next();
                        System.out.println("Insert the destiny vertex name: ");
                        destiny = sc.next();

                        if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                            System.out.println("Invelid vertices.");
                        } else {
                            miGraph.removeEdge(miGraph.getVertex(origin), miGraph.getVertex(destiny));
                        }
                    }
                }
                case 7 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        miGraph.cancel();
                    }
                }
                case 8 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the inicial vertice name:");
                        name = sc.next();

                        if (miGraph.getVertex(name) == null) {
                            System.out.println("That vertex is invalid.");
                        } else {
                            miGraph.widthTravel(miGraph.getVertex(name));
                        }
                    }
                }
                case 9 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the inicial vertice name:");
                        name = sc.next();

                        if (miGraph.getVertex(name) == null) {
                            System.out.println("That vertex is invalid.");
                        } else {
                            miGraph.depthTravel(miGraph.getVertex(name));
                        }
                    }
                }
                case 10 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the origin vertex name: ");
                        origin = sc.next();
                        System.out.println("Insert the destiny vertex name: ");
                        destiny = sc.next();

                        if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                            System.out.println("Invelid vertices.");
                        } else {
                            miGraph.firstWidth(miGraph.getVertex(origin), miGraph.getVertex(destiny));
                        }
                    }
                }
                case 11 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the origin vertex name: ");
                        origin = sc.next();
                        System.out.println("Insert the destiny vertex name: ");
                        destiny = sc.next();

                        if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                            System.out.println("Invelid vertices.");
                        } else {
                            miGraph.firstDepth(miGraph.getVertex(origin), miGraph.getVertex(destiny));
                        }
                    }
                }
                case 12 -> {
                    if (miGraph.empty()) {
                        System.out.println("The graph is empty.");
                    } else {
                        System.out.println("Insert the origin vertex name: ");
                        origin = sc.next();
                        System.out.println("Insert the destiny vertex name: ");
                        destiny = sc.next();

                        if (miGraph.getVertex(origin) == null || miGraph.getVertex(destiny) == null) {
                            System.out.println("Invelid vertices.");
                        } else {
                            miGraph.firstBest(miGraph.getVertex(origin), miGraph.getVertex(destiny));
                        }
                    }
                }
                case 13 -> System.out.println("Bye...");
                default -> System.out.println("Error, choose a correct option.");
            }

        } while (option != 13);
    }
}
