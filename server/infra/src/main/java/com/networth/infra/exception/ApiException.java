package com.networth.infra.exception;

import java.util.List;

public class ApiException extends RuntimeException {

	private ApiExceptionType apiExceptionType;

	private String code;

	private String message;

	private final List<ErrorItem> errors;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApiException(ApiExceptionType apiExceptionType, String code, String message) {
		super();
		this.apiExceptionType = apiExceptionType;
		this.code = code;
		this.message = message;
		this.errors = null;
	}

	public ApiException(ApiExceptionType apiExceptionType, String code, String message, List<ErrorItem> errorItems) {
		super();
		this.apiExceptionType = apiExceptionType;
		this.code = code;
		this.message = message;
		this.errors = errorItems;
	}

	public ApiException(ApiExceptionType apiExceptionType) {
		super();
		this.apiExceptionType = apiExceptionType;
		this.errors = null;
	}

	public ApiException(ApiExceptionType apiExceptionType, String code) {
		super();
		this.apiExceptionType = apiExceptionType;
		this.code = code;
		this.errors = null;
	}

	public ApiExceptionType getApiExceptionType() {
		return apiExceptionType;
	}

	public void setApiExceptionType(ApiExceptionType apiExceptionType) {
		this.apiExceptionType = apiExceptionType;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public List<ErrorItem> getErrors() {
		return errors;
	}

}
