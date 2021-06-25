package com.bf1el.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Predstavlja nasledjenu RunTimeException klasu i puca exception kada nemamo podatke u bazi za trazeni entitet
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(final String message) {
		super(message);
	}

}
