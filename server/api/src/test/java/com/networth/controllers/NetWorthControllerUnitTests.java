package com.networth.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.networth.builder.CurrencyBuilder;
import com.networth.dto.NetWorthRequestDto;
import com.networth.dto.NetWorthResponseDto;
import com.networth.models.Currency;
import com.networth.svc.CurrencyService;
import com.networth.svc.NetWorthService;
import com.networth.svc.models.PortfolioDm;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class NetWorthControllerUnitTests {

    @Test
    public void shouldCallServiceWithCorrectParameterAndReturn() {

        // Arrange
        NetWorthService nwServiceMock = Mockito.mock(NetWorthService.class);
        NetWorthController controller = new NetWorthController(nwServiceMock, null);
        PortfolioDm portfolio = new PortfolioDm();
        String targetCurrencyCode = "CHF";

        Mockito.when(nwServiceMock.calculate(targetCurrencyCode, portfolio)).thenReturn(portfolio);
        NetWorthRequestDto request = new NetWorthRequestDto();
        request.setTargetCurrencyCode(targetCurrencyCode);
        request.setPortfolio(portfolio);

        // ACT
        NetWorthResponseDto response = controller.calculateNetWorth(request);

        // ASSERT
        verify(nwServiceMock, times(1)).calculate(targetCurrencyCode, portfolio);
        assertNotNull(response);
        assertEquals(portfolio, response.getPortfolio());
    }

    @Test
    public void shouldDispatchServiceExceptionsUp() {

        // Arrange
        NetWorthService nwServiceMock = Mockito.mock(NetWorthService.class);
        NetWorthController controller = new NetWorthController(nwServiceMock, null);
        PortfolioDm portfolio = new PortfolioDm();
        String targetCurrencyCode = "CHF";

        RuntimeException runtimeException = new RuntimeException();
        Mockito.when(nwServiceMock.calculate(targetCurrencyCode, portfolio)).thenThrow(runtimeException);
        NetWorthRequestDto request = new NetWorthRequestDto();
        request.setTargetCurrencyCode(targetCurrencyCode);
        request.setPortfolio(portfolio);

        // ACT and Assert
        try {
            controller.calculateNetWorth(request);
        } catch (Exception ex) {
            assertEquals(runtimeException, ex);
        }
    }

    @Test
    public void shouldGetCurrenciesReturnCorrectly() {

        // Arrange
        List<Currency> dummyCurrs = new ArrayList<>();
        dummyCurrs.add(new CurrencyBuilder().currencyCode("TEST").exchangeRate(2.0).build());
        CurrencyService currencyServiceMock = Mockito.mock(CurrencyService.class);
        NetWorthController controller = new NetWorthController(null, currencyServiceMock);
        when(currencyServiceMock.getAll()).thenReturn(dummyCurrs);

        // ACT
        Collection<String> currencies = controller.getSupportedCurrencies();

        // ASSET
        assertNotNull(currencies);
        assertEquals(1, currencies.size());
        assertEquals("TEST", currencies.iterator().next());
    }

    @Test
    public void shouldGetCurrenciesPropageException() {

        // Arrange
        List<Currency> dummyCurrs = new ArrayList<>();
        dummyCurrs.add(new CurrencyBuilder().currencyCode("TEST").exchangeRate(2.0).build());
        CurrencyService currencyServiceMock = Mockito.mock(CurrencyService.class);
        NetWorthController controller = new NetWorthController(null, currencyServiceMock);
        RuntimeException runtimeException = new RuntimeException();
        when(currencyServiceMock.getAll()).thenThrow(runtimeException);

        // ACT and Assert
        try {
            controller.getSupportedCurrencies();
        } catch (Exception ex) {
            assertEquals(runtimeException, ex);
        }
    }
}
