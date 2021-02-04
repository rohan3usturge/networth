package com.networth.infra.exception;

public interface ErrorResponseGenerator {
	ErrorResponse convert(Throwable ex);
}
