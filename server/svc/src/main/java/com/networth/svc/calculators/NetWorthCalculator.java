package com.networth.svc.calculators;

import com.networth.svc.models.PortfolioDm;

public interface NetWorthCalculator {
    public PortfolioDm calculate(String targetCurrencyCode, PortfolioDm portfolio);
}
