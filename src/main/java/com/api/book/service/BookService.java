package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;

@Component
public class BookService {

	private static List<Book> list = new ArrayList<>();
	// we have used static block here, when program runs first static block will
	// execute
	static {
		list.add(new Book(12, "Complete java reference", "XYZ"));
		list.add(new Book(36, "Head First To Java", "ABC"));
		list.add(new Book(12963, "Complete Think in java", "LMN"));

	}

	// get all books

	public List<Book> getAllBooks() {
		return list;
	}

//get single book by id
	public Book getBookById(int id) {
		// to get our id book from list we wil use java 8 we can do same by for loop
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;

	}

	// adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// delete book
	public void deleteBook(int bid) {
		// to delete our id book from list we wil use java 8 we can do same by for loop
		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
	}

	// update book
	public void updateBook(Book book, int bookId) {
		list = list.stream().map(b -> {
			if (b.getId() == bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());

	}
}
