package org.review.oops_with_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookBuddy {

    private ArrayList<Book> books;
    private final int MAX_BOOKS = 100;

    public BookBuddy() {
        books = new ArrayList<>();
    }

    // Add Book
    public void addBook(String title, String author) {

        if (title == null || author == null ||title.trim().isEmpty() || author.trim().isEmpty()) {
            System.out.println("Invalid input. Title and Author cannot be empty.");
        }

        if (books.size() >= MAX_BOOKS) {
            System.out.println("Book limit reached (100).");
        }

        books.add(new Book(title, author));
        System.out.println("Book added successfully.");
    }
    public void sortBooks() {

        if (books.isEmpty()) {
            System.out.println("No books to sort.");
            return;
        }
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareToIgnoreCase(b2.getTitle());
            }
        });

        System.out.println("\nSorted Books:");
        ArrayList<String> result = new ArrayList<>();

        for (Book b : books) {
            result.add(b.toString());
        }

        String[] arr = result.toArray(new String[0]);
        for (String s : arr) {
            System.out.println(s);
        }
    }
    public void searchByAuthor(String author) {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        boolean found = false;

        System.out.println("\nSearch Result:");
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author.trim())) {
                System.out.println(b);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No books found for author: " + author);
        }
    }
}