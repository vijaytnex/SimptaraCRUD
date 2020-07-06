package com.simptara.crud.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.simptara.crud.exceptions.ItemAlreadyExistException;
import com.simptara.crud.exceptions.ItemNotFoundException;

/**
 * @author vijaydogra
 *
 */
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ItemAlreadyExistException.class })
	public ResponseEntity<Object> alreadyExist(final RuntimeException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(value = { ItemNotFoundException.class })
	public ResponseEntity<Object> notFound(final RuntimeException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}