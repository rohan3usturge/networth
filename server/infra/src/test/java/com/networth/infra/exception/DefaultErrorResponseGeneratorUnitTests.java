package com.networth.infra.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("UnitTest")
public class DefaultErrorResponseGeneratorUnitTests {

    @Test
    public void shouldReturnCorrectResponseBasedOnValidationException() {

        ErrorResponseGenerator generator = new DefaultErrorResponseGenerator();
        String code = "TEST";
        String message = "TEST MESSAGE";
        ArrayList<ErrorItem> errorItems = new ArrayList<>();
        ErrorResponse converted = generator
                .convert(new ApiException(ApiExceptionType.VALIDATION, code, message, errorItems));

        assertNotNull(converted);
        assertEquals(400, converted.getResponseCode());
        assertEquals(code, converted.getCode());
        assertEquals(message, converted.getMessage());
        assertEquals(errorItems, converted.getErrors());

    }

    @Test
    public void shouldReturnCorrectResponseBasedOnDbException() {

        ErrorResponseGenerator generator = new DefaultErrorResponseGenerator();
        String code = "TEST";
        String message = "TEST MESSAGE";
        ErrorResponse converted = generator.convert(new ApiException(ApiExceptionType.DB, code, message));

        assertNotNull(converted);
        assertEquals(500, converted.getResponseCode());
        assertEquals(code, converted.getCode());
        assertEquals(message, converted.getMessage());
        assertEquals(null, converted.getErrors());
    }

    @Test
    public void shouldReturnCorrectResponseForGenericRepons() {

        ErrorResponseGenerator generator = new DefaultErrorResponseGenerator();
        String code = "InternalServerError";
        String message = "Something went wrong while processing the request";
        ErrorResponse converted = generator.convert(new Exception());
        assertNotNull(converted);
        assertEquals(500, converted.getResponseCode());
        assertEquals(code, converted.getCode());
        assertEquals(message, converted.getMessage());
        assertEquals(null, converted.getErrors());

    }

    @Test
    public void shouldGetAllValues() {
        ApiExceptionType[] values = ApiExceptionType.values();
        assertEquals(2, values.length);
        assertEquals(ApiExceptionType.DB, ApiExceptionType.valueOf("DB"));

    }

}
