package listasDobles.java;

import java.util.Scanner;

public class DoubleList {
    private Node head;
    private Node tile;

    public DoubleList() {
        tile = null;
        head = null;
    }

    public void insert(String auxId) {
        if (search(auxId) == null) {
            Node newNode = new Node(auxId);

            if (head == null) {
                head = newNode;
                tile = head;
            } else {
                tile.setNext(newNode);
                newNode.setNext(null);
                newNode.setBefore(tile);
                tile = newNode;
            }
        } else {
            System.out.println("Already exist a person with this ID: " + auxId);
        }
    }

    public void showASC() {
        if (head != null) {
            Node current = head;

            while (current != null) {
                System.out.println("The ID: ${current.id}");

                current = current.getNext();
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void showDSC() {
        if (head != null) {
            Node current = tile;

            while (current != null) {
                System.out.println("The ID: ${current.id}");

                current = current.getBefore();
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void update(String auxId) {
        if (head != null) {
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
        if (head != null) {
            Node searchId = search(auxId);

            if (searchId != null) {
                if (searchId.getNext() == null && searchId.getBefore() == null) {
                    head = null;
                } else if (searchId.getNext() != null && searchId.getBefore() == null) {
                    head = head.getNext();
                    head.setBefore(null);
                } else if (searchId.getNext() == null && searchId.getBefore() != null) {
                    tile = tile.getBefore();
                    tile.setNext(null);
                } else {
                    assert searchId.getBefore() != null;
                    searchId.getBefore().setNext(searchId.getNext());
                    searchId.getNext().setBefore(searchId.getBefore());
                }
            } else {
                System.out.println("Exist no one person with the ID: $auxId.");
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    private Node search(String auxId) {
        Node current = head;

        while (current != null) {
            if (auxId.equals(current.getId())) {
                return current;
            }

            current = current.getNext();
        }

        return null;
    }

}
