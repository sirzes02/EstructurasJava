package listas.java;

import java.util.Scanner;

public class List {
    private Node list;

    public List() {
        list = null;
    }

    public void insert(String auxId) {
        if (search(auxId) == null) {
            Node newNode = new Node(auxId);

            if (list == null) {
                list = newNode;
            } else {
                Node aux = list;
                list = newNode;
                list.setNext(aux);
            }
        } else {
            System.out.println("This ID already exists.");
        }
    }

    public void show() {
        if (list != null) {
            Node current = list;

            while (current != null) {
                System.out.println("the id: " + current.getId());

                current = current.getNext();
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void update(String auxId) {
        if (list != null) {
            Node searchId = search(auxId);

            if (searchId != null) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Insert the new Id:");
                String auxNew = sc.nextLine();

                if (search(auxNew) != null) {
                    searchId.setId(auxNew);
                } else {
                    System.out.println("Already exist a person with this ID: $auxNew.");
                }
            } else {
                System.out.println("Exist no one person with the ID: $auxId.");
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void remove(String auxId) {
        if (list != null) {
            Node searchId = search(auxId);

            if (searchId != null) {
                if (searchId == list) {
                    list = list.getNext();
                } else {
                    Node current = list;
                    Node before = null;

                    while (current != null) {
                        if (auxId.equals(current.getId())) {
                            assert before != null;
                            before.setNext(current.getNext());
                            break;
                        }

                        before = current;
                        current = current.getNext();
                    }
                }
            } else {
                System.out.println("Exist no one person with de ID: $auxId");
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    private Node search(String auxId) {
        Node current = list;

        while (current != null) {
            if (auxId.equals(current.getId())) {
                return current;
            }

            current = current.getNext();
        }

        return null;
    }

}
