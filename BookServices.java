package com.library.Services;

import java.util.ArrayList;
import java.util.List;

import com.library.application.Book;
import com.library.exception.BookNotFoundException;

public class BookServices {
	private List<Book> books ;
	
	
	public BookServices()
	{
		this.books =new ArrayList<>();
	}
	
	public void addBooks(Book book)
	{
		books.add(book);
		System.out.println("Book Add Successfully : " + book.getDetails());
	}
	
	
	public List<Book> searchBooks(String keyword)
	{
		List<Book> result = new ArrayList<>();
		for(Book book : books)
		{
			if(book.matchesQuery(keyword))
			{
				result.add(book);
			}
		}
		return result;
	}
	
	public Book findBookById(String book_id) throws BookNotFoundException {
	    for (Book book : books) {
	        if (book.getbook_id().equals(book_id)) {
	            return book;
	        }
	    }
	    throw new BookNotFoundException("Book with ID " + book_id + " not found.");
	}

	public Object viewBooks() {
	
		return null;
	}
	
	
}
