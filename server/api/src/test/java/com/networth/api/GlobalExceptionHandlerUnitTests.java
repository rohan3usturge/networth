package com.networth.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.networth.infra.exception.ErrorResponse;
import com.networth.infra.exception.ErrorResponseGenerator;

import org.junit.Test;
import org.mockito.Mockito;

public class GlobalExceptionHandlerUnitTests {

    @Test
    public void test() throws IOException, ServletException {
        ErrorResponseGenerator generator = Mockito.mock(ErrorResponseGenerator.class);
        ServletRequest request = Mockito.mock(ServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        PrintWriter printer = Mockito.mock(PrintWriter.class);
        FilterChain chain = Mockito.mock(FilterChain.class);
        Filter filter = new GlobalExceptionHandler(generator);
        Exception ex = new RuntimeException();
        ErrorResponse errorResponse = new ErrorResponse();
        Mockito.when(generator.convert(ex)).thenReturn(errorResponse);
        Mockito.doThrow(ex).when(chain).doFilter(request, response);
        Mockito.when(response.getWriter()).thenReturn(printer);
        filter.doFilter(request, response, chain);

        verify(generator, times(1)).convert(any());
        verify(response, times(1)).setContentType(any());
        verify(printer, times(1)).write(anyString());

    }

}
