package Interface_Abstract.book_management;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ArrayList<Book> bookList = new ArrayList<>();

        while (true){
            System.out.println("----------------------------");
            System.out.println("Book Management System");
            System.out.println("1. Insert new book");
            System.out.println("2. View list of books");
            System.out.println("3. Average Price");
            System.out.println("4. Exit");
            System.out.println("----------------------------");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character after nextInt()
                if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    continue; // Skip to the next iteration of the loop
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear the invalid input
                continue; // Skip to the next iteration of the loop
            }
            switch (choice) {
                case 1:
                    Book book = new Book();
                    System.out.println("Insert new book");
                    System.out.print("Enter name: ");
                    book.setName(scanner.nextLine());
                    System.out.print("Enter PublishDate: ");
                    book.setPublishDate(scanner.nextLine());
                    System.out.print("Enter Author: ");
                    book.setAuthor(scanner.nextLine());
                    System.out.print("Enter Language: ");
                    book.setLanguage(scanner.nextLine());

                    // Input prices
                    float[] prices = new float[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Enter price " + (i + 1) + ": ");
                        while (true) {
                            try {
                                prices[i] = scanner.nextFloat();
                                break; // Exit the loop if input is valid
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // Clear the invalid input
                            }
                        }
                    }
                    book.setPriceList(prices);
                    bookList.add(book); // Add the book to the list
                    break;
                case 2:
                    System.out.println("List of books:");
                    if (bookList.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book b : bookList) {
                            b.display(); // Display each book's details
                            System.out.println("----------------------------");
                        }
                    }
                    break;
                case 3:
                    if (bookList.isEmpty()) {
                        System.out.println("No books available to calculate average price.");
                    } else {
                        for (Book b : bookList) {
                            b.calculate(); // Calculate the average price for each book
                            b.display();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return; // Exit the program
            }
        }
    }
}
