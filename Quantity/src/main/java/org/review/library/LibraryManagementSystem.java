package org.review.library;

import java.util.Scanner;

public class LibraryManagementSystem {

    public static Book[] books = new Book[100];
    private static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Library Management System ===");
        System.out.println("Enter number of books:");

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        if (n <= 0 || n > 100) {
            System.out.println("Invalid number of books");
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));

            System.out.println("Enter BookId:");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.println("Enter Title:");
            String title = sc.nextLine();

            System.out.println("Enter Author:");
            String author = sc.nextLine();

            books[count++] = new Book(id, title, author);
        }

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Checkout Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    displayAllBooks();
                    break;

                case 2:
                    System.out.println("Enter partial title:");
                    String keyword = sc.nextLine();
                    searchBooks(keyword);
                    break;

                case 3:
                    System.out.println("Enter BookId to checkout:");
                    int checkoutId = sc.nextInt();
                    checkoutBook(checkoutId);
                    break;

                case 4:
                    System.out.println("Enter BookId to return:");
                    int returnId = sc.nextInt();
                    returnBook(returnId);
                    break;

                case 5:
                    System.out.println("Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void displayAllBooks() {
        System.out.println("--- Library Books ---");

        for (int i = 0; i < count; i++) {
            books[i].displayBook();
        }
    }

    private static void searchBooks(String keyword) {
        System.out.println("--- Search Results ---");

        String lowerKeyword = keyword.toLowerCase();

        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().toLowerCase().contains(lowerKeyword)) {
                books[i].displayBook();
            }
        }
    }

    private static void checkoutBook(int bookId) {
        for (int i = 0; i < count; i++) {

            if (books[i].getBookId() == bookId) {

                if (books[i].getStatus().equals("Available")) {
                    books[i].setStatus("CheckedOut");

                    System.out.println("--- Checkout Status ---");
                    System.out.println("Book Checked Out Successfully");
                } else {
                    System.out.println("Book already checked out");
                }
                return;
            }
        }

        System.out.println("Book not found");
    }

    private static void returnBook(int bookId) {
        for (int i = 0; i < count; i++) {

            if (books[i].getBookId() == bookId) {

                if (books[i].getStatus().equals("CheckedOut")) {
                    books[i].setStatus("Available");

                    System.out.println("--- Return Status ---");
                    System.out.println("Book Returned Successfully");
                } else {
                    System.out.println("Book is already available");
                }
                return;
            }
        }

        System.out.println("Book not found");
    }
}