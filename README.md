# Library Management System

## Project Overview

The Library Management System is a console-based Java application developed to demonstrate core Java programming concepts, including Object-Oriented Programming (OOP), Java Collections Framework, Exception Handling, and Java 8 features.

The application allows librarians to manage books and users efficiently through a menu-driven interface. Users can register, borrow books, return books, and search for available books within the library system.

This project was developed as part of the **Week 1 OOP Collections Assignment** and follows clean coding standards, modular design principles, and industry best practices.

---

## Objectives

* Apply Object-Oriented Programming concepts.
* Utilize Java Collections Framework effectively.
* Implement robust Exception Handling.
* Demonstrate Java 8 features such as Streams, Lambda Expressions, Method References, and Optional.
* Follow clean code and maintainable software design practices.

---

## Features

### Book Management

* Add a new book
* Remove an existing book
* Search book by ID
* Search book by Title
* Display all books
* Display available books
* Sort books by title

### User Management

* Register a new user
* View user details

### Library Operations

* Issue a book to a user
* Return a book from a user

### Exception Handling

* Duplicate Book ID validation
* Duplicate User ID validation
* Book not found handling
* User not found handling
* Book already issued validation
* Book return validation

### Java 8 Features

* Lambda Expressions
* Stream API
* Method References
* Optional

---

## Technologies Used

| Technology         | Purpose                            |
| ------------------ | ---------------------------------- |
| Java 8+            | Core Programming Language          |
| OOP                | Software Design                    |
| ArrayList          | Book Management                    |
| HashMap            | User Management                    |
| Stream API         | Filtering and Searching            |
| Lambda Expressions | Sorting and Functional Programming |
| Optional           | Null Safety                        |
| Exception Handling | Error Management                   |

---

## Project Structure

```text
LibraryManagementSystem
│
├── src
│   └── com
│       └── jeevlife
│           └── LibraryManagementSystem
│
│               ├── model
│               │   ├── Book.java
│               │   └── User.java
│               │
│               ├── service
│               │   └── Library.java
│               │
│               ├── exception
│               │   ├── BookNotFoundException.java
│               │   ├── UserNotFoundException.java
│               │   ├── DuplicateBookException.java
│               │   ├── DuplicateUserException.java
│               │   ├── BookAlreadyIssuedException.java
│               │   └── BookNotIssuedException.java
│               │
│               └── LibraryManagementSystem.java
│
├── README.md
└── .gitignore
```

---

## OOP Concepts Implemented

### Encapsulation

Data members are declared private and accessed using getters and setters.

Example:

```java
private int bookId;
private String title;
```

### Abstraction

Complex business logic is hidden inside the Library service class.

Example:

```java
library.issueBook(bookId, userId);
```

### Inheritance

Custom exceptions inherit from the Exception class.

Example:

```java
public class BookNotFoundException extends Exception
```

### Polymorphism

Programming to interfaces instead of implementations.

Example:

```java
List<Book> books = new ArrayList<>();
Map<Integer, User> users = new HashMap<>();
```

---

## Collections Framework Usage

### ArrayList

Used to store books.

```java
private List<Book> books = new ArrayList<>();
```

Reason:

* Dynamic size
* Easy iteration
* Efficient insertion

### HashMap

Used to store users.

```java
private Map<Integer, User> users = new HashMap<>();
```

Reason:

* Fast retrieval using User ID
* Average O(1) lookup time
* Prevents duplicate user keys

---

## Java 8 Features Used

### Lambda Expression

```java
books.sort((b1, b2) ->
        b1.getTitle().compareToIgnoreCase(b2.getTitle()));
```

Used for sorting books alphabetically.

---

### Stream API

```java
books.stream()
     .filter(book -> !book.isIssued())
     .collect(Collectors.toList());
```

Used to retrieve available books.

---

### Method Reference

```java
books.forEach(System.out::println);
```

Used for cleaner iteration and display.

---

### Optional

```java
Optional<Book> findBookByTitle(String title)
```

Used to avoid NullPointerException.

---

## Exception Handling

The application uses custom exceptions to handle invalid operations.

| Exception                  | Description              |
| -------------------------- | ------------------------ |
| DuplicateBookException     | Book ID already exists   |
| DuplicateUserException     | User ID already exists   |
| BookNotFoundException      | Book does not exist      |
| UserNotFoundException      | User does not exist      |
| BookAlreadyIssuedException | Book is already borrowed |
| BookNotIssuedException     | Book was never issued    |

---

## How to Run the Project

### Prerequisites

* Java JDK 8 or later
* IntelliJ IDEA / Eclipse / VS Code

### Clone Repository

```bash
git clone https://github.com/your-username/LibraryManagementSystem.git
```

### Navigate to Project

```bash
cd LibraryManagementSystem
```

### Compile Project

```bash
javac *.java
```

### Run Application

```bash
java LibraryManagementSystem
```

Or run directly from your IDE.

---

## Sample Console Execution

```text
=================================
 LIBRARY MANAGEMENT SYSTEM
=================================

1. Add Book
2. Remove Book
3. Search Book By ID
4. Search Book By Title
5. Display All Books
6. Register User
7. View User Details
8. Issue Book
9. Return Book
10. Display Available Books
11. Sort Books By Title
0. Exit

Enter Choice : 1

Enter Book ID : 101
Enter Book Title : Java Basics
Enter Author Name : James Gosling

Book added successfully.
```

### Issue Book Example

```text
Enter Book ID : 101
Enter User ID : 1

Book issued successfully.
```

### Return Book Example

```text
Enter Book ID : 101
Enter User ID : 1

Book returned successfully.
```

### Exception Example

```text
Error: Book already issued.
```

---

## Future Enhancements

* File-based persistence
* Database integration using JDBC
* Spring Boot REST API
* User Authentication
* Fine Calculation System
* Book Reservation Feature
* Admin Dashboard
* GUI Application using JavaFX or Swing
* RESTful Web Services
* Unit Testing using JUnit

---

## Learning Outcomes

Through this project, the following concepts were practiced:

* Object-Oriented Programming
* Java Collections Framework
* Custom Exception Handling
* Functional Programming in Java 8
* Clean Code Principles
* Modular Project Structure
* Menu-Driven Application Development
* Software Design Best Practices

---

## Author

**Sham Johari**

Java Full Stack Developer

---

## License

This project is developed for educational and learning purposes.
