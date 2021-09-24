package com.example.FairytaleFlavors.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecipeNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecipeNotFoundException(String msg) {
	    super(msg);
	  }
}
