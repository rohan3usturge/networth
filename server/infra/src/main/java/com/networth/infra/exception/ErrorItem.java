package com.networth.infra.exception;

import java.io.Serializable;

public class ErrorItem implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -1670779558611716653L;

	private String code;

	private String message;

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
