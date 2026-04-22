package org.review.library;

public class Book {
    private int bookId;
    private String author;
    private String title;
    private String status;

    Book(int bookId,String title,String author){
        if(bookId<1 || bookId>100000) throw new IllegalArgumentException("Book Id Invalid");
        if(title.trim().isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        if(author.trim().isEmpty()) throw new IllegalArgumentException("Author name cannot be empty");
        this.bookId=bookId;
        this.author=author;
        this.title= title;
        status="Available";
    }

    public void setStatus(String s){
        if(!s.equals("Available")||!s.equals("CheckedOut")) throw new IllegalArgumentException("Status is invalid");
        status=s;
    }
    public int getBookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getStatus(){
        return status;
    }
    public void displayBook() {
        System.out.println("BookId: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Status: " + status);
        System.out.println();
    }
}
