package Interface_Abstract.News;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        ArrayList<News> newsList = new ArrayList<>();
        while (true){
            System.out.println("----------------------------");
            System.out.println("News Management System");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
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
            }catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next(); // Clear the invalid input
                continue; // Skip to the next iteration of the loop
            }
            switch (choice) {
                case 1:
                    News news = new News();
                    System.out.println("Insert news");
                    System.out.print("Enter title: ");
                    news.setTitle(scanner.nextLine());
                    System.out.print("Enter PublishDate: ");
                    news.setPublishDate(scanner.nextLine());
                    System.out.print("Enter Author: ");
                    news.setAuthor(scanner.nextLine());
                    System.out.print("Enter Content: ");
                    news.setContent(scanner.nextLine());
                    System.out.println("Enter 3 Rate: ");
                    int[] rates = new int[3];
                    for (int i = 0; i < 3; i++) {
                        System.out.print("\t Rate " + (i + 1) + ": ");
                        while (true) {
                            try {
                                rates[i] = scanner.nextInt();
                                break; // Exit the loop if input is valid
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // Clear the invalid input
                            }
                        }
                    }
                    news.setRateList(rates);
                    newsList.add(news); // Add the news to the list
                    break;
                case 2:
                    System.out.println("List of news:");
                    if (newsList.isEmpty()) {
                        System.out.println("No news available.");
                    } else {
                        for (News n : newsList) {
                            n.Display();
                            System.out.println("----------------------------");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Average rate of news:");
                    if (newsList.isEmpty()) {
                        System.out.println("No news available to calculate average rate.");
                    } else {
                        for (News n : newsList) {
                            n.Calculate();
                            n.Display();
                        }
                    }

                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
