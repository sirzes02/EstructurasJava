package listas.java;

import java.util.Scanner;

public class Lista {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List miList = new List();
        String auxId;
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Insert.");
            System.out.println("2. Show.");
            System.out.println("3. Update.");
            System.out.println("4. Delete.");
            System.out.println("5. Exit.");
            System.out.println("Choose a option:");

            option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.println("Insert a ID:");
                    auxId = sc.nextLine();

                    miList.insert(auxId);
                }
                case 2 -> miList.show();
                case 3 -> {
                    System.out.println("Insert a ID to update:");
                    auxId = sc.nextLine();

                    miList.update(auxId);
                }
                case 4 -> {
                    System.out.println("Insert a ID to delete:");
                    auxId = sc.nextLine();

                    miList.remove(auxId);
                }
                case 5 -> System.out.println("Bye..");
                default -> System.out.println("\nWrong data, please try again.");
            }

            System.out.println("Press ENTER to continue...");
            sc.nextLine();
        } while (option != 5);
    }
}
