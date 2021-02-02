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
			switch (apiException.getApiExceptionType()) {
			case VALIDATION:
				responseCode = 400;
				break;
			case NOTFOUND:
				responseCode = 404;
				break;
			case DB:
				responseCode = 500;
				break;
			case UNAUTHENTICATED:
				responseCode = 401;
				break;
			case UNAUTHORIZED:
				responseCode = 403;
				break;
			default:
				break;
			}

		}
		errorResponse.setErrors(errorItems);
		errorResponse.setCode(code);
		errorResponse.setMessage(message);
		errorResponse.setResponseCode(responseCode);
		return errorResponse;
	}

}
