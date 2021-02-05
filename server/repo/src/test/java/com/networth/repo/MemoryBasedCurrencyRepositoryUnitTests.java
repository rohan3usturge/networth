package com.networth.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import com.networth.models.Currency;

import org.junit.jupiter.api.Test;

public class MemoryBasedCurrencyRepositoryUnitTests {

    @Test
    public void shouldReturnCurrencyFromMemory() {

        CurrencyRepository repo = new MemoryBasedCurrencyRepository();
        List<Currency> currencies = repo.getAll();
        assertNotNull(currencies);
        assertEquals(10, currencies.size());
    }
}
