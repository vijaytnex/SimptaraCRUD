package com.simptara.crud.exceptions;

/**
 * @author vijaydogra
 *
 */
public class ItemNotFoundException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = -8134559077594468113L;

	public ItemNotFoundException(final String message) {
		super(message);
	}
}
