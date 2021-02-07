package com.networth.svc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.networth.svc.calculators.NetWorthCalculator;
import com.networth.svc.models.PortfolioDm;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DefaultNetWorthServiceUnitTests {

    @Test
    public void shouldDeletegateCalculationToNetWorthCalculator() {
        NetWorthCalculator calculator = Mockito.mock(NetWorthCalculator.class);
        NetWorthService service = new DefaultNetWorthService(calculator);
        PortfolioDm portfolio = new PortfolioDm();
        PortfolioDm returned = new PortfolioDm();
        when(calculator.calculate("CHF", portfolio)).thenReturn(returned);
        PortfolioDm actual = service.calculate("CHF", portfolio);
        verify(calculator, times(1)).calculate("CHF", portfolio);
        assertEquals(returned, actual);
    }

}
