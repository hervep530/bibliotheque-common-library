/**
 * 
 */
package com.ocherve.bcl.exception;

/**
 * @author herve_dev
 *
 */
public class BookFilterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with message
	 * 
	 * @param message
	 */
	public BookFilterException(String message) {
		super(message);
	}
}
