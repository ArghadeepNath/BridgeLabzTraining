package org.review.oops_with_collection;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookBuddy app = new BookBuddy();

        while (true) {
            System.out.println("\n--- BookBuddy ---");
            System.out.println("1. Add Book");
            System.out.println("2. Sort Books");
            System.out.println("3. Search by Author");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    app.addBook(title, author);
                    break;

                case 2:
                    app.sortBooks();
                    break;

                case 3:
                    System.out.print("Enter Author: ");
                    String searchAuthor = sc.nextLine();

                    app.searchByAuthor(searchAuthor);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}