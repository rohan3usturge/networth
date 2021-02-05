package com.networth.svc;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.networth.builder.CurrencyBuilder;
import com.networth.infra.exception.ApiException;
import com.networth.models.Currency;
import com.networth.repo.CurrencyRepository;

import org.junit.Test;
import org.mockito.Mockito;

public class DefaultCurrencyServiceUnitTests {

    @Test
    public void shouldCallRepository() {
        CurrencyRepository repo = Mockito.mock(CurrencyRepository.class);
        CurrencyService service = new DefaultCurrencyService(repo);
        service.getAll();
        verify(repo, times(1)).getAll();
    }

    @Test
    public void shouldReturnTheValueBackIfCurrencyCodeIsNull() {
        CurrencyRepository repo = Mockito.mock(CurrencyRepository.class);
        CurrencyService service = new DefaultCurrencyService(repo);
        assertEquals(2.0, service.convert(2.0, null, null));
        assertEquals(null, service.convert(null, null, null));
        assertEquals(2.0, service.convert(2.0, null, "CHF"));
        assertEquals(2.0, service.convert(2.0, "CHF", null));
        assertEquals(2.0, service.convert(2.0, "CHF", "CHF"));
        assertEquals(2.0, service.convert(2.0, "CHF", "chf"));
    }

    @Test
    public void shouldReturnTheExchangeRateIfRatesAreAvailable() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new CurrencyBuilder().currencyCode("CAD").exchangeRate(1.0).build());
        currencies.add(new CurrencyBuilder().currencyCode("USD").exchangeRate(0.5).build());
        CurrencyRepository repo = Mockito.mock(CurrencyRepository.class);
        when(repo.getAll()).thenReturn(currencies);
        CurrencyService service = new DefaultCurrencyService(repo);
        assertEquals(0.5, service.convert(1.0, "CAD", "USD"));
        assertEquals(4.0, service.convert(2.0, "USD", "CAD"));
    }

    @Test
    public void shouldThrowExcpetionIfRatesAreNotAvailable() {
        List<Currency> currencies = new ArrayList<>();
        currencies.add(new CurrencyBuilder().currencyCode("USD").exchangeRate(0.5).build());
        CurrencyRepository repo = Mockito.mock(CurrencyRepository.class);
        when(repo.getAll()).thenReturn(currencies);
        CurrencyService service = new DefaultCurrencyService(repo);
        assertThrows(ApiException.class, () -> service.convert(1.0, "CAD", "USD"));
        assertThrows(ApiException.class, () -> service.convert(1.0, "USD", "CAD"));
    }

    @Test
    public void shouldThrowExcpetionIfNoRatesAreAvailable() {
        CurrencyRepository repo = Mockito.mock(CurrencyRepository.class);
        when(repo.getAll()).thenReturn(null);
        CurrencyService service = new DefaultCurrencyService(repo);
        assertThrows(ApiException.class, () -> service.convert(1.0, "CAD", "USD"));
    }

}
