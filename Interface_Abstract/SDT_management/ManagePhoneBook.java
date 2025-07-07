package Interface_Abstract.SDT_management;

import java.util.Scanner;

public class ManagePhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPHONEBOOK MANAGEMENT SYSTEM");
            System.out.println("1. Insert Phone");
            System.out.println("2. Remove Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Search Phone");
            System.out.println("5. Sort");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between 1 and 6: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            String name, phone;

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    phone = scanner.nextLine();
                    phoneBook.insertPhone(name, phone);
                    break;

                case 2:
                    System.out.print("Enter name to remove: ");
                    name = scanner.nextLine();
                    phoneBook.removePhone(name);
                    break;

                case 3:
                    System.out.print("Enter name to update: ");
                    name = scanner.nextLine();
                    System.out.print("Enter new phone: ");
                    phone = scanner.nextLine();
                    phoneBook.updatePhone(name, phone);
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    name = scanner.nextLine();
                    phoneBook.searchPhone(name);
                    break;

                case 5:
                    phoneBook.sort();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-6.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
