package com.library.application;

import java.time.LocalDate;
import java.util.Objects;

public class Loan {
	
	private String loan_id;
	private String user_id;
	private String book_id;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	
	//constructor
	public Loan(String loan_id, String user_id ,String book_id , LocalDate issueDate , LocalDate dueDate , LocalDate returnDate)
	{
		this.loan_id = loan_id ;
		this.user_id = user_id ; 
		this.book_id = book_id ;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = null;
	}
	
	public String getloan_id()
	{
		return loan_id;
	}
	public void setloan_id(String loan_id)
	{
		this.loan_id = loan_id;
	}
	
	public String getuser_id()
	{
		return user_id;
	}
	
	public void setuser_id(String user_id)
	{
		this.user_id = user_id;
	}
	public String getbook_id()
	{
		return book_id;
		
	}
	public void setbook_id(String book_id)
	{
		this.book_id = book_id;
	}
	
	public LocalDate getissueDate()
	{
		return issueDate;
	}
	public void setissuedate(LocalDate issueDate)
	{
		this.issueDate = issueDate;
	}
	
	public LocalDate getdueDate()
	{
		return dueDate;
	}
	public void setduedate(LocalDate dueDate)
	{
		this.dueDate = dueDate;
	}	
	
	public LocalDate getreturnDate()
	{
		return returnDate;
	}
	public void setreturnate(LocalDate returnDate)
	{
		this.returnDate = returnDate;
	}
	
	
	 public boolean isOverdue()
	 {
	    return (returnDate == null && LocalDate.now().isAfter(dueDate));
	 }
	 
	 public double calculateFine(double dailyFineRate)
	 {
	        if (isOverdue()) 
	        {
	            long overdueDays = LocalDate.now().toEpochDay() - dueDate.toEpochDay();
	            return overdueDays * dailyFineRate;
	        }
	        return 0.0;
	  }
	 
	 
	 @Override
	 public boolean equals(Object o) 
	 {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Loan loan = (Loan) o;
	        return Objects.equals(loan_id, loan.loan_id);
	 }

	 @Override
	  public int hashCode() 
	 	{
	        return Objects.hash(loan_id);
	    }

	 @Override
	 public String toString() 
	 {
	        return String.format("Loan ID: %s | User ID: %s | Book ID: %s | Issue Date: %s | Due Date: %s | Return Date: %s",
	                loan_id, user_id, book_id, issueDate, dueDate, (returnDate != null ? returnDate : "Not Returned"));
	 }

	
	

}
