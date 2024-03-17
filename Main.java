package com.Perpus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Menambahkan beberapa buku contoh
        library.addBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 1997));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author of the book: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year of publication: ");
                    int year = scanner.nextInt();
                    library.addBook(new Book(title, author, year));
                    System.out.println("Book added successfully.");
                    break;
                case 3:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter title of the book to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Book borrowBook = library.findBook(borrowTitle);
                    if (borrowBook != null) {
                        library.borrowBook(borrowBook);
                    }
                    break;
                case 4:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    Book returnBook = library.findBook(returnTitle);
                    if (returnBook != null) {
                        library.returnBook(returnBook);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }
}
