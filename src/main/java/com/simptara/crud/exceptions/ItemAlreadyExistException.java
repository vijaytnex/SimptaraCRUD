package com.simptara.crud.exceptions;

/**
 * @author vijaydogra
 *
 */
public class ItemAlreadyExistException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = -6513241149053116786L;

	public ItemAlreadyExistException(String message) {
		super(message);
	}
}
