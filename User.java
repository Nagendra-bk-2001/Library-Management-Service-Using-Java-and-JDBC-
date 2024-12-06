package com.library.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
	
	private String  user_id;
	private String name;
	private String email;
	private int maxBooksLimit;
	private List<String> borrrowedBooks;
	
	//Constructor
	public User(String user_id,String name,String email,int maxBookLimit)
	{
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.maxBooksLimit = maxBookLimit;
		this.borrrowedBooks = new ArrayList<>();
	}
	
	
	public String getuser_id()
	{
		return user_id;
	}
	
	public void setuser_id(String user_id)
	{
		this.user_id = user_id;
	}
	
	public String getname()
	{
		return name;
	}
	
	public void setname(String name)
	{
		this.name = name ;
	}
	
	public String email()
	{
		return email;
	}
	public void setemail(String email)
	{
		this.email = email;
	}
	public int getmaxBooksLimit()
	{
		return maxBooksLimit;
	}
	public void setmaxBooksLimit(int maxBooksLimit)
	{
		this.maxBooksLimit = maxBooksLimit;
	}
	public List<String> getborrrowedBooks()
	{
		return borrrowedBooks;
	}
	
	/**
     * Return a borrowed book by its ID.
     * nagu bookId The ID of the book to return.
     * return True if the book was successfully returned, false if the book was not found.
     */
	public boolean borrrowedBooks(String book_id)
	{
		if(borrrowedBooks.size() < maxBooksLimit)
		{
			borrrowedBooks.add(book_id);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public String getborrowedBooksDetails()
	{
		return String.join(" ", borrrowedBooks );
	}
	
	@Override
	public boolean equals(Object o)
	{
		if(this == o ) return true;
		if(o == null || getClass() !=o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(user_id, user.user_id);
	}
	@Override
	public int hashCode()
	{
		return Objects.hash(user_id);
	}
	
	@Override
	public String toString()
	{
		return String.format(" ID : %s | Name : %s | email : %s Borrowed Book : [%s] " , user_id , name , email , getborrowedBooksDetails());
	}

}
