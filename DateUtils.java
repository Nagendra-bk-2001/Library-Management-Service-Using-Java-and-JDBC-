package com.library.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	private static final DateTimeFormatter DATE_FORMATTER  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	
	 public static LocalDate parseDate(String dateStr) {
	        return LocalDate.parse(dateStr, DATE_FORMATTER);
	    }
	 
	 public static String formatDate(LocalDate date) {
	        return date.format(DATE_FORMATTER);
	    }

}
