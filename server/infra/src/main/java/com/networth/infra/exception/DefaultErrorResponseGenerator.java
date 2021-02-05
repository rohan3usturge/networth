package com.networth.infra.exception;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DefaultErrorResponseGenerator implements ErrorResponseGenerator {

	@Override
	public ErrorResponse convert(Throwable ex) {
		ErrorResponse errorResponse = new ErrorResponse();
		int responseCode = 500;
		String code = "InternalServerError";
		String message = "Something went wrong while processing the request";
		List<ErrorItem> errorItems = null;
		if (ex instanceof ApiException) {
			ApiException apiException = (ApiException) ex;
			code = apiException.getCode();
			message = apiException.getMessage();
			errorItems = apiException.getErrors();
			ApiExceptionType apiExceptionType = apiException.getApiExceptionType();
			if (apiExceptionType == ApiExceptionType.VALIDATION) {
				responseCode = 400;
			}
		}
		errorResponse.setErrors(errorItems);
		errorResponse.setCode(code);
		errorResponse.setMessage(message);
		errorResponse.setResponseCode(responseCode);
		return errorResponse;
	}

}
