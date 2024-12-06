package com.library.Main;

import java.util.Scanner;

import com.library.Services.BookServices;
import com.library.Services.LoanService;
import com.library.Services.UserService;
import com.library.application.Book;
import com.library.application.User;
import com.library.utils.DatabaseConnection;

public class Main {

	public static void main(String[] args) {

		Scanner sc  =  new Scanner(System.in);
		
		BookServices bookService = new BookServices();
		UserService  userService = new UserService();
		LoanService loanService = new LoanService(bookService, userService);
		
		 preloadData(bookService, userService);
		 
		 boolean running = true;

	        while (running) {
	            System.out.println("\n=== Library Management System ===");
	            System.out.println("1. Add Book");
	            System.out.println("2. Add User");
	            System.out.println("3. Issue Book");
	            System.out.println("4. Return Book");
	            System.out.println("5. View Books");
	            System.out.println("6. View Users");
	            System.out.println("7. Exit");
	            System.out.print("Choose an option: ");
	            
	            int choice = sc.nextInt();
	            sc.nextLine();
	            try {
	                switch (choice) {
	                    case 1 -> addBook(sc, bookService);
	                    case 2 -> addUser(sc, userService);
	                    case 3 -> issueBook(sc, loanService);
	                    case 4 -> returnBook(sc, loanService);
	                    case 5 -> bookService.viewBooks();
	                    case 6 -> userService.viewUsers();
	                    case 7 -> {
	                        running = false;
	                        System.out.println("Exiting system. Goodbye!");
	                    }
	                    default -> System.out.println("Invalid choice. Please try again.");
	                }
	            } catch (Exception e) {
	                System.err.println("Error: " + e.getMessage());
	            }
	        }
		 
	        sc.close();
	        DatabaseConnection.Closeconnection();
	}

	private static void preloadData(BookServices bookService, UserService userService) {
		
		 bookService.addBooks(new Book("B001", "Java Basics", "John Doe", true));
	        bookService.addBooks(new Book("B002", "Advanced Java", "Jane Smith", true));
	        bookService.addBooks(new Book("B003", "Database Systems", "Alan Turing", true));

	        userService.addUser(new User("U001", "nagu", "nagudio03@example.com", 3));
	        userService.addUser(new User("U002", "madhu", "madhu@example.com", 2));
		
	}

    private static void addBook(Scanner scanner, BookServices bookService) {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Book Author: ");
        String author = scanner.nextLine();

        bookService.addBooks(new Book(id, title, author, true));
        System.out.println("Book added successfully.");
    }
    
    private static void addUser(Scanner scanner, UserService userService) {
        System.out.print("Enter User ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter User Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Loan Limit: ");
        int loanLimit = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        userService.addUser(new User(id, name, email, loanLimit));
        System.out.println("User added successfully.");
    }
    private static void issueBook(Scanner scanner, LoanService loanService) {
        System.out.print("Enter Loan ID: ");
        String loanId = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter Book ID: ");
        String bookId = scanner.nextLine();
        System.out.print("Enter Loan Duration (days): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try {
            loanService.issueBook(loanId, userId, bookId, duration);
            System.out.println("Book issued successfully.");
        } catch (Exception e) {
            System.err.println("Error issuing book: " + e.getMessage());
        }
    }
    
    private static void returnBook(Scanner scanner, LoanService loanService) {
        System.out.print("Enter Loan ID: ");
        String loanId = scanner.nextLine();

        try {
            loanService.returnBook(loanId);
            System.out.println("Book returned successfully.");
        } catch (Exception e) {
            System.err.println("Error returning book: " + e.getMessage());
        }
    }


}
