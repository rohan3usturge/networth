package com.networth.svc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.networth.infra.mapper.InfraMapper;
import com.networth.models.LineItemsContainer;
import com.networth.repo.NetWorthRepository;
import com.networth.svc.calculators.NetWorthCalculator;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.PortfolioDm;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DefaultNetWorthServiceUnitTests {

    @Test
    public void shouldDeletegateCalculationToNetWorthCalculator() {
        NetWorthCalculator calculator = Mockito.mock(NetWorthCalculator.class);
        NetWorthService service = new DefaultNetWorthService(null, calculator, null);
        PortfolioDm portfolio = new PortfolioDm();
        PortfolioDm returned = new PortfolioDm();
        when(calculator.calculate("CHF", portfolio)).thenReturn(returned);
        PortfolioDm actual = service.calculate("CHF", portfolio);
        verify(calculator, times(1)).calculate("CHF", portfolio);
        assertEquals(returned, actual);
    }

    @Test
    public void shouldReturnLineItemsFromRepository() {
        NetWorthRepository repo = Mockito.mock(NetWorthRepository.class);
        InfraMapper mapper = Mockito.mock(InfraMapper.class);
        NetWorthService service = new DefaultNetWorthService(repo, null, mapper);
        LineItemsContainer container = new LineItemsContainer();
        LineItemsContainerDm returned = new LineItemsContainerDm();
        when(repo.getLineItemsContainer()).thenReturn(container);
        when(mapper.map(container, LineItemsContainerDm.class)).thenReturn(returned);

        LineItemsContainerDm actual = service.getLineItemsContainer();
        verify(repo, times(1)).getLineItemsContainer();
        verify(mapper, times(1)).map(container, LineItemsContainerDm.class);
        assertEquals(returned, actual);
    }

}
