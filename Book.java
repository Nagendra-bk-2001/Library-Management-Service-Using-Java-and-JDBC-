package com.library.application;

import java.util.Objects;

public class Book {
	
	private String book_id;
	private  String title;
	private String author;
	private boolean isAvailable;
	
	public Book(String book_id,String title, String author,boolean isAvailable)
	{
		this.book_id = book_id ; 
		this.title = title;
		this.author = author;
		this.isAvailable = isAvailable;
	}
	
	public String getbook_id()
	{
		return book_id;
	}
	
	public void  setbook_id(String book_id)
	{
		this.book_id = book_id;
	}
	
	public String title()
	{
		return title;
	}
	public void settitle(String title)
	{
		this.title = title;
	}
	
	public String getauthor()
	{
		return author;
	}
	
	public void setauthor(String author)
	{
		this.author = author;
	}
	public boolean getisAvaiable()
	{
		return isAvailable;
	}
	public void setisAvaiable(boolean iaAvailable)
	{
		this.isAvailable = isAvailable;
	}
	
	
	public String getDetails()
	{
		return String.format("ID : %s  | Titile : %s  | Author : %s | Available : %s " , book_id,title,author,isAvailable ? "Yes" : "No");
	}
	
	
	public boolean matchesQuery(String query)
	{
		return title.toLowerCase().contains(query.toLowerCase()) || author.toLowerCase().contains(query.toLowerCase());	
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o ) return true;
		if(o == null || getClass() !=o.getClass()) return false;
		Book book = (Book) o ;
		return Objects.equals(book_id, book.book_id);
	}
	
	@Override
	public int hashCode()
	{
		return Objects.hash(book_id);
	}
	
	@Override
	public String toString()
	{
		return getDetails();
	}

}
