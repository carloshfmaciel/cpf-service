package br.com.app.domain.cpf.controller.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CpfNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2956172443488505204L;
	
	final String errorCode;
	
	public CpfNotFoundException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

}
