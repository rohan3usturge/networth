package com.networth.infra.exception;

import java.util.List;

public class ApiException extends RuntimeException {

	private final ApiExceptionType apiExceptionType;

	private final String code;

	private final List<ErrorItem> errors;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiException(ApiExceptionType apiExceptionType, String code, String message) {
		super(message);
		this.apiExceptionType = apiExceptionType;
		this.code = code;
		this.errors = null;
	}

	public ApiException(ApiExceptionType apiExceptionType, String code, String message, List<ErrorItem> errorItems) {
		super(message);
		this.apiExceptionType = apiExceptionType;
		this.code = code;
		this.errors = errorItems;
	}

	public ApiExceptionType getApiExceptionType() {
		return apiExceptionType;
	}

	public String getCode() {
		return code;
	}

	public List<ErrorItem> getErrors() {
		return errors;
	}

}
