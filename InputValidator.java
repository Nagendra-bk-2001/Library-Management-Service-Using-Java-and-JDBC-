package com.library.utils;

public class InputValidator {
	
	public static boolean validateNonEmpty(String input, String fieldName) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty.");
        }
        return true;
    }
	
	 public static boolean validateEmail(String email) {
	        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
	        if (!email.matches(emailRegex)) {
	            throw new IllegalArgumentException("Invalid email format: " + email);
	        }
	        return true;
	    }
	 
	 public static boolean validatePositiveNumber(int number, String fieldName) {
	        if (number <= 0) {
	            throw new IllegalArgumentException(fieldName + " must be a positive number.");
	        }
	        return true;
	    }

}
