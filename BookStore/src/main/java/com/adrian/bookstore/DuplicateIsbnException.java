package com.adrian.bookstore;

public class DuplicateIsbnException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateIsbnException(String isbn) {
        super("ISBN already exists: " + isbn);
    }
}