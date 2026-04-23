package org.review.oops_with_collection;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        if (title == null || title.trim().isEmpty() ||author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Title and Author cannot be empty");
        }
        this.title = title.trim();
        this.author = author.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " - " + author;
    }
}
