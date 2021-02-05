package com.networth.svc.calculators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import com.networth.svc.models.AssetCategoryDm;
import com.networth.svc.models.LiabilityCategoryDm;
import com.networth.svc.models.LineItemsContainerDm;
import com.networth.svc.models.PortfolioDm;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DefaultNetWorthCalculatorUnitTests {

    @Test
    public void shouldReturnPortfolioCurrencyIfTargetIsNull() {
        PortfolioDm portfolioDm = new PortfolioDm();
        NetWorthCalculator calculator = new DefaultNetWorthCalculator(null, null);
        assertNotNull(calculator.calculate(null, portfolioDm));
    }

    @Test
    public void shouldReturnNullIfNullPortfolioIsProvided() {
        NetWorthCalculator calculator = new DefaultNetWorthCalculator(null, null);
        assertNull(calculator.calculate("CHF", null));
    }

    @Test
    public void shouldNotCalculateIfNullLineItems() {
        AssetCalculator assetCalculator = Mockito.mock(AssetCalculator.class);
        LiabilityCalculator liablitiCalculator = Mockito.mock(LiabilityCalculator.class);
        NetWorthCalculator calculator = new DefaultNetWorthCalculator(assetCalculator, liablitiCalculator);
        PortfolioDm portfolio = new PortfolioDm();
        calculator.calculate("CHF", portfolio);
        verify(assetCalculator, times(0)).calculate(any());
        verify(liablitiCalculator, times(0)).calculate(any());
    }

    @Test
    public void shouldNotCalculateIfNullAssetsAndLiablities() {
        AssetCalculator assetCalculator = Mockito.mock(AssetCalculator.class);
        LiabilityCalculator liablitiCalculator = Mockito.mock(LiabilityCalculator.class);
        NetWorthCalculator calculator = new DefaultNetWorthCalculator(assetCalculator, liablitiCalculator);
        PortfolioDm portfolio = new PortfolioDm();
        LineItemsContainerDm lineItems = new LineItemsContainerDm();
        lineItems.setAssets(null);
        lineItems.setLiabilities(null);
        portfolio.setLineItems(lineItems);
        calculator.calculate("CHF", portfolio);
        verify(assetCalculator, times(0)).calculate(any());
        verify(liablitiCalculator, times(0)).calculate(any());
    }

    @Test
    public void shouldNotCalculateIfEmptyLineItems() {
        AssetCalculator assetCalculator = Mockito.mock(AssetCalculator.class);
        LiabilityCalculator liablitiCalculator = Mockito.mock(LiabilityCalculator.class);
        NetWorthCalculator calculator = new DefaultNetWorthCalculator(assetCalculator, liablitiCalculator);
        PortfolioDm portfolio = new PortfolioDm();
        LineItemsContainerDm lineItems = new LineItemsContainerDm();
        lineItems.setAssets(new ArrayList<>());
        lineItems.setLiabilities(new ArrayList<>());
        portfolio.setLineItems(lineItems);
        PortfolioDm returned = calculator.calculate("CHF", portfolio);
        assertEquals(0.0, returned.getNetWorth().getTotalNetWorth());
        verify(assetCalculator, times(0)).calculate(any());
        verify(liablitiCalculator, times(0)).calculate(any());
    }

    @Test
    public void shouldCallDelegateCalculatorsAndReturn() {
        AssetCalculator assetCalculator = Mockito.mock(AssetCalculator.class);
        LiabilityCalculator liablitiCalculator = Mockito.mock(LiabilityCalculator.class);
        NetWorthCalculator calculator = new DefaultNetWorthCalculator(assetCalculator, liablitiCalculator);
        PortfolioDm portfolio = new PortfolioDm();
        LineItemsContainerDm lineItems = new LineItemsContainerDm();

        ArrayList<AssetCategoryDm> assets = new ArrayList<>();
        AssetCategoryDm assetCategory = new AssetCategoryDm();
        assets.add(assetCategory);
        lineItems.setAssets(assets);

        ArrayList<LiabilityCategoryDm> liabilities = new ArrayList<>();
        LiabilityCategoryDm liabilityCategory = new LiabilityCategoryDm();
        liabilities.add(liabilityCategory);
        lineItems.setLiabilities(liabilities);
        portfolio.setLineItems(lineItems);

        when(assetCalculator.calculate(any())).thenReturn(100.0);
        when(liablitiCalculator.calculate(any())).thenReturn(10.0);

        PortfolioDm returned = calculator.calculate("CHF", portfolio);
        assertEquals(100.0, returned.getNetWorth().getTotalAssets());
        assertEquals(10.0, returned.getNetWorth().getTotalLiabilities());
        assertEquals(90.0, returned.getNetWorth().getTotalNetWorth());
        verify(assetCalculator, times(1)).calculate(any());
        verify(liablitiCalculator, times(1)).calculate(any());
    }
}