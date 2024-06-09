package br.com.ur.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;

@Getter
public class NotFoundException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	private final String name;
	private final Object id;

	public NotFoundException(String name) {
		super(HttpStatus.NOT_FOUND, getMessage(name));
		this.name = name;
		this.id = null;
	}

	public NotFoundException(Object id, String name) {
		super(HttpStatus.NOT_FOUND, getMessage(id, name));
		this.id = id;
		this.name = name;
	}

	private static String getMessage(String name) {
		return String.format("%s não foi encontrado(a)", name);
	}

	private static String getMessage(Object id, String name) {
		return String.format("%s com o id '%s' não foi encontrado(a)", name, id);
	}
}