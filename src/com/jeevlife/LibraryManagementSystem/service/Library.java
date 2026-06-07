package com.jeevlife.LibraryManagementSystem.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jeevlife.LibraryManagementSystem.exception.BookAlreadyIssuedException;
import com.jeevlife.LibraryManagementSystem.exception.BookNotFoundException;
import com.jeevlife.LibraryManagementSystem.exception.BookNotIssuedException;
import com.jeevlife.LibraryManagementSystem.exception.DuplicateBookException;
import com.jeevlife.LibraryManagementSystem.exception.DuplicateUserException;
import com.jeevlife.LibraryManagementSystem.exception.UserNotFoundException;
import com.jeevlife.LibraryManagementSystem.model.Book;
import com.jeevlife.LibraryManagementSystem.model.User;

public class Library {

	private List<Book> books;
	private Map<Integer, User> users;

	public Library() {
		books = new ArrayList<>();
		users = new HashMap<>();
	}

	public void addBook(Book book) throws DuplicateBookException {

		boolean exists = books.stream().anyMatch(b -> b.getBookId() == book.getBookId());

		if (exists) {
			throw new DuplicateBookException("Book ID already exists.");
		}

		books.add(book);
	}

	public void removeBook(int bookId) throws BookNotFoundException {

		Book book = findBookById(bookId);

		books.remove(book);
	}

	public void registerUser(User user) throws DuplicateUserException {

		if (users.containsKey(user.getUserId())) {
			throw new DuplicateUserException("User ID already exists.");
		}

		users.put(user.getUserId(), user);
	}

	public Book findBookById(int bookId) throws BookNotFoundException {

		return books.stream().filter(book -> book.getBookId() == bookId).findFirst()
				.orElseThrow(() -> new BookNotFoundException("Book not found."));
	}

	public Optional<Book> findBookByTitle(String title) {

		return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst();
	}

	public User getUser(int userId) throws UserNotFoundException {

		User user = users.get(userId);

		if (user == null) {
			throw new UserNotFoundException("User not found.");
		}

		return user;
	}

	public void issueBook(int bookId, int userId) throws Exception {

		Book book = findBookById(bookId);
		User user = getUser(userId);

		if (book.isIssued()) {
			throw new BookAlreadyIssuedException("Book already issued.");
		}

		book.setIssued(true);
		user.borrowBook(book);
	}

	public void returnBook(int bookId, int userId) throws Exception {

		Book book = findBookById(bookId);
		User user = getUser(userId);

		if (!book.isIssued()) {
			throw new BookNotIssuedException("Book was not issued.");
		}

		book.setIssued(false);
		user.returnBook(book);
	}

	public void displayAllBooks() {

		books.forEach(System.out::println);
	}

	public List<Book> getAvailableBooks() {

		return books.stream().filter(book -> !book.isIssued()).collect(Collectors.toList());
	}

	public void sortBooksByTitle() {

		books.sort((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
	}
}