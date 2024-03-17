package com.Perpus;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Book> borrowedBooks;

    public Library() {
        books = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            borrowedBooks.add(book);
            System.out.println("Book '" + book.getTitle() + "' borrowed successfully.");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            books.add(book);
            System.out.println("Book '" + book.getTitle() + "' returned successfully.");
        } else {
            System.out.println("Book not borrowed from the library.");
        }
    }

    public void displayBooks() {
        System.out.println("Library Catalog:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found in the library.");
        return null;
    }
}