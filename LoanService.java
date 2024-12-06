package com.library.Services;

import java.rmi.NotBoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.library.application.Book;
import com.library.application.Loan;
import com.library.exception.BookNotFoundException;
import com.library.exception.LoanLimitExceededException;
import com.library.exception.UserNotFoundException;

public class LoanService {
	private List<Loan> loans;
	private BookServices bookservice;
	private UserService userservice;
	
	
	public LoanService(BookServices bookservice, UserService 
			userservice)
	{
		this.loans = new ArrayList<>();
		this.bookservice = bookservice;
		this.userservice = userservice;
	}
	public void issueBook(String loan_id, String user_id, String book_id, int durationDays)
            throws BookNotFoundException, UserNotFoundException 
	{
        
        userservice.findUserById(user_id);

       
        Book book = bookservice.findBookById(book_id);
        if (!book.getisAvaiable()) {
            throw new BookNotFoundException("Book with ID " + book_id + " is not available for loan.");
        }
        book.setisAvaiable(false);
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(durationDays);
        Loan loan = new Loan(loan_id, user_id, book_id, issueDate, dueDate, dueDate);
        loans.add(loan);
        System.out.println("Book issued successfully: " + loan);
    }
	
	public void listAllLoans()
		{
				if(loans.isEmpty())
				{
					System.out.println(" No loans in the System. " );
				}
				else
				{
					for(Loan loan : loans)
					{
						System.out.println(loans);
					}
				}
		}
	
	public Loan findBookById(String loan_id) throws LoanLimitExceededException
	{
		for(Loan loan : loans)
		{
			if(loan.getloan_id().equals(loan_id))
			{
				return loan;
			}
		}
		throw new LoanLimitExceededException (" Loan with Id  " + loan_id + " Not found "); 
	}
	public String returnBook(String loanId) {
		return loanId;
		
	}
	
	
	
}
