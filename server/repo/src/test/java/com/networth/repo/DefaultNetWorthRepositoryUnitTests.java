package com.networth.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.networth.infra.exception.ApiException;
import com.networth.infra.exception.ApiExceptionType;
import com.networth.models.LineItemsContainer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class DefaultNetWorthRepositoryUnitTests {

    @Test
    public void shouldReturnDataFromJsonFile() throws IOException {

        Resource jsonFile = Mockito.mock(Resource.class);
        NetWorthRepository repo = new DefaultNetWorthRepository(jsonFile);
        String json = "{\"assets\":[], \"liabilities\": [] }";
        InputStream stream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
        when(jsonFile.getInputStream()).thenReturn(stream);
        LineItemsContainer lineItemsContainer = repo.getLineItemsContainer();
        assertNotNull(lineItemsContainer);
        assertNotNull(lineItemsContainer.getAssets());
        assertNotNull(lineItemsContainer.getLiabilities());
        assertEquals(0, lineItemsContainer.getAssets().size());
        assertEquals(0, lineItemsContainer.getLiabilities().size());
    }

    @Test
    public void shouldRaiseApiExceptionIfIoException() throws IOException {

        Resource jsonFile = Mockito.mock(Resource.class);
        NetWorthRepository repo = new DefaultNetWorthRepository(jsonFile);
        when(jsonFile.getInputStream()).thenThrow(new IOException());
        try {
            repo.getLineItemsContainer();
            assertEquals(true, jsonFile instanceof ClassPathResource);
        } catch (Exception e) {
            assertEquals(true, e instanceof ApiException);
            ApiException apiException = (ApiException) e;
            assertEquals(ApiExceptionType.DB, apiException.getApiExceptionType());
        }
    }

}
