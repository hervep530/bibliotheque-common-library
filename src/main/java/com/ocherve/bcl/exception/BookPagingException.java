/**
 * 
 */
package com.ocherve.bcl.exception;

/**
 * @author herve_dev
 *
 */
public class BookPagingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with message
	 * 
	 * @param message
	 */
	public BookPagingException(String message) {
		super(message);
	}
}
