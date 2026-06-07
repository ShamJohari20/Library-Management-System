package com.jeevlife.LibraryManagementSystem;

import java.util.Scanner;

import com.jeevlife.LibraryManagementSystem.model.Book;
import com.jeevlife.LibraryManagementSystem.model.User;
import com.jeevlife.LibraryManagementSystem.service.Library;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book By ID");
            System.out.println("4. Search Book By Title");
            System.out.println("5. Display All Books");
            System.out.println("6. Register User");
            System.out.println("7. View User Details");
            System.out.println("8. Issue Book");
            System.out.println("9. Return Book");
            System.out.println("10. Display Available Books");
            System.out.println("11. Sort Books By Title");
            System.out.println("0. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:
                        addBook(scanner, library);
                        break;

                    case 2:
                        removeBook(scanner, library);
                        break;

                    case 3:
                        searchBookById(scanner, library);
                        break;

                    case 4:
                        searchBookByTitle(scanner, library);
                        break;

                    case 5:
                        library.displayAllBooks();
                        break;

                    case 6:
                        registerUser(scanner, library);
                        break;

                    case 7:
                        viewUser(scanner, library);
                        break;

                    case 8:
                        issueBook(scanner, library);
                        break;

                    case 9:
                        returnBook(scanner, library);
                        break;

                    case 10:
                        displayAvailableBooks(library);
                        break;

                    case 11:
                        library.sortBooksByTitle();
                        System.out.println("Books sorted successfully.");
                        break;

                    case 0:
                        System.out.println("Thank you for using Library Management System.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 0);

        scanner.close();
    }

    private static void addBook(Scanner scanner, Library library)
            throws Exception {

        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author Name: ");
        String author = scanner.nextLine();

        library.addBook(new Book(id, title, author));

        System.out.println("Book added successfully.");
    }

    private static void removeBook(Scanner scanner, Library library)
            throws Exception {

        System.out.print("Enter Book ID to remove: ");
        int id = scanner.nextInt();

        library.removeBook(id);

        System.out.println("Book removed successfully.");
    }

    private static void searchBookById(Scanner scanner, Library library)
            throws Exception {

        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();

        System.out.println(library.findBookById(id));
    }

    private static void searchBookByTitle(Scanner scanner, Library library) {

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        library.findBookByTitle(title)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("Book not found.")
                );
    }

    private static void registerUser(Scanner scanner, Library library)
            throws Exception {

        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();

        library.registerUser(new User(id, name));

        System.out.println("User registered successfully.");
    }

    private static void viewUser(Scanner scanner, Library library)
            throws Exception {

        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();

        System.out.println(library.getUser(id));
    }

    private static void issueBook(Scanner scanner, Library library)
            throws Exception {

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();

        library.issueBook(bookId, userId);

        System.out.println("Book issued successfully.");
    }

    private static void returnBook(Scanner scanner, Library library)
            throws Exception {

        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();

        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();

        library.returnBook(bookId, userId);

        System.out.println("Book returned successfully.");
    }

    private static void displayAvailableBooks(Library library) {

        System.out.println("\nAvailable Books:");

        library.getAvailableBooks()
                .forEach(System.out::println);
    }
}