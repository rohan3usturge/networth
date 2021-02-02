package com.networth.api;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.networth.infra.exception.ErrorResponse;
import com.networth.infra.exception.ErrorResponseGenerator;

@Component
@Order(-1000)
public class GlobalExceptionHandler implements Filter {

	private ErrorResponseGenerator errorGenerator;

	public GlobalExceptionHandler(ErrorResponseGenerator errorGenerator) {
		super();
		this.errorGenerator = errorGenerator;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		try {
			chain.doFilter(request, response);
		} catch (Exception ex) {
			String correlationId = httpRequest.getHeader("x-correlation-id");
			ErrorResponse errorResponse = errorGenerator.convert(ex);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(errorResponse);
			httpResponse.setStatus(errorResponse.getResponseCode());
			httpResponse.setHeader("x-correlation-id", correlationId);
			httpResponse.setContentType(MediaType.APPLICATION_JSON.toString());
			httpResponse.getWriter().write(json);
		}
	}
}
