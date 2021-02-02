package com.networth.infra.exception;

import java.util.List;

public class ErrorResponse {

	private String correlationId;

	private List<ErrorItem> errors;

	private String code;

	private String message;

	private int responseCode;

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public List<ErrorItem> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorItem> errors) {
		this.errors = errors;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
