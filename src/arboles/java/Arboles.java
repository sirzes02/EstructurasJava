package arboles.java;

import java.util.Scanner;

public class Arboles {
    private static final String CLEAR = "\033[H\033[2J";

    public static void main(String[] args) {
        Tree miTree = new Tree();
        short option;
        int data;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print(CLEAR);

            System.out.println("Menu:");
            System.out.println("1. Insert.");
            System.out.println("2. Remove.");
            System.out.println("3. Find.");
            System.out.println("4. Show pre-order.");
            System.out.println("5. Show in-order.");
            System.out.println("6. Show post-order.");
            System.out.println("7. Show level-order.");
            System.out.println("8. Exit.");
            System.out.println("Choose one:.");
            option = sc.nextShort();

            System.out.print(CLEAR);

            switch (option) {
                case 1 -> {
                    System.out.println("\nInsert a new element:");
                    data = sc.nextInt();
                    miTree.add(data);
                }
                case 2 -> {
                    System.out.println("\nInsert the element to remove:");
                    data = sc.nextInt();
                    miTree.delete(data);
                }
                case 3 -> {
                    System.out.println("\nInsert the element to search:");
                    data = sc.nextInt();
                    System.out.println(miTree.containsNode(data));
                }
                case 4 -> miTree.traversePreOrder(miTree.getRoot());
                case 5 -> miTree.traverseInOrder(miTree.getRoot());
                case 6 -> miTree.traversePostOrder(miTree.getRoot());
                case 7 -> miTree.traverseLeverOrder();
                case 8 -> System.out.println("Bye...");
                default -> System.out.println("\\nWrong data, please try again.");
            }
            System.out.println("\n\nPress ENTER to continue...");
            sc.next();
        } while (option != 8);
    }
}
